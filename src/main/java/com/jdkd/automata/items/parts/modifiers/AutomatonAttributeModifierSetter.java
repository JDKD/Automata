package com.jdkd.automata.items.parts.modifiers;

import com.jdkd.automata.items.parts.AutomatonAttributeModifier;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.IAttribute;

public class AutomatonAttributeModifierSetter implements AutomatonAttributeModifier{

    private IAttribute attribute;
    private double value;

    public AutomatonAttributeModifierSetter(IAttribute attribute, double value) {
        this.attribute = attribute;
        this.value = value;
    }

    @Override
    public void modifyAttribute(EntityLivingBase toModify) {
        toModify.getEntityAttribute(attribute).setBaseValue(value);
    }

    @Override
    public void unmodifyAttribute(EntityLivingBase toUnModify) {
    }
}
