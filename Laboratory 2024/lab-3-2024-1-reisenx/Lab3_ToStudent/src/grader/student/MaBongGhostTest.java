package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.MaBongGhost;
import logic.ghost.MaBongGhost;

class MaBongGhostTest {

    MaBongGhost maBongGhost;

    @BeforeEach
    void setUp() {
        maBongGhost = new MaBongGhost(); 
    }
    
    @Test
    void testConstructor() {
    	// TODO: Fill your code
    }
    
    @Test
    void testIsDestroyedFalse() {
        assertFalse(maBongGhost.isDestroyed()); 
    }

    @Test
    void testIsDestroyedTrue() {
        maBongGhost.decreaseHp(30); 
        assertTrue(maBongGhost.isDestroyed()); 
    }

    @Test
    void testGetHp() {
        assertEquals(3, maBongGhost.getHp()); 
    }

    @Test
    void testDecreaseHp() {
        maBongGhost.decreaseHp(2);
        assertEquals(1, maBongGhost.getHp()); 
    }

    @Test
    void testDecreaseHpBelowZero() {
    	// TODO: Fill your code
    }

    @Test
    void testGetLevel() {
        assertEquals(1, maBongGhost.getLevel()); 
    }

    @Test
    void testAttack() {
        GameController.getInstance().setHp(50);
        maBongGhost.attack();
        assertEquals(46, GameController.getInstance().getHp());
    }

    @Test
    void testToString() {
        assertEquals("MaBongGhost [HP: 3 , Power: 4 , Speed: 1]", maBongGhost.toString()); // Assuming initial values
    }
}