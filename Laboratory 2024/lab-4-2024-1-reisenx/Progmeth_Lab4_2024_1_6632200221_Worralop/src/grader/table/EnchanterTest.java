package grader.table;

import item.weapon.Stick;
import item.weapon.Sword;
import org.junit.jupiter.api.Test;
import table.Enchanter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnchanterTest {

    @Test
    public void testInteract() {
        Enchanter enchanter = new Enchanter();
        Sword sword = new Sword();
        String s = enchanter.interact(sword);
        assertEquals("Upgrade successfully", s);

        sword.setLevel(3);
        String s2 = enchanter.interact(sword);
        assertEquals("Already max level", s2);
    }

    @Test
    public void testBadInteract() {
        Enchanter enchanter = new Enchanter();
        Stick stick = new Stick();
        String s = enchanter.interact(stick);
        assertEquals("This item cannot be upgraded", s);
    }

}
