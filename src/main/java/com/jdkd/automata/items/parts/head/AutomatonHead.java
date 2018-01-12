package com.jdkd.automata.items.parts.head;

import com.jdkd.automata.items.parts.AutomatonPart;
import net.minecraft.item.Item;

import java.util.List;

public interface AutomatonHead extends AutomatonPart {

    int getVisionRange();
    List<AutomatonLogic> getAllowedLogicTypes();
    AutomatonLogic getCurrentLogicType();
    List<Item> getLogicItems();

}
