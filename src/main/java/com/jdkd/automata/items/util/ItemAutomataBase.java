package com.jdkd.automata.items.util;

import com.jdkd.automata.AutomataMain;
import net.minecraft.item.Item;

public class ItemAutomataBase extends Item{

    public ItemAutomataBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AutomataMain.tab);
    }
}
