package com.jdkd.automata.items.parts;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.List;
import java.util.Map;

public interface AutomatonPart {

    AutomatonPartType getPartType();
    void setAttributeModifiers(List<AutomatonAttributeModifier> modifiers);
    List<AutomatonAttributeModifier> getAttributeModifiers();
    Map<Integer, EntityAIBase> getAITaskss();
    AutomatonMaterial getMaterial();

}
