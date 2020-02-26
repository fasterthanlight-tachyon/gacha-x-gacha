package com.github.fasterthanlight.gachaxgacha.game;

import lombok.Getter;

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
    private final Attack[] attacks;
    /**
     * This {@link Unit}'s ultimate attack!
     */
    private final UltimateAttack ultimateAttack;
    /**
     * The type of this {@link Unit}
     */
    private final Type type;
    /**
     * The maximum health points this unit can have
     */
    private final int maxHP;
    /**
     * The health points this unit has
     */
    private int hp;

    /**
     * Creates a {@link Unit}.
     *
     * @param name           the name to give this {@link Unit}
     * @param description    the description to give this {@link Unit}
     * @param attacks        the {@link Attack}s to give this {@link Unit}
     * @param ultimateAttack this {@link Unit}'s ultimate attack
     * @param type           the {@link Type} of this {@link Unit}
     * @param maxHP          the maximum health points this unit can have
     */
    public Unit(String name, String description, Attack[] attacks, UltimateAttack ultimateAttack, Type type, int maxHP) {
        this.name = name;
        this.description = description;
        this.attacks = attacks;
        this.ultimateAttack = ultimateAttack;
        this.type = type;
        this.maxHP = maxHP;

        hp = maxHP;
    }

    /**
     * Damages this {@link Unit} by the given amount
     *
     * @param amount the amount to damage this {@link Unit}
     */
    public void damage(int amount) {
        hp -= amount;
        if (hp < 0) hp = 0;
    }

    /**
     * Returns whether this {@link Unit} is dead
     *
     * @return whether this {@link Unit} is dead
     */
    public boolean isDead() {
        return hp == 0;
    }

    /**
     * Resets this {@link Unit} for the beginning of battle.
     */
    public void reset() {
        hp = maxHP; // Not sure if should reset HP to make game have _persistent_ HP rules
        if (ultimateAttack != null) ultimateAttack.reset();
    }
}
