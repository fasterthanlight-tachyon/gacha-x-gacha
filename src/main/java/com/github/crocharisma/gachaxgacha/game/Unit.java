package com.github.crocharisma.gachaxgacha.game;

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
     * Creates a {@link Unit}.
     *
     * @param name        the name to give this {@link Unit}
     * @param description the description to give this {@link Unit}
     */
    public Unit(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
