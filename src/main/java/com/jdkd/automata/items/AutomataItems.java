package com.jdkd.automata.items;

import com.jdkd.automata.items.parts.AutomatonMaterial;
import com.jdkd.automata.items.parts.arms.ItemAutomatonArm;
import com.jdkd.automata.items.parts.head.ItemAutomatonHead;
import com.jdkd.automata.items.parts.legs.ItemAutomatonLeg;
import com.jdkd.automata.items.parts.shell.ItemAutomatonShell;
import com.jdkd.automata.items.util.ItemAutomatonInspector;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class AutomataItems {

    public static List<Item> parts = new ArrayList<>();
    public static Item debugger;

    public static void intialiseParts(){
        for(AutomatonMaterial material : AutomatonMaterial.values()){
            parts.add(new ItemAutomatonShell(material));
            parts.add(new ItemAutomatonHead(material));
            parts.add(new ItemAutomatonArm(material));
            parts.add(new ItemAutomatonLeg(material));
        }

        debugger = new ItemAutomatonInspector();

    }

}
