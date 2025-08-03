package net.kiwi.darkmod;


import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.component.ModDataComponentTypes;
import net.kiwi.darkmod.item.ModItemGroups;
import net.kiwi.darkmod.item.ModItems;
import net.kiwi.darkmod.sound.ModSounds;
import net.kiwi.darkmod.util.HammerUsageEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterDarkMod implements ModInitializer {
	public static final String MOD_ID = "better-dark-mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	private static final String ALLOWED_PLAYER = "Kiwicat0_0";

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		ModDataComponentTypes.registerDataComponentTypes();

		ModSounds.registerSounds();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof PlayerEntity playerEntity && !world.isClient()) {
				if (player.getMainHandStack().getItem() == ModItems.VOID_STAFF) {
					playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20, 3));

				}
				return ActionResult.PASS;
			}
            return ActionResult.PASS;
        });




	}
}