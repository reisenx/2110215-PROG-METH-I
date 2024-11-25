package test.grader;
import static org.junit.jupiter.api.Assertions.*;
import logic.components.*;
import org.junit.jupiter.api.Test;
public class OreTest {
    @Test
    void testConstructor(){
        Ore ore1 = new Ore("testOre1",11);
        Ore ore2 = new Ore("testOre2",-11);
        assertEquals("testOre1",ore1.getName());
        assertEquals("testOre2",ore2.getName());
        assertEquals(11,ore1.getCost());
        assertEquals(1,ore2.getCost());
    }

    @Test
    void testSetName(){
        Ore ore1 = new Ore("testOre1",10);
        ore1.setName("x");
        assertEquals("x",ore1.getName());
        ore1.setName("y");
        assertEquals("y",ore1.getName());
    }

    @Test
    void testSetCost(){
        Ore ore1 = new Ore("testOre1",10);
        ore1.setCost(33);
        assertEquals(33,ore1.getCost());

        ore1.setCost(1);
        assertEquals(1,ore1.getCost());

        ore1.setCost(0);
        assertEquals(1,ore1.getCost());

        ore1.setCost(-1);
        assertEquals(1,ore1.getCost());


    }
}
