package com.github.fasterthanlight.gachaxgacha.controller.api;

import com.github.fasterthanlight.gachaxgacha.game.BasicAttack;
import com.github.fasterthanlight.gachaxgacha.game.Type;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * A controller that returns JSON object for the web interface.
 *
 * @author Jed Wang
 * @since 1.0.0
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/api")
    public Object get() {
        return new BasicAttack("Attack", 20, Type.CONJURER);
    }
}
