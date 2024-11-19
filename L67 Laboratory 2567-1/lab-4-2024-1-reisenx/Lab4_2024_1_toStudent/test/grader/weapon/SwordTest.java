package grader.weapon;

import item.weapon.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SwordTest {

    @Test
    public void testConstructor() {
        Sword sword = new Sword();
        assertEquals("Sword", sword.getName());
        assertEquals(15, sword.getDurability());
        assertEquals(1, sword.getRange());
        assertEquals(0, sword.getLevel());
    }

    @Test
    public void testSetLevel() {
        Sword sword = new Sword();
        sword.setLevel(3);
        assertEquals(3, sword.getLevel());
        sword.setLevel(-1);
        assertEquals(0, sword.getLevel());
        sword.setLevel(sword.getMaxLevel() + 1);
        assertEquals(0, sword.getLevel());
    }

    @Test
    public void testGetAtt() {
        Sword sword = new Sword();
        assertEquals(3, sword.getAtt());
        sword.setLevel(1);
        assertEquals(5, sword.getAtt());
        sword.setLevel(2);
        assertEquals(8, sword.getAtt());
        sword.setLevel(3);
        assertEquals(12, sword.getAtt());
    }

    @Test
    public void testToString() {
        Sword sword = new Sword();
        assertEquals("Sword (Att: 3, Range: 1, Level: 0, 15 uses left)", sword.toString());
    }
}

