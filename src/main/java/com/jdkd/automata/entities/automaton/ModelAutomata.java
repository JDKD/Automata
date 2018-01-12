package com.jdkd.automata.entities.automaton;

import com.jdkd.automata.items.parts.AutomatonPart;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAutomata extends ModelBase {

    //    private Map<Entity, AutomatonPartModelRendererFactory> factories;
    private float scale;
    private float rotation;

    public ModelAutomata(float scale) {
        this(scale, -7.0F);
    }

    public ModelAutomata(float scale, float rotation) {
        this.scale = scale;
        this.rotation = rotation;
        AutomataModelCache.initialise(this, scale, rotation);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (entityIn instanceof EntityAutomata) {

            EntityAutomata automata = (EntityAutomata) entityIn;
            automata.getAutomatonParts();
            boolean hasLegs = automata.getLeg() != null;

            AutomatonPart headPart = automata.getHead();
            AutomatonPart bodyPart = automata.getShell();
            AutomatonPart armPart = automata.getArm();
            AutomatonPart legPart = automata.getLeg();

            if (headPart != null) {
                ModelRenderer head = AutomataModelCache.getModelRenderer(headPart, hasLegs);
                head.rotateAngleY = netHeadYaw * 0.017453292F;
                head.rotateAngleX = headPitch * 0.017453292F;
                head.render(scale);
            }

            if (bodyPart != null) {
                AutomataModelCache.getModelRenderer(bodyPart, hasLegs).render(scale);
            }

            if (armPart != null) {
                AutomataModelCache.getSidedModelRenderer(armPart, hasLegs, "LEFT").render(scale);
                AutomataModelCache.getSidedModelRenderer(armPart, hasLegs, "RIGHT").render(scale);
            }

            if (legPart != null) {
                ModelRenderer leftLeft = AutomataModelCache.getSidedModelRenderer(legPart, hasLegs, "LEFT");
                leftLeft.rotateAngleX = -1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
                leftLeft.rotateAngleY = 0.0F;
                leftLeft.render(scale);

                ModelRenderer rightLeg = AutomataModelCache.getSidedModelRenderer(legPart, hasLegs, "RIGHT");
                rightLeg.rotateAngleX = 1.5F * this.triangleWave(limbSwing, 13.0F) * limbSwingAmount;
                rightLeg.rotateAngleY = 0.0F;
                rightLeg.render(scale);
            }
        }
    }

    private float triangleWave(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
