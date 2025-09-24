package net.kiwi.darkmod;


import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.component.ModDataComponentTypes;
import net.kiwi.darkmod.effect.ModEffects;
import net.kiwi.darkmod.enchantment.ModEnchantmentEffects;
import net.kiwi.darkmod.enchantment.ModEnchantments;
import net.kiwi.darkmod.item.ModItemGroups;
import net.kiwi.darkmod.item.ModItems;
import net.kiwi.darkmod.potion.ModPotions;
import net.kiwi.darkmod.sound.ModSounds;
import net.kiwi.darkmod.util.HammerUsageEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Potions;
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

		ModEffects.registerEffects();

		ModPotions.registerPotions();

		ModEnchantmentEffects.registerEnchantmentEffects();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof PlayerEntity playerEntity && !world.isClient()) {
				if (player.getMainHandStack().getItem() == ModItems.VOID_STAFF) {
					playerEntity.addStatusEffect(new StatusEffectInstance(ModEffects.TELEPORTY, 2, 1));

				}
				return ActionResult.PASS;
			}
            return ActionResult.PASS;
        });
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof LivingEntity target && !world.isClient()) {
				if (player.getMainHandStack().getName().getString().equals("Invisible")) {

					target.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 0));
				}
			}
			return ActionResult.PASS;
		});


		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, ModItems.VOID_BERRY, ModPotions.TELEPORTY_POTION);
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.VOID_CARROT, 0.6f);
	CompostingChanceRegistry.INSTANCE.add(ModItems.VOIDCARROT_SEEDS, 0.3f);


	}
}