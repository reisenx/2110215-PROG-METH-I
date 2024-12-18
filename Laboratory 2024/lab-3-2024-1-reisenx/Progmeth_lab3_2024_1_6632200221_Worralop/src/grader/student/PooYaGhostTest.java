package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.PooYaGhost;
import logic.ghost.PongGhost;

class PooYaGhostTest {

    PooYaGhost pooYaGhost;

    @BeforeEach
    void setUp() {
        pooYaGhost = new PooYaGhost(2); 
    }
    
    @Test
    void testIsDestroyedFalse() {
        assertFalse(pooYaGhost.isDestroyed()); 
    }

    @Test
    void testIsDestroyedTrue() {
        pooYaGhost.decreaseHp(10);
        assertTrue(pooYaGhost.isDestroyed());
    }

    @Test
    void testGetHp() {
        assertEquals(10, pooYaGhost.getHp()); 
    }

    @Test
    void testDecreaseHp() {
        pooYaGhost.decreaseHp(3);
        assertEquals(7, pooYaGhost.getHp()); 
    }

    @Test
    void testDecreaseHpBelowZero() {
        pooYaGhost.decreaseHp(15);
        assertEquals(0, pooYaGhost.getHp());
    }


    @Test
    void testAttack() {
        GameController.getInstance().setHp(20); 
        GameController.getInstance().setScore(15); 
        pooYaGhost.attack();
        assertEquals(18, GameController.getInstance().getHp());
        assertEquals(13, GameController.getInstance().getScore()); 
    }
    
   
    @Test
    void testToString() {
        assertEquals("PooYaGhost [HP: 10 , Power: 2]", pooYaGhost.toString()); 
    }

    @Test
    void testDamage() {
    	// Implement Test
    	GameController.getInstance().getGhosts().clear();
    	GaGhost ghost1 = new GaGhost();
    	PongGhost ghost2 = new PongGhost();
    	PooYaGhost ghost3 = new PooYaGhost(1);
    	PooYaGhost healer = new PooYaGhost(10);
    	GameController.getInstance().addNewGhost(ghost1);
    	GameController.getInstance().addNewGhost(ghost2);
    	GameController.getInstance().addNewGhost(ghost3);
    	assertEquals(3, GameController.getInstance().getGhosts().get(0).getHp());
    	assertEquals(10, GameController.getInstance().getGhosts().get(1).getHp());
    	assertEquals(10, GameController.getInstance().getGhosts().get(2).getHp());
    	healer.damage();
    	assertEquals(13, GameController.getInstance().getGhosts().get(0).getHp());
    	assertEquals(20, GameController.getInstance().getGhosts().get(1).getHp());
    	assertEquals(20, GameController.getInstance().getGhosts().get(2).getHp());
    }

}