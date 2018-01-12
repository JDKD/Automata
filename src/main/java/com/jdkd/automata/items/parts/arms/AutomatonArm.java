package com.jdkd.automata.items.parts.arms;

import com.jdkd.automata.items.parts.AutomatonPart;

public interface AutomatonArm extends AutomatonPart{

    int getMaxReachDistance();
    boolean canConductRedstone();

}
