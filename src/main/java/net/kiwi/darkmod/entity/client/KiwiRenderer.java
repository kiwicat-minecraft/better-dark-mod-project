package net.kiwi.darkmod.entity.client;

import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.entity.custom.KiwiEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class KiwiRenderer extends MobEntityRenderer<KiwiEntity, KiwiModel<KiwiEntity>> {
    public KiwiRenderer(EntityRendererFactory.Context context) {
        super(context, new KiwiModel<>(context.getPart(KiwiModel.KIWI)), 0.5f);
    }

    @Override
    public Identifier getTexture(KiwiEntity entity) {
        return Identifier.of(BetterDarkMod.MOD_ID, "textures/entity/kiwi/kiwi_texture.png");
    }

    @Override
    public void render(KiwiEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
