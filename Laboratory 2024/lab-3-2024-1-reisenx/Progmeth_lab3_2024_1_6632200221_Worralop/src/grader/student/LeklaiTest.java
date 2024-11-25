package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.ghost.PongGhost;
import logic.ghost.PooYaGhost;
import logic.ghost.PryGhost;
import logic.item.Leklai;
import utils.Config;

class LeklaiTest {

    Leklai leklai;

    @BeforeEach
    void setUp() {
        leklai = new Leklai();
    }

    @Test
    void testGetLevel() {
        assertEquals(Config.LeklaiLevel, leklai.getLevel());
    }

    @Test
    void testEffectOnLowGhost() {
        // Effect on Low Ghost
        LowGhost lowGhost = new PryGhost();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(lowGhost);
        leklai.effect();
        assertEquals(0, lowGhost.getHp());
    }

    @Test
    void testEffectOnHighGhost1() {
        // Effect on High Ghost
        HighGhost highGhost = new PongGhost(3);
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(highGhost);
        leklai.effect();
        assertEquals(6, highGhost.getHp());
    }
    @Test
    void testEffectOnHighGhost2() {
        // Effect on High Ghost
        HighGhost highGhost = new PooYaGhost(10);
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(highGhost);
        leklai.effect();
        assertEquals(10, highGhost.getHp());
    }

    @Test
    void testToString() {
        assertEquals("Leklai", leklai.toString());
    }
}