package grader.consumption;

import item.consumption.HealingPotion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HealingPotionTest  {

    @Test
    public void testConstructor() {
        HealingPotion healingPotion = new HealingPotion();
        assertEquals("HealingPotion", healingPotion.getName());
        assertEquals(0, healingPotion.getLevel());
        assertEquals(3, healingPotion.getMaxLevel());
    }

    @Test
    public void testSetLevel() {
        HealingPotion healingPotion = new HealingPotion();
        healingPotion.setLevel(1);
        assertEquals(1, healingPotion.getLevel());
        healingPotion.setLevel(healingPotion.getMaxLevel() + 1);
        assertEquals(0, healingPotion.getLevel());
        healingPotion.setLevel(2);
        healingPotion.setLevel(-1);
        assertEquals(0, healingPotion.getLevel());
    }

    @Test
    public void testGetRecoverPoint() {
        HealingPotion healingPotion = new HealingPotion();
        assertEquals(3, healingPotion.getRecoverPoint());
        healingPotion.setLevel(1);
        assertEquals(5, healingPotion.getRecoverPoint());
        healingPotion.setLevel(2);
        assertEquals(7, healingPotion.getRecoverPoint());
        healingPotion.setLevel(3);
        assertEquals(10, healingPotion.getRecoverPoint());
    }

    @Test
    public void testToString() {
        HealingPotion healingPotion = new HealingPotion();
        assertEquals("HealingPotion (+3 HP, Level: 0)", healingPotion.toString());
    }
}
