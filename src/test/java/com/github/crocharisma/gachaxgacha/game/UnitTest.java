package com.github.crocharisma.gachaxgacha.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Just a class to test out the functionality of the {@link Unit} class.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
class UnitTest {

    @Test
    void getDescriptionAndName() {
        Unit u = new Unit("name", "description", null);
        assertEquals(u.getName(), "name");
        assertEquals("description", u.getDescription());

        u = new Unit(null, null, null);
        assertNull(u.getName());
        assertNull(u.getDescription());
    }

    @Test
    void getAttacks() {
        Attack one = new Attack("name", 1, Attack.Type.AIR),
                two = new Attack("no-name", 2, Attack.Type.EARTH),
                three = new Attack("yeet", 3, Attack.Type.WATER),
                four = new Attack("sans", 20000, Attack.Type.FIRE);
        Attack[] attacks = new Attack[]{one, two, three, four};
        Unit u = new Unit(null, null, attacks);

        assertArrayEquals(attacks, u.getAllAttacks());
        assertArrayEquals(new Attack[]{one, two, three}, u.getAttacks());
        assertEquals(four, u.getUltimateAttack());

        attacks = new Attack[]{three};
        u = new Unit(null, null, attacks);

        assertArrayEquals(attacks, u.getAllAttacks());
        assertArrayEquals(new Attack[]{}, u.getAttacks());
        assertEquals(three, u.getUltimateAttack());

        u = new Unit(null, null, null);

        assertNull(u.getAllAttacks());
        assertNull(u.getAttacks());
        assertNull(u.getUltimateAttack());
    }
}