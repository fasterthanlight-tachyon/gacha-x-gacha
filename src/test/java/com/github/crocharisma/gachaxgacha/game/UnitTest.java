package com.github.crocharisma.gachaxgacha.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Just a class to test out the functionality of the {@link Unit} class.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
class UnitTest {

    @Test
    void getName() {
        Unit u = new Unit("name", null);
        assertEquals(u.getName(), "name");
        u = new Unit(null, null);
        assertNull(u.getName());
    }

    @Test
    void getDescription() {
        Unit u = new Unit(null, "description");
        assertEquals("description", u.getDescription());
        u = new Unit(null, null);
        assertNull(u.getDescription());
    }
}