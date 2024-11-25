package grader.weapon;

import item.weapon.Stick;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StickTest {

    @Test
    public void testConstructor() {
        Stick stick = new Stick();
        assertEquals("Stick", stick.getName());
        assertEquals(1, stick.getAtt());
        assertEquals(3, stick.getDurability());
        assertEquals(0, stick.getRange());
    }

}
