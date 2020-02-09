package com.github.crocharisma.gachaxgacha.game;

import lombok.Getter;

/**
 * A class that represents an {@link Attack} that charges up an {@link UltimateAttack}.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
@Getter
public class ChargingAttack extends Attack {
    /**
     * The amount this {@link ChargingAttack} charges the {@link Unit}'s {@link UltimateAttack}
     */
    private final int chargingAmount;

    /**
     * Creates a brand new attack.
     *
     * @param name           the name for this attack
     * @param baseDamage     the base damage for this attack
     * @param type           the type of attack this is
     * @param chargingAmount the amount this {@link ChargingAttack} charges an {@link UltimateAttack}
     */
    public ChargingAttack(String name, int baseDamage, Type type, int chargingAmount) {
        super(name, baseDamage, type);
        this.chargingAmount = chargingAmount;
    }

    /**
     * Creates a brand new attack.
     *
     * @param name           the name for this attack
     * @param chargingAmount the amount this {@link ChargingAttack} charges an {@link UltimateAttack}
     */
    public ChargingAttack(String name, int chargingAmount) {
        this(name, 0, Type.NORMAL, chargingAmount);
    }

    @Override
    public void attack(Unit attacker, Unit defender) {
        attacker.getUltimateAttack().charge(chargingAmount);
    }
}
