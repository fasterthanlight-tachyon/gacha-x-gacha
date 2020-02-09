package com.github.crocharisma.gachaxgacha.game;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Arrays;

/**
 * A class that represents a unit in the game.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
@Getter
public class Unit {
    /**
     * The name of this {@link Unit}
     */
    private final String name;
    /**
     * The description of this {@link Unit}
     */
    private final String description;
    /**
     * The attacks that this unit knows.<br>
     * The final attack is always the last in the array.
     */
    @Getter(AccessLevel.NONE)
    private final Attack[] attacks;

    /**
     * Creates a {@link Unit}.
     *
     * @param name        the name to give this {@link Unit}
     * @param description the description to give this {@link Unit}
     * @param attacks     the {@link Attack}s to give this {@link Unit}
     */
    public Unit(String name, String description, Attack[] attacks) {
        this.name = name;
        this.description = description;
        this.attacks = attacks;
    }

    /**
     * Returns an array of standard {@link Attack}s that this {@link Unit} knows.<br>
     * If the array containing all the attacks is {@code null}, then {@code null} is returned.
     *
     * @return an array of standard {@link Attack}s that this {@link Unit} knows
     */
    public Attack[] getAttacks() {
        return attacks == null ? null : Arrays.copyOfRange(attacks, 0, attacks.length - 1);
    }

    /**
     * Returns the ultimate attack!<br>
     * If the array containing the attacks is {@code null}, then {@code null} is returned.
     *
     * @return the ultimate attack!
     */
    public Attack getUltimateAttack() {
        return attacks == null ? null : attacks[attacks.length - 1];
    }

    /**
     * Returns an array that contains all attacks that this {@link Unit} knows, including the standard and ultimate attacks.
     * If the array containing the attacks is {@code null}, then {@code null} is returned.
     *
     * @return an array that contains all attacks that this {@link Unit} knows
     */
    public Attack[] getAllAttacks() {
        return attacks;
    }
}
