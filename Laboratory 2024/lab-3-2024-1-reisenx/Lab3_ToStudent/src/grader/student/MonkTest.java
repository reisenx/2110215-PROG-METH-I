package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Monk;
import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.ghost.PooYaGhost;
import utils.Config;

class MonkTest {

    Monk monk;

    @BeforeEach
    void setUp() {
        monk = new Monk();
    }

    @Test
    void testGetLevel() {
        assertEquals(Config.MonkLevel, monk.getLevel());
    }

    @Test
    void testAttackHighGhost() {
        // Attack High Ghost
        HighGhost highGhost = new PooYaGhost(0);
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(highGhost);
        monk.attack();
        assertEquals(7, highGhost.getHp()); 
    }

    @Test
    void testAttackLowGhost() {
        // Attack Low Ghost
        LowGhost lowGhost = new GaGhost();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(lowGhost);
        monk.attack();
        assertEquals(3, lowGhost.getHp()); 
    }


    @Test
    void testToString() {
        assertEquals("Monk", monk.toString());
    }
}