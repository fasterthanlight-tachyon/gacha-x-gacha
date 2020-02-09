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
        Unit u = new Unit("name", "description", null, null, null, 0);
        assertEquals(u.getName(), "name");
        assertEquals("description", u.getDescription());

        u = new Unit(null, null, null, null, null, 0);
        assertNull(u.getName());
        assertNull(u.getDescription());
    }

    @Test
    void getAttacks() {
        Attack one = new BasicAttack("name", 1, Type.POISON),
                two = new BasicAttack("no-name", 2, Type.ICE),
                three = new BasicAttack("yeet", 3, Type.NORMAL);
        UltimateAttack four = new UltimateAttack("sans", 20000, Type.GHOST, 200);
        Attack[] attacks = new Attack[]{one, two, three};
        Unit u = new Unit(null, null, attacks, four, null, 0);

        assertArrayEquals(attacks, u.getAttacks());
        assertEquals(four, u.getUltimateAttack());

        attacks = new Attack[]{three};
        u = new Unit(null, null, attacks, null, null, 0);

        assertArrayEquals(attacks, u.getAttacks());
        assertNull(u.getUltimateAttack());

        u = new Unit(null, null, null, four, null, 0);

        assertNull(u.getAttacks());
        assertEquals(four, u.getUltimateAttack());
    }

    @Test
    void attackInteractions() {
        Attack[] attacks = new Attack[]{new BasicAttack("Sins", 10, Type.NORMAL), new ChargingAttack("Rest", 50),
                new BasicAttack("Yeet", 25, Type.DARK)};
        UltimateAttack ultimate = new UltimateAttack("The Final Attack", 10_000, Type.GHOST, 100);
        Unit sans = new Unit("Sans", "An absolute madlad", attacks, ultimate, Type.FIGHTING, 1),
                you = new Unit("You", "Idiot", null, null, Type.FAIRY, 51);

        assertEquals(0, sans.getUltimateAttack().getCharge());
        assertEquals(1, sans.getHp());
        assertEquals(51, you.getHp());

        attacks[0].attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(41, you.getHp());

        attacks[2].attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(29, you.getHp());
        assertEquals(0, ultimate.getCharge());

        ultimate.attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(29, you.getHp());
        assertFalse(you.isDead());

        attacks[1].attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(29, you.getHp());
        assertEquals(50, ultimate.getCharge());

        attacks[1].attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(29, you.getHp());
        assertEquals(100, ultimate.getCharge());

        ultimate.attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(0, you.getHp());
        assertEquals(0, ultimate.getCharge());
        assertTrue(you.isDead());
    }
}