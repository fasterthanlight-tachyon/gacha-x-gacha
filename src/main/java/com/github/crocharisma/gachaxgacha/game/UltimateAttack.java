package com.github.crocharisma.gachaxgacha.game;

import lombok.Getter;

/**
 * A class that models an ultimate attack.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
@Getter
public class UltimateAttack extends BasicAttack {
    /**
     * The maximum amount of charge this attack can hold
     */
    private final int maxCharge;
    /**
     * The current amount of charge this attack holds
     */
    private int charge;

    /**
     * Creates a brand new attack.
     *
     * @param name       the name for this attack
     * @param baseDamage the base damage for this attack
     * @param type       the type of attack this is
     * @param maxCharge  the maximum amount of charge this attack can hold
     */
    public UltimateAttack(String name, int baseDamage, Type type, int maxCharge) {
        super(name, baseDamage, type);
        this.maxCharge = maxCharge;

        charge = 0;
    }

    @Override
    public void attack(Unit attacker, Unit defender) {
        if (charge == maxCharge) {
            super.attack(attacker, defender);
        }

        charge = 0;
    }

    /**
     * Charges this {@link UltimateAttack} up by the given amount
     *
     * @param amount the amount to charge this {@link UltimateAttack} up by
     */
    public void charge(int amount) {
        charge += amount;
        if (charge > maxCharge) charge = maxCharge;
    }
}
