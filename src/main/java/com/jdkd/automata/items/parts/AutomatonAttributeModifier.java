package com.jdkd.automata.items.parts;

import net.minecraft.entity.EntityLivingBase;

public interface AutomatonAttributeModifier {

    void modifyAttribute(EntityLivingBase toModify);
    void unmodifyAttribute(EntityLivingBase toUnModify);

}
