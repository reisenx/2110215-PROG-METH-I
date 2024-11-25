package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.GaGhost;

class GaGhostTest {

    GaGhost gaGhost;

    @BeforeEach
    void setUp() {
        gaGhost = new GaGhost(); 
    }
    @Test
    void testConstructor() {
    	GaGhost a = new GaGhost();
    	GaGhost b = new GaGhost(2);
    	assertEquals("GaGhost [HP: 3 , Energy: 6]",a.toString());
    	assertEquals("GaGhost [HP: 3 , Energy: 2]",b.toString());
    }
    @Test
    void testIsDestroyedFalse() {
    	// Implement Test
    	GaGhost a = new GaGhost();
    	GaGhost b = new GaGhost(-999);
    	GaGhost c = new GaGhost(69);
    	assertEquals(false, a.isDestroyed());
    	assertEquals(false, b.isDestroyed());
    	assertEquals(false, c.isDestroyed());
    }

    @Test
    void testIsDestroyedTrue() {
        gaGhost.decreaseHp(5); 
        assertTrue(gaGhost.isDestroyed());
    }

    @Test
    void testGetHp() {
        assertEquals(3, gaGhost.getHp());
    }

    @Test
    void testDecreaseHp() {
        gaGhost.decreaseHp(3);
        assertEquals(0, gaGhost.getHp()); 
    }

    @Test
    void testDecreaseHpBelowZero() {
        gaGhost.decreaseHp(15);
        assertEquals(0, gaGhost.getHp());
    }


    @Test
    void testAttack() {
        GameController.getInstance().setHp(20); 
        gaGhost.attack();
        assertEquals(14, GameController.getInstance().getHp()); 
    }
   

    @Test
    void testToString() {
        assertEquals("GaGhost [HP: 3 , Energy: 6]", gaGhost.toString());
    }
}