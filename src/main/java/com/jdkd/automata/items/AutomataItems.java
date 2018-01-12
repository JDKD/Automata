package com.jdkd.automata.items;

import com.jdkd.automata.items.parts.AutomatonAttributeModifier;
import com.jdkd.automata.items.parts.AutomatonMaterial;
import com.jdkd.automata.items.parts.AutomatonPart;
import com.jdkd.automata.items.parts.arms.ItemAutomatonArm;
import com.jdkd.automata.items.parts.head.ItemAutomatonHead;
import com.jdkd.automata.items.parts.legs.ItemAutomatonLeg;
import com.jdkd.automata.items.parts.modifiers.AutomatonAttributeModifierSetter;
import com.jdkd.automata.items.parts.shell.ItemAutomatonShell;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.item.Item;
import sun.security.provider.SHA;

import java.util.ArrayList;
import java.util.List;

public class AutomataItems {

    public static final Item shell = new ItemAutomatonShell(AutomatonMaterial.IRON);
    public static final Item head = new ItemAutomatonHead(AutomatonMaterial.IRON);
    public static final Item woodHead = new ItemAutomatonHead(AutomatonMaterial.WOOD);
    public static final Item goldArms = new ItemAutomatonArm(AutomatonMaterial.GOLD);
    public static final Item diamondLegs = new ItemAutomatonLeg(AutomatonMaterial.DIAMOND);
    public static final Item obsidianLegs = new ItemAutomatonLeg(AutomatonMaterial.OBSIDIAN);

    public static void intialiseParts(){
        List<AutomatonAttributeModifier> modifiers = new ArrayList<>();
        modifiers.add(new AutomatonAttributeModifierSetter(SharedMonsterAttributes.MAX_HEALTH, 10));
        modifiers.add(new AutomatonAttributeModifierSetter(SharedMonsterAttributes.MOVEMENT_SPEED, 1D));

        ((AutomatonPart)diamondLegs).setAttributeModifiers(modifiers);
    }

}
