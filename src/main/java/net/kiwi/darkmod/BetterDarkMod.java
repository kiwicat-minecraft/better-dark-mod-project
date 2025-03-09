package net.kiwi.darkmod;


import net.fabricmc.api.ModInitializer;

import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.item.ModItemGroups;
import net.kiwi.darkmod.item.ModItems;
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




	}
}