package com.jdkd.automata.items.parts;

public enum AutomatonMaterial {

    WOOD(1D, 0.25D, 0D, 0.25D, 1D, 0D),
    STONE(2D, 0.1D, 0.5D, 0.5D, 1D, 0D),
    IRON(4D, 0.25D, 1D, 1D, 2D, 0.5D),
    GOLD(0.5D, 0.5D, 0.5D, 0.25D, 3D, 1.5D),
    OBSIDIAN(8D, 0.1D, 0D, 1.5D, 1D, 0D),
    DIAMOND(10D, 0.5D, 2D, 2D, 3D, 1D),
    EMERALD(5D, 1D, 1D, 1D, 4D, 1.5D);

    private double healthModifier, speedModifier, carryModifier, damageModifier, intelligenceModifier, capacitiveModifier;

    AutomatonMaterial(double healthModifier, double speedModifier, double carryModifier, double damageModifier, double intelligenceModifier, double capacitiveModifier) {

        this.healthModifier = healthModifier;
        this.speedModifier = speedModifier;
        this.carryModifier = carryModifier;
        this.capacitiveModifier = capacitiveModifier;
        this.damageModifier = damageModifier;
        this.intelligenceModifier = intelligenceModifier;
    }

    public double getHealthModifier() {
        return healthModifier;
    }

    public double getSpeedModifier() {
        return speedModifier;
    }

    public double getCarryModifier() {
        return carryModifier;
    }

    public double getCapacitiveModifier() {
        return capacitiveModifier;
    }

    public double getDamageModifier() {
        return damageModifier;
    }

    public double getIntelligenceModifier() {
        return intelligenceModifier;
    }
}
