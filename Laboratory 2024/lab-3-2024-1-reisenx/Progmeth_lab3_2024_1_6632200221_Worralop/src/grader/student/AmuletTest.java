package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.item.Amulet;
import utils.Config;

class AmuletTest {

    Amulet amulet;

    @BeforeEach
    void setUp() {
        amulet = new Amulet();
    }

    @Test
    void testGetLevel() {
        assertEquals(Config.AmuletLevel, amulet.getLevel());
    }

    @Test
    void testEffectWithLowHp() {
        // Effect with low HP
        GameController.getInstance().setHp(3);
        amulet.effect();
        assertEquals(5, GameController.getInstance().getHp()); 
    }

    @Test
    void testEffectWithHighHp() {
        // Effect with high HP
        GameController.getInstance().setHp(7);
        amulet.effect();
        assertEquals(7, GameController.getInstance().getHp());
    }


    @Test
    void testToString() {
        assertEquals("Amulet", amulet.toString());
    }
}