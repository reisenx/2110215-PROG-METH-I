package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.GaGhost;
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
    	// Implement Test
    	MaBongGhost a = new MaBongGhost();
    	MaBongGhost b = new MaBongGhost(-999);
    	MaBongGhost c = new MaBongGhost(10);
    	MaBongGhost d = new MaBongGhost(-99, -999);
    	MaBongGhost e = new MaBongGhost(99, -999);
    	MaBongGhost f = new MaBongGhost(-99, 999);
    	MaBongGhost g = new MaBongGhost(99, 999);
    	assertEquals("MaBongGhost [HP: 3 , Power: 4 , Speed: 1]", a.toString());
    	assertEquals("MaBongGhost [HP: 3 , Power: -999 , Speed: 1]", b.toString());
    	assertEquals("MaBongGhost [HP: 3 , Power: 10 , Speed: 1]", c.toString());
    	assertEquals("MaBongGhost [HP: 3 , Power: -99 , Speed: -999]", d.toString());
    	assertEquals("MaBongGhost [HP: 3 , Power: 99 , Speed: -999]", e.toString());
    	assertEquals("MaBongGhost [HP: 3 , Power: -99 , Speed: 999]", f.toString());
    	assertEquals("MaBongGhost [HP: 3 , Power: 99 , Speed: 999]", g.toString());
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
    	// Implement Test
    	MaBongGhost a = new MaBongGhost();
    	a.decreaseHp(999);
    	assertEquals(0, a.getHp());
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