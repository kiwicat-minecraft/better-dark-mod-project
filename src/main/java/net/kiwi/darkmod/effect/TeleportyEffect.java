package net.kiwi.darkmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TeleportyEffect extends StatusEffect {
    public TeleportyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (!world.isClient) {
            double range = 0.5 + amplifier * 0.2;
            double dx = (world.getRandom().nextDouble() - 0.5) * 2 * range;
            double dz = (world.getRandom().nextDouble() - 0.5) * 2 * range;
            double dy = (world.getRandom().nextDouble() - 0.5) * 2 * range;

            Vec3d newPos = entity.getPos().add(dx, dy, dz);
            entity.requestTeleport(newPos.x, newPos.y, newPos.z);
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
