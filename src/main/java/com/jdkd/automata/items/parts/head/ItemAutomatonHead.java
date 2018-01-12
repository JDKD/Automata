package com.jdkd.automata.items.parts.head;

import com.jdkd.automata.items.parts.AbstractAutomatonPart;
import com.jdkd.automata.items.parts.AutomatonMaterial;
import com.jdkd.automata.items.parts.AutomatonPartType;
import com.jdkd.automata.utils.MaterialUtil;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemAutomatonHead extends AbstractAutomatonPart implements AutomatonHead {

    private List<ModelRenderer> modelRenderer;

    private int visionRange;
    private List<AutomatonLogic> allowedLogicTypes;
    private AutomatonLogic currentLogicType;
    private List<Item> filterItems;

    public ItemAutomatonHead(AutomatonMaterial material) {
        super(material);
    }

    @Override
    public AutomatonPartType getPartType() {
        return AutomatonPartType.HEAD;
    }

    @Override
    public int getVisionRange() {
        return visionRange;
    }

    @Override
    public List<AutomatonLogic> getAllowedLogicTypes() {
        return allowedLogicTypes;
    }

    @Override
    public AutomatonLogic getCurrentLogicType() {
        return currentLogicType;
    }

    @Override
    public List<Item> getLogicItems() {
        return filterItems;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

    public void setAllowedLogicTypes(List<AutomatonLogic> allowedLogicTypes) {
        this.allowedLogicTypes = allowedLogicTypes;
    }

    public void setCurrentLogicType(AutomatonLogic currentLogicType) {
        this.currentLogicType = currentLogicType;
    }

    public void setFilterItems(List<Item> filterItems) {
        this.filterItems = filterItems;
    }
}
