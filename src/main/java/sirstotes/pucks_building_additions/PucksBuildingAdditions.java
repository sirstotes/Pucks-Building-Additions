package sirstotes.pucks_building_additions;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PucksBuildingAdditions implements ModInitializer {
	private static EntityType<SittableEntity> registerEntity(String id, EntityType.Builder<SittableEntity> type) {
		RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(MOD_ID, id));
		return Registry.register(Registries.ENTITY_TYPE, key, type.build(key));
	}

	public static final String MOD_ID = "pucks_building_additions";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<SittableEntity> SITTABLE = registerEntity("sittable", EntityType.Builder.create(SittableEntity::new, SpawnGroup.MISC).dimensions(1f, 0.5625f).disableSummon().dropsNothing().makeFireImmune());

	@Override
	public void onInitialize() {
		PucksBuildingAdditionsBlocks.initialize();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}