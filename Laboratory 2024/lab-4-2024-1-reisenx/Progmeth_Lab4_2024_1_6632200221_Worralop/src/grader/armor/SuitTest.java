package grader.armor;

import item.armor.Suit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuitTest {

    @Test
    public void testConstructor() {
        Suit suit = new Suit();
        assertEquals("Suit", suit.getName());
        assertEquals(0, suit.getLevel());
        assertEquals(3, suit.getMaxLevel());
    }

    @Test
    public void testSetLevel() {
        Suit suit = new Suit();
        suit.setLevel(2);
        assertEquals(2, suit.getLevel());
        suit.setLevel(-1);
        assertEquals(0, suit.getLevel());
        suit.setLevel(1);
        suit.setLevel(suit.getMaxLevel() + 1);
        assertEquals(0, suit.getLevel());
    }

    @Test
    public void testGetDef() {
        Suit suit = new Suit();
        assertEquals(1, suit.getDef());
        suit.setLevel(1);
        assertEquals(2, suit.getDef());
        suit.setLevel(2);
        assertEquals(3, suit.getDef());
        suit.setLevel(3);
        assertEquals(5, suit.getDef());
    }

    @Test
    public void testToString() {
        Suit suit = new Suit();
        assertEquals("Suit (Def: 1, Level: 0)", suit.toString());
    }

}
