package com.jdkd.automata.entities.automaton;

import com.jdkd.automata.items.parts.AutomatonMaterial;
import com.jdkd.automata.items.parts.AutomatonPart;
import com.jdkd.automata.items.parts.AutomatonPartType;
import com.jdkd.automata.utils.MaterialUtil;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import java.util.HashMap;
import java.util.Map;

public class AutomataModelCache {

    private static final Map<String, ModelRenderer> renders = new HashMap<>();
    private static ModelBase modelBase;
    private static float scale, rotation;

    public static void initialise(ModelBase modelBaseIn, float scaleIn, float rotationIn) {

        modelBase = modelBaseIn;
        scale = scaleIn;
        rotation = rotationIn;

        for (AutomatonPartType part : AutomatonPartType.values()) {
            for (AutomatonMaterial material : AutomatonMaterial.values()) {
                cachePart(part, material, false);
                cachePart(part, material, true);
            }
        }
    }

    public static ModelRenderer getModelRenderer(AutomatonPart part, boolean hasLegs){
        String key = getKey(part.getPartType(), part.getMaterial(), hasLegs);

        return renders.get(key);
    }

    public static ModelRenderer getSidedModelRenderer(AutomatonPart part, boolean hasLegs, String side){
        String key = getKeySidedObject(part.getPartType(), part.getMaterial(), hasLegs, side);

        return renders.get(key);
    }

    private static String getKey(AutomatonPartType type, AutomatonMaterial material, boolean hasLegs) {
        StringBuilder sb = new StringBuilder();
        sb.append(type.name());
        sb.append("_");
        sb.append(material.name());
        sb.append("_");
        sb.append(hasLegs);

        return sb.toString();
    }

    private static String getKeySidedObject(AutomatonPartType type, AutomatonMaterial material, boolean hasLegs, String side){
        String baseKey = getKey(type, material, hasLegs);

        return baseKey + "_" + side;
    }

    private static void cachePart(AutomatonPartType part, AutomatonMaterial material, boolean hasLegs) {
        int xOffset = MaterialUtil.getMaterialTextureXOffset(material);
        int yOffset = AutomatonPartType.LEG.equals(part) ? MaterialUtil.getMaterialTextureYOffsetLegs(material) : MaterialUtil.getMaterialTextureYOffset(material);
        int heightOffset = getHeightOffset(hasLegs);

        String key = getKey(part, material, hasLegs);
        ModelRenderer renderer = createModelRenderer();

        switch (part) {
            case BODY:
                createShellModelRenderer(renderer, xOffset, yOffset, scale, rotation, heightOffset);
                renders.put(key, renderer);
                break;
            case HEAD:
                createHeadModelRenderer(renderer, xOffset, yOffset, scale, rotation, heightOffset);
                renders.put(key, renderer);
                break;
            case LEG:
                createLeftLegModelRenderer(renderer, xOffset, yOffset, scale, rotation);
                renders.put(getKeySidedObject(part, material, hasLegs, "LEFT"), renderer);

                ModelRenderer rightLeg = createModelRenderer();
                createRightLegModelRenderer(rightLeg, xOffset, yOffset, scale, rotation);
                renders.put(getKeySidedObject(part, material, hasLegs, "RIGHT"), rightLeg);
                break;
            case ARM:
                createLeftArmModelRenderer(renderer, xOffset, yOffset, scale, rotation, heightOffset);
                renders.put(getKeySidedObject(part, material, hasLegs, "LEFT"), renderer);

                ModelRenderer rightArm = createModelRenderer();
                createRightArmModelRenderer(rightArm, xOffset, yOffset, scale, rotation, heightOffset);
                renders.put(getKeySidedObject(part, material, hasLegs, "RIGHT"), rightArm);
                break;
        }
    }

    private static void createHeadModelRenderer(ModelRenderer modelRenderer, int xOffset, int yOffset, float scale, float rotation, int heightOffset) {
        modelRenderer.setRotationPoint(0.0F, 0.0F + rotation, -2.0F);
        modelRenderer.setTextureOffset(0 + xOffset, 0 + yOffset).addBox(-4.0F, -3F + heightOffset, -5.5F, 8, 10, 8, scale);
        modelRenderer.setTextureOffset(24 + xOffset, 0 + yOffset).addBox(-1.0F, 4.0F + heightOffset, -7.5F, 2, 4, 2, scale);
    }

    private static void createShellModelRenderer(ModelRenderer modelRenderer, int xOffset, int yOffset, float scale, float rotation, int heightOffset) {
        modelRenderer.setRotationPoint(0.0F, 0.0F + rotation, 0.0F);
        modelRenderer.setTextureOffset(0 + xOffset, 40 + yOffset).addBox(-9.0F, 7.0F + heightOffset, -6.0F, 18, 12, 11, scale);
        modelRenderer.setTextureOffset(0 + xOffset, 70 + yOffset).addBox(-4.5F, 19.0F + heightOffset, -3.0F, 9, 5, 6, scale + 0.5F);
        modelRenderer.setTextureOffset(0 + xOffset, 40 + yOffset).addBox(-9.0F, 23.0F + heightOffset, -6.0f, 18, 4, 11, scale);

    }

    private static void createLeftArmModelRenderer(ModelRenderer modelRenderer, int xOffset, int yOffset, float scale, float rotation, int heightOffset) {
        modelRenderer.setRotationPoint(0.0F, -7.0F, 0.0F);
        modelRenderer.setTextureOffset(60 + xOffset, 58 + yOffset).addBox(9.0F, 10.5F + heightOffset, -3.0F, 4, 17, 6, scale);
    }

    private static void createRightArmModelRenderer(ModelRenderer modelRenderer, int xOffset, int yOffset, float scale, float rotation, int heightOffset) {
        modelRenderer.setRotationPoint(0.0F, -7.0F, 0.0F);
        modelRenderer.setTextureOffset(60 + xOffset, 21 + yOffset).addBox(-13.0F, 10.5F + heightOffset, -3.0F, 4, 17, 6, scale);
    }

    private static void createLeftLegModelRenderer(ModelRenderer modelRenderer, int xOffset, int yOffset, float scale, float rotation) {
        modelRenderer.setRotationPoint(-4.0F, 18.0F + rotation, 0.0F);
        modelRenderer.setTextureOffset(37 + xOffset, 0 + yOffset).addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, scale);
    }

    private static void createRightLegModelRenderer(ModelRenderer modelRenderer, int xOffset, int yOffset, float scale, float rotation) {
        modelRenderer.mirror = true;
        modelRenderer.setTextureOffset(60 + xOffset, 0 + yOffset).setRotationPoint(5.0F, 18.0F + rotation, 0.0F);
        modelRenderer.addBox(-3.5F, -3.0F, -3.0F, 6, 16, 5, scale);
    }

    private static int getHeightOffset(boolean hasLegs) {
        return hasLegs ? -9 : 0;
    }

    private static ModelRenderer createModelRenderer(){
        return new ModelRenderer(modelBase).setTextureSize(256, 256);
    }
}
