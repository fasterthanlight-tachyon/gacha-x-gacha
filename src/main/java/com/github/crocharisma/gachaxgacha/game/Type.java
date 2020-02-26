package com.github.crocharisma.gachaxgacha.game;

import lombok.Getter;

/**
 * An enum that stores the type of attack.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
@Getter
public enum Type {
    ENHANCER(0), TRANSMITTER(1), CONJURER(2), EMITTER(3), MANIPULATOR(4), SPECIALIST(5);

    /**
     * The matrix of attack multipliers based on unit type and attack type.
     */
    private static final double[][] ATTACK_MULTIPLIER_MATRIX = {
            {1.0, 0.8, 0.6, 0.0, 0.6, 0.8},
            {0.8, 1.0, 0.8, 0.0, 0.4, 0.6},
            {0.6, 0.8, 1.0, 0.01, 0.6, 0.4},
            {0.8, 0.6, 0.4, 0.0, 0.8, 1.0},
            {0.6, 0.4, 0.6, 0.01, 1.0, 0.8},
            {0.4, 0.6, 0.8, 1.0, 0.8, 0.6}
    };

    /**
     * The matrix of attack multipliers based on attack type and defense type.
     */
    private static final double[][] STRENGTH_MATRIX = {
            {1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.5},
            {0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.5},
            {1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 1.5},
            {2.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.5},
            {1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.5},
            {1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5}
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
     * @param attacker the {@link Type} of the unit attacking
     * @param attType  the {@link Type} of the attack
     * @param def      the {@link Type} of the defender
     * @return the attack multiplier
     */
    public static double getAttackMultiplier(Type attacker, Type attType, Type def) {
        return ATTACK_MULTIPLIER_MATRIX[attacker.type][attType.type] * STRENGTH_MATRIX[attType.type][def.type];
    }

    /**
     * Determines whether this {@link Type} is strong against the given defense {@link Type}.
     *
     * @param def the {@link Type} of the defense
     * @return whether this is strong against that
     */
    public boolean isStrongAgainst(Type def) {
        return STRENGTH_MATRIX[type][def.type] > 1;
    }

    /**
     * Determines whether this {@link Type} is weak against the given defense {@link Type}.
     *
     * @param def the {@link Type} of the defense
     * @return whether this is weak against that
     */
    public boolean isWeakAgainst(Type def) {
        return STRENGTH_MATRIX[type][def.type] < 1;
    }
}
