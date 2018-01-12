package com.jdkd.automata.items.parts.legs;

import com.jdkd.automata.items.parts.AutomatonPart;

public interface AutomatonLeg extends AutomatonPart{

    int getMaxMovementDistance();
    boolean canSwim();

}
