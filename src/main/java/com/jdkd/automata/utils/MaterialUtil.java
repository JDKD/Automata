package com.jdkd.automata.utils;

import com.jdkd.automata.items.parts.AutomatonAttributeModifier;
import com.jdkd.automata.items.parts.AutomatonMaterial;
import com.jdkd.automata.items.parts.AutomatonPartType;
import net.minecraft.entity.ai.EntityAIBase;

import java.util.List;
import java.util.Map;

public class MaterialUtil {

    private static final int xOffset = 82;
    private static final int yOffset = 94;

    public static List<AutomatonAttributeModifier> getModifiers(AutomatonPartType partType, AutomatonMaterial material) {
        return null;
    }

    public static Map<Integer, EntityAIBase> getTasks(AutomatonPartType partType, AutomatonMaterial material){
        return null;
    }

    public static int getMaterialTextureXOffset(AutomatonMaterial material){

        switch (material) {
            case GOLD:
                return xOffset;
            case WOOD:
                return xOffset;
            case OBSIDIAN:
                return xOffset * 2;
            case STONE:
                return 0;
            case DIAMOND:
                return xOffset * 2;
            case IRON:
                return 0;
        }

        return 0;
    }

    public static int getMaterialTextureYOffset(AutomatonMaterial material){
        switch (material) {
            case GOLD:
                return yOffset;
            case WOOD:
                return 0;
            case OBSIDIAN:
                return 0;
            case STONE:
                return yOffset;
            case DIAMOND:
                return xOffset;
            case IRON:
                return 0;
        }

        return 0;
    }

    public static int getMaterialTextureYOffsetLegs(AutomatonMaterial material){
        int offset = getMaterialTextureYOffset(material);

        return offset == 0 ? offset : offset + 12;
    }
}
