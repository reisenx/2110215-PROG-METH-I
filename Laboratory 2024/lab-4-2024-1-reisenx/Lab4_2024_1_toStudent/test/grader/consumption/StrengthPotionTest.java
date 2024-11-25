package grader.consumption;

import item.consumption.StrengthPotion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrengthPotionTest {

    @Test
    public void testConstructor() {
        StrengthPotion strengthPotion = new StrengthPotion();
        assertEquals("StrengthPotion", strengthPotion.getName());
        assertEquals(0, strengthPotion.getLevel());
        assertEquals(3, strengthPotion.getMaxLevel());
    }

    @Test
    public void testSetLevel() {
        StrengthPotion strengthPotion = new StrengthPotion();
        strengthPotion.setLevel(1);
        assertEquals(1, strengthPotion.getLevel());
        strengthPotion.setLevel(strengthPotion.getMaxLevel() + 1);
        assertEquals(0, strengthPotion.getLevel());
        strengthPotion.setLevel(2);
        strengthPotion.setLevel(-1);
        assertEquals(0, strengthPotion.getLevel());
    }

    @Test
    public void testGetAttBuff() {
        StrengthPotion strengthPotion = new StrengthPotion();
        assertEquals(3, strengthPotion.getAttBuff());
        strengthPotion.setLevel(1);
        assertEquals(5, strengthPotion.getAttBuff());
        strengthPotion.setLevel(2);
        assertEquals(7, strengthPotion.getAttBuff());
        strengthPotion.setLevel(3);
        assertEquals(10, strengthPotion.getAttBuff());
    }

    @Test
    public void testToString() {
        StrengthPotion strengthPotion = new StrengthPotion();
        assertEquals("StrengthPotion (+3 Att for next 3 turns, Level: 0)", strengthPotion.toString());
    }

}
