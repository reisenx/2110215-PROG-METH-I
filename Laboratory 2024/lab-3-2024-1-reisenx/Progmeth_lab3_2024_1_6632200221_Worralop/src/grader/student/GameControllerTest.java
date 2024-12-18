package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Actor;
import logic.actor.GhostDoctor;
import logic.actor.Villager;
import logic.game.GameController;
import logic.game.GameIO;
import logic.ghost.GaGhost;
import logic.ghost.Ghost;
import logic.ghost.PooYaGhost;
import logic.ghost.PryGhost;
import logic.item.Item;
import logic.item.Leklai;

class GameControllerTest {
    @Test
    void testPlayNotDestroyedGhost() {
        Actor actor = new Villager();
        
        Ghost g1 = new PooYaGhost(8);
        Ghost g2 = new GaGhost();
        Ghost g3 = new PryGhost();
        
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(g1);
        GameController.getInstance().addNewGhost(g2);
        GameController.getInstance().addNewGhost(g3);
        
        GameController.getInstance().play(actor);
        
        assertEquals(g1, GameController.getInstance().getGhosts().get(0));
        assertEquals(3, GameController.getInstance().getGhosts().size());
    }
    
    @Test
    void testPlayDestroyedGhost() {
    	// Implement Test
    	Actor actor = new GhostDoctor();
        GaGhost ghost1 = new GaGhost();
        GaGhost ghost2 = new GaGhost(10);
        GaGhost ghost3 = new GaGhost(15);
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(ghost1);
        GameController.getInstance().addNewGhost(ghost2);
        GameController.getInstance().addNewGhost(ghost3);
        // Check current ghost
        assertEquals("GaGhost [HP: 3 , Energy: 6]", ghost1.toString());
        // Check after play
        GameController.getInstance().play(actor);
        assertEquals(3, GameController.getInstance().getGhosts().size());
        assertEquals("GaGhost [HP: 3 , Energy: 10]", GameController.getInstance().getGhosts().get(0).toString());
        assertEquals("GaGhost [HP: 3 , Energy: 15]", GameController.getInstance().getGhosts().get(1).toString());
    }
    
    @Test
    void testPlayWithItem() {
    	// Implement Test
    	Actor actor = new Villager();
        Item item = new Leklai();
        GaGhost ghost1 = new GaGhost();
        PryGhost ghost2 = new PryGhost();
        PooYaGhost ghost3 = new PooYaGhost(10);
        // Add Ghost to the ghosts ArrayList
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().addNewGhost(ghost1);
        GameController.getInstance().addNewGhost(ghost2);
        GameController.getInstance().addNewGhost(ghost3);
        // Add Leklai to the items ArrayList
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewItem(item);
        // Testing (GaGhost and PryGhost are dead)
        GameController.getInstance().play(actor);
        assertEquals(10, GameController.getInstance().getGhosts().get(0).getHp());

    }
    @Test
    void testIsGameOver() {
    	// Implement Test
    	GameController.getInstance().setHp(0);
    	assertEquals(true, GameController.getInstance().isGameOver());
    	GameController.getInstance().setHp(999);
    	assertEquals(false, GameController.getInstance().isGameOver());
    }

}