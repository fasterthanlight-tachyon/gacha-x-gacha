package com.github.fasterthanlight.gachaxgacha.game;

/**
 * A class that models a basic attack.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
public class BasicAttack extends Attack {
    /**
     * Creates a brand new attack.
     *
     * @param name       the name for this attack
     * @param baseDamage the base damage for this attack
     * @param type       the type of attack this is
     */
    public BasicAttack(String name, int baseDamage, Type type) {
        super(name, baseDamage, type);
    }

    @Override
    public void attack(Unit attacker, Unit defender) {
        double mult = Type.getAttackMultiplier(attacker.getType(), getType(), defender.getType());
        defender.damage((int) (mult * getBaseDamage()));
    }
}
