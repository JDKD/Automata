package com.jdkd.automata.items.parts.shell;

import com.jdkd.automata.items.parts.AutomatonPart;

public interface AutomatonShell extends AutomatonPart {

    int getMaxUpgrades();
    boolean canEquipPart(AutomatonPart part);

}
