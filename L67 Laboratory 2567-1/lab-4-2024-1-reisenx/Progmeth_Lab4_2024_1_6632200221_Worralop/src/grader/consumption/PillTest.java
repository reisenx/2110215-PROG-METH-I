package grader.consumption;

import item.consumption.Pill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PillTest {

    @Test
    public void testConstructor() {
        Pill pill = new Pill();
        assertEquals("Pill", pill.getName());
        assertEquals(2, pill.getRecoverPoint());
    }

    @Test
    public void testToString() {
        Pill pill = new Pill();
        assertEquals("Pill (+2 HP)", pill.toString());
    }
}
