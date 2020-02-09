package com.github.crocharisma.gachaxgacha.game;

import lombok.Getter;

/**
 * An enum that stores the type of attack.
 */
@Getter
public enum Type {
    NORMAL(0), FIRE(1), WATER(2), ELECTRIC(3), GRASS(4), ICE(5), FIGHTING(6), POISON(7), GROUND(8), FLYING(9),
    PSYCHIC(10), BUG(11), ROCK(12), GHOST(13), DRAGON(14), DARK(15), STEEL(16), FAIRY(17);

    /**
     * The matrix of multipliers.
     */
    private static final double[][] MULTIPLIER_MATRIX = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0.5, 0, 1, 1, 0.5, 1},
            {0, 0.5, 0.5, 1, 2, 2, 1, 1, 1, 1, 1, 2, 0.5, 1, 0.5, 1, 2, 1},
            {0, 2, 0.5, 1, 0.5, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0.5, 1, 1, 1},
            {1, 1, 2, 0.5, 0.5, 1, 1, 1, 0, 2, 1, 1, 1, 1, 0.5, 1, 1, 1},
            {1, 0.5, 2, 1, 0.5, 1, 1, 0.5, 2, 0.5, 1, 0.5, 2, 1, 0.5, 1, 0.5, 1},
            {1, 0.5, 0.5, 1, 2, 0.5, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1, 0.5, 1},
            {2, 1, 1, 1, 1, 2, 1, 0.5, 1, 0.5, 0.5, 0.5, 2, 0, 1, 2, 2, 0.5},
            {1, 1, 1, 1, 2, 1, 1, 0.5, 0.5, 1, 1, 1, 0.5, 0.5, 1, 1, 0, 2},
            {1, 2, 1, 2, 0.5, 1, 1, 2, 1, 0, 1, 0.5, 2, 1, 1, 1, 2, 1},
            {1, 1, 1, 0.5, 2, 1, 2, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 0.5, 1},
            {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 0.5, 1, 1, 1, 1, 0, 0.5, 1},
            {1, 0.5, 1, 1, 2, 1, 0.5, 0.5, 1, 0.5, 2, 1, 1, 0.5, 1, 2, 0.5, 0.5},
            {1, 2, 1, 1, 1, 2, 0.5, 1, 0.5, 2, 1, 2, 1, 1, 1, 1, 0.5, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 0.5, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 0.5, 0},
            {1, 1, 1, 1, 1, 1, 0.5, 1, 1, 1, 2, 1, 1, 2, 1, 0.5, 1, 0.5},
            {1, 0.5, 0.5, 0.5, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 0.5, 2},
            {1, 0.5, 1, 1, 1, 1, 2, 0.5, 1, 1, 1, 1, 1, 1, 2, 2, 0.5, 1}
    };

    /**
     * The type of attack
     */
    private final int type;

    /**
     * Creates a {@link Type} instance
     *
     * @param type the type of attack this enum should represent
     */
    Type(int type) {
        this.type = type;
    }

    /**
     * Returns the attack multiplier given the attack type and defense type.
     *
     * @param att the {@link Type} of the attack
     * @param def the {@link Type} of the defender
     * @return the attack multiplier
     */
    public static double getAttackMultiplier(Type att, Type def) {
        return MULTIPLIER_MATRIX[att.type][def.type];
    }

    /**
     * Determines whether this {@link Type} is strong against the given defense {@link Type}.
     *
     * @param def the {@link Type} of the defense
     * @return whether this is strong against that
     */
    public boolean isStrongAgainst(Type def) {
        return getAttackMultiplier(this, def) > 1;
    }

    /**
     * Determines whether this {@link Type} is weak against the given defense {@link Type}.
     *
     * @param def the {@link Type} of the defense
     * @return whether this is weak against that
     */
    public boolean isWeakAgainst(Type def) {
        return getAttackMultiplier(this, def) < 1;
    }
}
