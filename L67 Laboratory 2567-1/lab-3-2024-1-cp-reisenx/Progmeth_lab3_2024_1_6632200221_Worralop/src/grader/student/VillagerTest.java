package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Villager;
import logic.game.GameController;
import logic.ghost.GaGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Item;
import utils.Config;

class VillagerTest {

    Villager villager;

    @BeforeEach
    void setUp() {
        villager = new Villager();
    }

    @Test
    void testGetLevel() {
        assertEquals(Config.VillagerLevel, villager.getLevel());
    }

    @Test
    void testAttackLowGhostWithoutAmulet() {
        // Attack Low Ghost without Amulet
        LowGhost lowGhost = new GaGhost();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(lowGhost);
        villager.attack();
        assertEquals(0, lowGhost.getHp()); 
    }

    @Test
    void testAttackLowGhostWithAmulet() {
        // Attack Low Ghost with Amulet
        LowGhost lowGhost = new GaGhost();
        Amulet amulet = new Amulet();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(lowGhost);
        GameController.getInstance().addNewItem(amulet);
        villager.attack();
        assertEquals(0, lowGhost.getHp());
    }

    @Test
    void testToString() {
        assertEquals("Villager", villager.toString());
    }
}