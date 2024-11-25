package grader.armor;

import item.armor.Boots;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BootsTest {

    @Test
    public void testConstructor() {
        Boots boots = new Boots();
        assertEquals("Boots", boots.getName());
        assertEquals(5, boots.getDurability());
        assertEquals(1, boots.getDef());
    }

}
