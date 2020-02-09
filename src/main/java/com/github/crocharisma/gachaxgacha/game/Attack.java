package com.github.crocharisma.gachaxgacha.game;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * A class that represents an attack.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
@Getter
@EqualsAndHashCode(of = {"name", "type"})
public class Attack {
    /**
     * The name of this attack
     */
    private final String name;
    /**
     * The base damage of this attack
     */
    private final int baseDamage;
    /**
     * The type of this attack
     */
    private final Type type;

    /**
     * Creates a brand new attack.
     *
     * @param name       the name for this attack
     * @param baseDamage the base damage for this attack
     * @param type       the type of attack this is
     */
    public Attack(String name, int baseDamage, Type type) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.type = type;
    }

    /**
     * An enum that stores the type of attack.
     */
    @Getter
    public enum Type {
        /**
         * A fire attack?
         */
        FIRE("FIRE"),
        /**
         * An earthen attack?
         */
        EARTH("EARTH"),
        /**
         * A water attack?
         */
        WATER("WATER"),
        /**
         * An air attack?
         */
        AIR("AIR");

        /**
         * The type of attack
         */
        private final String type;

        /**
         * Creates a {@link Type} instance
         *
         * @param type the type of attack this enum should represent
         */
        Type(String type) {
            this.type = type;
        }
    }
}
