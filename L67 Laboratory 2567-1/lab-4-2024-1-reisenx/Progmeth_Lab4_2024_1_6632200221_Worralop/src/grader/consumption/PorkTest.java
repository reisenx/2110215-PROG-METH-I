package grader.consumption;

import item.consumption.Pork;
import item.usage.CookState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PorkTest {

    @Test
    public void testConstructor() {
        Pork pork = new Pork();
        assertEquals("Pork", pork.getName());
        assertEquals(CookState.RAW, pork.getCookState());
    }

    @Test
    public void testGetRecoverPoint() {
        Pork pork = new Pork();
        assertEquals(1, pork.getRecoverPoint());
        pork.setCookState(CookState.COOKED);
        assertEquals(2, pork.getRecoverPoint());
        pork.setCookState(CookState.BURNT);
        assertEquals(0, pork.getRecoverPoint());
    }

    @Test
    public void testToString() {
        Pork pork = new Pork();
        assertEquals("Raw Pork (+1 HP)", pork.toString());
        pork.setCookState(CookState.COOKED);
        assertEquals("Cooked Pork (+2 HP)", pork.toString());
    }
}
