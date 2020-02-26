package com.github.fasterthanlight.gachaxgacha.game;

import lombok.Getter;

/**
 * A class that represents an attack.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
@Getter
public abstract class Attack {
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
     * Performs the attack on the defender.
     *
     * @param attacker the {@link Unit} attacking
     * @param defender the {@link Unit} recieving the attack
     */
    public abstract void attack(Unit attacker, Unit defender);
}
