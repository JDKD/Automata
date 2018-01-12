package com.jdkd.automata.entities.automaton;

import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public class AutomatonAttributes {

    public static final IAttribute CARRY_CAPACITY = (new RangedAttribute((IAttribute)null, "automata.carryCapacity", 1.0D, Float.MIN_VALUE, 1024.0D)).setDescription("Max Carry Capacity").setShouldWatch(true);
    public static final IAttribute CONDUCTIVITY = (new RangedAttribute((IAttribute)null, "automata.conductivity", 1.0D, Float.MIN_VALUE, 1024.0D)).setDescription("Max Conductivity").setShouldWatch(true);
    public static final IAttribute INTELLIGENCE = (new RangedAttribute((IAttribute)null, "automata.intelligence", 1.0D, Float.MIN_VALUE, 1024.0D)).setDescription("Max Intelligence").setShouldWatch(true);

}
