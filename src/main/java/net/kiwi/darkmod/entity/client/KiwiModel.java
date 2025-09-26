package net.kiwi.darkmod.entity.client;

import net.kiwi.darkmod.BetterDarkMod;
import net.kiwi.darkmod.entity.custom.KiwiEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class KiwiModel<T extends KiwiEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer KIWI = new EntityModelLayer(Identifier.of(BetterDarkMod.MOD_ID, "kiwi"),"main");



    private final ModelPart root;
    private final ModelPart Head;
    private final ModelPart Ear;
    private final ModelPart Ear2;
    private final ModelPart Eyes;
    private final ModelPart Irises;
    private final ModelPart LeftIris;
    private final ModelPart RightIris;
    private final ModelPart Eyelids;
    private final ModelPart LeftEyelid;
    private final ModelPart LeftBrow;
    private final ModelPart RightEyelid;
    private final ModelPart RightBrow;
    private final ModelPart Body;
    private final ModelPart Tail;
    private final ModelPart physBoob1;
    private final ModelPart breats;
    private final ModelPart LeftArm;
    private final ModelPart RightArm;
    private final ModelPart LeftLeg;
    private final ModelPart LeftLeggingPivot;
    private final ModelPart LeftBootPivot;
    private final ModelPart RightLeg;
    private final ModelPart RightLeggingPivot;
    private final ModelPart RightBootPivot;
    public KiwiModel(ModelPart root) {
        this.root = root.getChild("root");
        this.Head = this.root.getChild("Head");
        this.Ear = this.Head.getChild("Ear");
        this.Ear2 = this.Head.getChild("Ear2");
        this.Eyes = this.Head.getChild("Eyes");
        this.Irises = this.Eyes.getChild("Irises");
        this.LeftIris = this.Irises.getChild("LeftIris");
        this.RightIris = this.Irises.getChild("RightIris");
        this.Eyelids = this.Eyes.getChild("Eyelids");
        this.LeftEyelid = this.Eyelids.getChild("LeftEyelid");
        this.LeftBrow = this.LeftEyelid.getChild("LeftBrow");
        this.RightEyelid = this.Eyelids.getChild("RightEyelid");
        this.RightBrow = this.RightEyelid.getChild("RightBrow");
        this.Body = this.root.getChild("Body");
        this.Tail = this.Body.getChild("Tail");
        this.physBoob1 = this.Body.getChild("physBoob1");
        this.breats = this.physBoob1.getChild("breats");
        this.LeftArm = this.root.getChild("LeftArm");
        this.RightArm = this.root.getChild("RightArm");
        this.LeftLeg = this.root.getChild("LeftLeg");
        this.LeftLeggingPivot = this.LeftLeg.getChild("LeftLeggingPivot");
        this.LeftBootPivot = this.LeftLeg.getChild("LeftBootPivot");
        this.RightLeg = this.root.getChild("RightLeg");
        this.RightLeggingPivot = this.RightLeg.getChild("RightLeggingPivot");
        this.RightBootPivot = this.RightLeg.getChild("RightBootPivot");
    }

    public KiwiModel(ModelPart root, ModelPart head, ModelPart ear, ModelPart ear2, ModelPart eyes, ModelPart irises, ModelPart leftIris, ModelPart rightIris, ModelPart eyelids, ModelPart leftEyelid, ModelPart leftBrow, ModelPart rightEyelid, ModelPart rightBrow, ModelPart body, ModelPart tail, ModelPart physBoob1, ModelPart breats, ModelPart leftArm, ModelPart rightArm, ModelPart leftLeg, ModelPart leftLeggingPivot, ModelPart leftBootPivot, ModelPart rightLeg, ModelPart rightLeggingPivot, ModelPart rightBootPivot) {
        this.root = root;
        Head = head;
        Ear = ear;
        Ear2 = ear2;
        Eyes = eyes;
        Irises = irises;
        LeftIris = leftIris;
        RightIris = rightIris;
        Eyelids = eyelids;
        LeftEyelid = leftEyelid;
        LeftBrow = leftBrow;
        RightEyelid = rightEyelid;
        RightBrow = rightBrow;
        Body = body;
        Tail = tail;
        this.physBoob1 = physBoob1;
        this.breats = breats;
        LeftArm = leftArm;
        RightArm = rightArm;
        LeftLeg = leftLeg;
        LeftLeggingPivot = leftLeggingPivot;
        LeftBootPivot = leftBootPivot;
        RightLeg = rightLeg;
        RightLeggingPivot = rightLeggingPivot;
        RightBootPivot = rightBootPivot;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData Head = root.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(32, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData Ear = Head.addChild("Ear", ModelPartBuilder.create().uv(81, 34).cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(94, 53).cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -5.0F, -5.0F, 0.2618F, 0.0F, -0.2618F));

        ModelPartData Ear2 = Head.addChild("Ear2", ModelPartBuilder.create().uv(81, 34).mirrored().cuboid(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                .uv(94, 53).mirrored().cuboid(-1.0F, -3.0F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, -5.0F, -5.0F, 0.2618F, 0.0F, 0.2618F));

        ModelPartData Eyes = Head.addChild("Eyes", ModelPartBuilder.create().uv(39, 87).cuboid(-4.0F, -1.0F, 0.03F, 8.0F, 4.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, -4.0F));

        ModelPartData Irises = Eyes.addChild("Irises", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 28.0F, 4.0F));

        ModelPartData LeftIris = Irises.addChild("LeftIris", ModelPartBuilder.create().uv(5, 4).cuboid(-0.5F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -28.0F, -3.98F));

        ModelPartData RightIris = Irises.addChild("RightIris", ModelPartBuilder.create().uv(2, 4).cuboid(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.5F, -26.0F, -3.98F));

        ModelPartData Eyelids = Eyes.addChild("Eyelids", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 28.0F, 4.0F));

        ModelPartData LeftEyelid = Eyelids.addChild("LeftEyelid", ModelPartBuilder.create().uv(1, 0).cuboid(-1.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -30.0F, -3.99F));

        ModelPartData LeftBrow = LeftEyelid.addChild("LeftBrow", ModelPartBuilder.create().uv(1, 0).cuboid(-1.0F, 1.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -0.02F));

        ModelPartData RightEyelid = Eyelids.addChild("RightEyelid", ModelPartBuilder.create().uv(1, 0).cuboid(-1.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -30.0F, -3.99F));

        ModelPartData RightBrow = RightEyelid.addChild("RightBrow", ModelPartBuilder.create().uv(1, 0).cuboid(-1.0F, 1.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.5F, -0.02F));

        ModelPartData Body = root.addChild("Body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData Tail = Body.addChild("Tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 12.0F, 1.75F));

        ModelPartData Tail_r1 = Tail.addChild("Tail_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.2929F, -0.2929F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

        ModelPartData physBoob1 = Body.addChild("physBoob1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

        ModelPartData breats = physBoob1.addChild("breats", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, -1.0F));

        ModelPartData breats_r1 = breats.addChild("breats_r1", ModelPartBuilder.create().uv(16, 19).cuboid(-4.0F, -1.2145F, -1.5088F, 8.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -1.0F, 0.6109F, 0.0F, 0.0F));

        ModelPartData LeftArm = root.addChild("LeftArm", ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(48, 48).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));

        ModelPartData RightArm = root.addChild("RightArm", ModelPartBuilder.create().uv(40, 16).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(40, 32).cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

        ModelPartData LeftLeg = root.addChild("LeftLeg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));

        ModelPartData LeftLeggingPivot = LeftLeg.addChild("LeftLeggingPivot", ModelPartBuilder.create(), ModelTransform.pivot(0.1F, 0.0F, 0.0F));

        ModelPartData LeftBootPivot = LeftLeg.addChild("LeftBootPivot", ModelPartBuilder.create(), ModelTransform.pivot(0.1F, 12.0F, 0.0F));

        ModelPartData RightLeg = root.addChild("RightLeg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.25F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

        ModelPartData RightLeggingPivot = RightLeg.addChild("RightLeggingPivot", ModelPartBuilder.create(), ModelTransform.pivot(-0.1F, 0.0F, 0.0F));

        ModelPartData RightBootPivot = RightLeg.addChild("RightBootPivot", ModelPartBuilder.create(), ModelTransform.pivot(-0.1F, 12.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(KiwiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(KiwiAnimations.KIWI_WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, KiwiAnimations.KIWI_IDLE, ageInTicks,1f);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.Head.yaw = headYaw * 0.017453292F;
        this.Head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}
