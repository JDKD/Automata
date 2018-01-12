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

    public static List<Item> items = new ArrayList<>();

    public static void intialiseParts(){
        for(AutomatonMaterial material : AutomatonMaterial.values()){
            items.add(new ItemAutomatonShell(material));
            items.add(new ItemAutomatonHead(material));
            items.add(new ItemAutomatonArm(material));
            items.add(new ItemAutomatonLeg(material));
        }

        items.add(new ItemAutomatonInspector());

    }

}
