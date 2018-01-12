package com.jdkd.automata.entities.automaton;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class RenderAutomata extends RenderLiving<EntityAutomata> {

    private static final ResourceLocation BASIC_AUTOMATA_TEXTURE = new ResourceLocation("automata","textures/entity/basic_automata.png");

    public RenderAutomata(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelAutomata(0.25f), 0.1f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityAutomata entity) {
        return BASIC_AUTOMATA_TEXTURE;
    }

    @Override
    protected void applyRotations(EntityAutomata entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);

        GlStateManager.scale(0.25f, 0.25f, 0.25f);

        if (entityLiving.limbSwingAmount >= 0.01f) {
            //  val f = 13.0f
            float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0f - partialTicks) + 6.0f;
            float f2 = (Math.abs(f1 % 13.0f - 6.5f) - 3.25f) / 3.25f;
            GlStateManager.rotate(6.5f * f2, 0.0f, 0.0f, 1.0f);
        }
    }
}
