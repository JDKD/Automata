package com.jdkd.automata.items.parts.legs;

import com.jdkd.automata.items.parts.AbstractAutomatonPart;
import com.jdkd.automata.items.parts.AutomatonMaterial;
import com.jdkd.automata.items.parts.AutomatonPartType;
import com.jdkd.automata.utils.MaterialUtil;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import java.util.ArrayList;
import java.util.List;

public class ItemAutomatonLeg extends AbstractAutomatonPart implements AutomatonLeg {

    private int maxMovementDistance;
    private boolean canSwim;

    public ItemAutomatonLeg(AutomatonMaterial material) {
        super(material);
    }

    @Override
    public int getMaxMovementDistance() {
        return maxMovementDistance;
    }

    @Override
    public boolean canSwim() {
        return canSwim;
    }

    @Override
    public AutomatonPartType getPartType() {
        return AutomatonPartType.LEG;
    }

    public void setMaxMovementDistance(int maxMovementDistance) {
        this.maxMovementDistance = maxMovementDistance;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }
}
