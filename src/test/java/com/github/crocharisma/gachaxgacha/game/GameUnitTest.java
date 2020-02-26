package com.github.crocharisma.gachaxgacha.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Just a class to test out the functionality of the {@link Unit} class.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
class GameUnitTest {
    /**
     * A tester method that ensures that setting name and description work
     */
    @Test
    void getDescriptionAndName() {
        Unit u = new Unit("name", "description", null, null, null, 0);
        assertEquals(u.getName(), "name");
        assertEquals("description", u.getDescription());

        u = new Unit(null, null, null, null, null, 0);
        assertNull(u.getName());
        assertNull(u.getDescription());
    }

    /**
     * A tester method that ensures that storing attacks is correct
     */
    @Test
    void getAttacks() {
        Attack one = new BasicAttack("name", 1, Type.CONJURER),
                two = new BasicAttack("no-name", 2, Type.CONJURER),
                three = new BasicAttack("yeet", 3, Type.CONJURER);
        UltimateAttack four = new UltimateAttack("sans", 20000, Type.CONJURER, 200);
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

    /**
     * A tester method that ensures that attack interactions are functional
     */
    @Test
    void attackInteractions() {
        Attack[] attacks = new Attack[]{new BasicAttack("Sins", 10, Type.CONJURER), new ChargingAttack("Rest", 50),
                new BasicAttack("Yeet", 25, Type.EMITTER)};
        UltimateAttack ultimate = new UltimateAttack("The Final Attack", 10_000, Type.SPECIALIST, 100);
        Unit sans = new Unit("Sans", "An absolute madlad", attacks, ultimate, Type.TRANSMITTER, 1),
                you = new Unit("You", "Idiot", null, null, Type.SPECIALIST, 51);

        assertEquals(0, sans.getUltimateAttack().getCharge());
        assertEquals(1, sans.getHp());
        assertEquals(51, you.getHp());

        attacks[0].attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(43, you.getHp());

        attacks[2].attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(43, you.getHp());
        assertEquals(0, ultimate.getCharge());

        ultimate.attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(43, you.getHp());
        assertFalse(you.isDead());

        attacks[1].attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(43, you.getHp());
        assertEquals(50, ultimate.getCharge());

        attacks[1].attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(43, you.getHp());
        assertEquals(100, ultimate.getCharge());

        ultimate.attack(sans, you);
        assertEquals(1, sans.getHp());
        assertEquals(0, you.getHp());
        assertEquals(0, ultimate.getCharge());
        assertTrue(you.isDead());

        attacks[1].attack(sans, you);
        assertNotEquals(0, ultimate.getCharge());

        sans.reset();
        assertEquals(0, ultimate.getCharge());
    }
}