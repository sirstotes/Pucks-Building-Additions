package sirstotes.pucks_building_additions;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.Vec3i;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

@Environment(EnvType.CLIENT)
public class SpriteMultTexturedVertexConsumer implements VertexConsumer {
    private final VertexConsumer delegate;
    private final Sprite sprite;

    public SpriteMultTexturedVertexConsumer(VertexConsumer delegate, Sprite sprite) {
        this.delegate = delegate;
        this.sprite = sprite;
    }

    public VertexConsumer vertex(float x, float y, float z) {
        return this.delegate.vertex(x, y, z);
    }

    public VertexConsumer color(int red, int green, int blue, int alpha) {
        return this.delegate.color(red, green, blue, alpha);
    }

    public VertexConsumer texture(float u, float v) {
        return this.delegate.texture(u, v);
    }

    public VertexConsumer overlay(int u, int v) {
        return this.delegate.overlay(u, v);
        //return this.delegate.overlay((int) this.sprite.getFrameU(u), (int) this.sprite.getFrameV(v));
    }

    public VertexConsumer light(int u, int v) {
        return this.delegate.light(u, v);
    }

    public VertexConsumer normal(float x, float y, float z) {
        return this.delegate.normal(x, y, z);
    }

    public void vertex(float x, float y, float z, int color, float u, float v, int overlay, int light, float normalX, float normalY, float normalZ) {
        this.delegate.vertex(x, y, z, color, u, v, overlay, light, normalX, normalY, normalZ);
    }

    public void quad(MatrixStack.Entry matrixEntry, BakedQuad quad, float[] brightnesses, float red, float green, float blue, float f, int[] is, int i, boolean bl) {
        int[] js = quad.getVertexData();
        Vec3i vec3i = quad.getFace().getVector();
        Matrix4f matrix4f = matrixEntry.getPositionMatrix();
        Vector3f vector3f = matrixEntry.transformNormal((float)vec3i.getX(), (float)vec3i.getY(), (float)vec3i.getZ(), new Vector3f());

        int k = js.length / 8;
        int l = (int)(f * 255.0F);
        int m = quad.getLightEmission();
        MemoryStack memoryStack = MemoryStack.stackPush();

        try {
            ByteBuffer byteBuffer = memoryStack.malloc(VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL.getVertexSizeByte());
            IntBuffer intBuffer = byteBuffer.asIntBuffer();

            for(int n = 0; n < k; ++n) {
                intBuffer.clear();
                intBuffer.put(js, n * 8, 8);
                float g = byteBuffer.getFloat(0);
                float h = byteBuffer.getFloat(4);
                float o = byteBuffer.getFloat(8);
                float s;
                float t;
                float u;
                float r;
                if (bl) {
                    float p = (float)(byteBuffer.get(12) & 255);
                    float q = (float)(byteBuffer.get(13) & 255);
                    r = (float)(byteBuffer.get(14) & 255);
                    s = p * brightnesses[n] * red;
                    t = q * brightnesses[n] * green;
                    u = r * brightnesses[n] * blue;
                } else {
                    s = brightnesses[n] * red * 255.0F;
                    t = brightnesses[n] * green * 255.0F;
                    u = brightnesses[n] * blue * 255.0F;
                }

                //int v = ColorHelper.getArgb(l, (int)s, (int)t, (int)u);
                int v = ColorHelper.getArgb(l, 0, 0, 255);
                int w = LightmapTextureManager.applyEmission(is[n], m);
                r = byteBuffer.getFloat(16);
                float x = byteBuffer.getFloat(20);
                Vector3f vector3f2 = matrix4f.transformPosition(g, h, o, new Vector3f());
                this.vertex(vector3f2.x(), vector3f2.y(), vector3f2.z(), v, r, x, i, w, vector3f.x(), vector3f.y(), vector3f.z());
            }
        } catch (Throwable var35) {
            if (memoryStack != null) {
                try {
                    memoryStack.close();
                } catch (Throwable var34) {
                    var35.addSuppressed(var34);
                }
            }

            throw var35;
        }

        if (memoryStack != null) {
            memoryStack.close();
        }

    }
}
