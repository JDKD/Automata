package com.jdkd.automata.items.parts;

import com.jdkd.automata.AutomataMain;
import com.jdkd.automata.utils.MaterialUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public abstract class AbstractAutomatonPart extends Item implements AutomatonPart {

    private AutomatonMaterial material;
    private List<AutomatonAttributeModifier> modifiers;
    private Map<Integer, EntityAIBase> tasks;


    public AbstractAutomatonPart(AutomatonMaterial material) {
        setRegistryName("item_automaton_" + material.toString().toLowerCase() + "_" + getPartType().toString().toLowerCase());
        setUnlocalizedName("item_automaton_" + material.toString().toLowerCase() + "_" + getPartType().toString().toLowerCase());
        setMaxStackSize(1);
        setCreativeTab(AutomataMain.tab);

        this.material = material;
        this.modifiers = MaterialUtil.getModifiers(getPartType(), getMaterial());
        this.tasks = MaterialUtil.getTasks(getPartType(), getMaterial());
    }

    @Override
    public void setAttributeModifiers(List<AutomatonAttributeModifier> modifiers) {
        this.modifiers = modifiers;
    }

    @Override
    public List<AutomatonAttributeModifier> getAttributeModifiers() {
        return modifiers;
    }

    @Override
    public Map<Integer, EntityAIBase> getAITaskss() {
        return tasks;
    }

    @Override
    public AutomatonMaterial getMaterial() {
        return material;
    }
}
