package grader.table;

import item.armor.Suit;
import item.consumption.Pork;
import org.junit.jupiter.api.Test;
import table.Oven;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OvenTest {

    @Test
    public void testInteract() {
        Oven oven = new Oven();
        Pork pork = new Pork();
        String s = oven.interact(pork);
        assertEquals("Cooking succeed", s);
        String s2 = oven.interact(pork);
        assertEquals("Your food has been burnt", s2);
        String s3 = oven.interact(pork);
        assertEquals("Your food is already burnt, cannot be cooked anymore", s3);
    }

    @Test
    public void testBadInteract() {
        Oven oven = new Oven();
        Suit suit = new Suit();
        String s = oven.interact(suit);
        assertEquals("This item cannot be cooked", s);
    }
}
