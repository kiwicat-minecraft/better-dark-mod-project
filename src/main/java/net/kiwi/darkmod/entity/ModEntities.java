package net.kiwi.darkmod.entity;

import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.entity.custom.KiwiEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<KiwiEntity> KIWI = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BetterDarkMod.MOD_ID, "kiwi"),
            EntityType.Builder.create(KiwiEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f,1.99f).build());


    public static void registerModEntities() {
        BetterDarkMod.LOGGER.info("Registering Mod Entities for: " + BetterDarkMod.MOD_ID);
    }
}
