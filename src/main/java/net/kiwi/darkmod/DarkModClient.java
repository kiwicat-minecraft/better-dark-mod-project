package net.kiwi.darkmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.util.ModModelPredicats;
import net.minecraft.client.render.RenderLayer;

public class DarkModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_BRICK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_BRICK_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOIDCARROT_CROP, RenderLayer.getCutout());

        ModModelPredicats.registerModelPredicates();
    }
}
