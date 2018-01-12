package com.jdkd.automata.items.util;

import com.jdkd.automata.AutomataMain;
import net.minecraft.item.Item;

public class ItemAutomatonInspector extends Item {

    public ItemAutomatonInspector() {
        setUnlocalizedName("item_automaton_inspector");
        setRegistryName("item_automaton_inspector");
        setMaxStackSize(1);
        setCreativeTab(AutomataMain.tab);
    }
}
