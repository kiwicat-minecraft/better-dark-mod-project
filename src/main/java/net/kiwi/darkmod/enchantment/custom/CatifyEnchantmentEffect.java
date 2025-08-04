package net.kiwi.darkmod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record CatifyEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<CatifyEnchantmentEffect> CODEC = MapCodec.unit(CatifyEnchantmentEffect::new);



    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(level == 1){
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
        if(level == 2){
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
        if(level == 3){
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
        if(level == 255){
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
            EntityType.CAT.spawn(world, user.getBlockPos(), SpawnReason.TRIGGERED);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
