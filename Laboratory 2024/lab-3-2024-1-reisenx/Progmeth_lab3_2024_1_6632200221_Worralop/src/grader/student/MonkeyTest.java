package grader.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.actor.Monkey;
import logic.game.GameController;
import logic.ghost.LowGhost;
import logic.ghost.MaBongGhost;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

class MonkeyTest {

    Monkey monkey;

    @BeforeEach
    void setUp() {
        monkey = new Monkey();
    }

    @Test
    void testGetLevel() {
        assertEquals(Config.MonkeyLevel, monkey.getLevel());
    }

    @Test
    void testAttackLowGhostWithoutBanana() {
        // Attack Low Ghost without Banana
        LowGhost lowGhost = new MaBongGhost();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(lowGhost);
        monkey.attack();
        assertEquals(2, lowGhost.getHp()); 
    }

    @Test
    void testAttackLowGhostWithBanana() {
        // Attack Low Ghost with Banana
        LowGhost lowGhost = new MaBongGhost();
        Banana banana = new Banana();
        GameController.getInstance().getGhosts().clear();
        GameController.getInstance().getItems().clear();
        GameController.getInstance().addNewGhost(lowGhost);
        GameController.getInstance().addNewItem(banana);
        monkey.attack();
        assertEquals(0, lowGhost.getHp());
    }

    @Test
    void testToString() {
        assertEquals("Monkey", monkey.toString());
    }
}