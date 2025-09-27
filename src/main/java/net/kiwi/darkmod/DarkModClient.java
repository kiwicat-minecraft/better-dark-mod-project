package net.kiwi.darkmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kiwi.darkmod.block.ModBlocks;
import net.kiwi.darkmod.entity.ModEntities;
import net.kiwi.darkmod.entity.client.KiwiModel;
import net.kiwi.darkmod.entity.client.KiwiRenderer;
import net.kiwi.darkmod.util.ModModelPredicats;
import net.minecraft.client.render.RenderLayer;

public class DarkModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_BRICK_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_BRICK_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOIDCARROT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VOID_BERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STATUE, RenderLayer.getCutout());

        ModModelPredicats.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(KiwiModel.KIWI, KiwiModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.KIWI, KiwiRenderer::new);
    }
}
