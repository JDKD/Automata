package com.jdkd.automata.items.parts.arms;

import com.jdkd.automata.items.parts.AbstractAutomatonPart;
import com.jdkd.automata.items.parts.AutomatonMaterial;
import com.jdkd.automata.items.parts.AutomatonPart;
import com.jdkd.automata.items.parts.AutomatonPartType;
import com.jdkd.automata.utils.MaterialUtil;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import java.util.ArrayList;
import java.util.List;

public class ItemAutomatonArm extends AbstractAutomatonPart implements AutomatonArm {

    private List<ModelRenderer> renderers;
    private boolean isConductive;
    private int reachDistance;

    public ItemAutomatonArm(AutomatonMaterial material, boolean isConductive, int reachDistance) {
        super(material);
        this.isConductive = isConductive;
        this.reachDistance = reachDistance;
    }

    public ItemAutomatonArm(AutomatonMaterial material) {
        this(material, false, 1);
    }

    @Override
    public AutomatonPartType getPartType() {
        return AutomatonPartType.ARM;
    }

    @Override
    public int getMaxReachDistance() {
        return reachDistance;
    }

    @Override
    public boolean canConductRedstone() {
        return isConductive;
    }

    public boolean isConductive() {
        return isConductive;
    }

    public int getReachDistance() {
        return reachDistance;
    }
}
