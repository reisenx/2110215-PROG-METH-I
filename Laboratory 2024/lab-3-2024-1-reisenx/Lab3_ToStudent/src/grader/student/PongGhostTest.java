package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.ghost.PongGhost;
import logic.ghost.PooYaGhost;
import logic.ghost.PongGhost;

class PongGhostTest {

    PongGhost pongGhost;

    @BeforeEach
    void setUp() {
        pongGhost = new PongGhost(); // Assuming you create a mock class for testing purposes
    }
    
    @Test
    void testConstructor() {
    	// TODO: Fill your code
    }
    
    @Test
    void testIsDestroyedFalse() {
        assertFalse(pongGhost.isDestroyed()); // PongGhost is not destroyed initially
    }

    @Test
    void testIsDestroyedTrue() {
        pongGhost.decreaseHp(10); // Assuming initial HP of PongGhost is 10
        assertTrue(pongGhost.isDestroyed()); // PongGhost is destroyed after decreasing HP to 0
    }

    @Test
    void testGetHp() {
        assertEquals(10, pongGhost.getHp()); // Assuming initial HP of PongGhost is 10
    }

    @Test
    void testDecreaseHp() {
        pongGhost.decreaseHp(3);
        assertEquals(7, pongGhost.getHp()); // After decreasing HP by 3
    }

    @Test
    void testDecreaseHpBelowZero() {
        pongGhost.decreaseHp(15);
        assertEquals(0, pongGhost.getHp()); // After decreasing HP below zero, it should be 0
    }

    @Test
    void testGetLevel() {
        assertEquals(5, pongGhost.getLevel()); // Assuming PongGhost has level 5
    }

    @Test
    void testAttack() {
        GameController.getInstance().setHp(20); // Assuming initial HP of GameController is 20
        pongGhost.attack();
        assertEquals(19, GameController.getInstance().getHp()); // After PongGhost attack with power 1
    }

    @Test
    void testToString() {
        assertEquals("PongGhost [HP: 10 , Power: 1]", pongGhost.toString()); // Assuming initial values
    }

    @Test
    void testDamage() {
        LowGhost lowGhost = new GaGhost();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(lowGhost);
        pongGhost.damage();
        assertEquals(4, lowGhost.getHp()); 
    }
}