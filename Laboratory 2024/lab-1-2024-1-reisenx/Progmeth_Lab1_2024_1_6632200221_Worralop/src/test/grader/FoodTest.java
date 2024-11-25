package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import logic.components.Food;
import org.junit.jupiter.api.Test;
public class FoodTest{
    @Test
    void testConstructor(){
        Food food1 = new Food("food1",11,20);
        Food food2 = new Food("food2",1,2);
        Food food3 = new Food("food3",-12,-18);
        assertEquals("food1",food1.getName());
        assertEquals(11,food1.getPrice());
        assertEquals(20,food1.getEnergy());
        assertEquals("food2",food2.getName());
        assertEquals(1,food2.getPrice());
        assertEquals(2,food2.getEnergy());
        assertEquals("food3",food3.getName());
        assertEquals(1,food3.getPrice());
        assertEquals(1,food3.getEnergy());
    }

    @Test
    void testSetName(){
        Food food1 = new Food("Testfood1",10,20);
        food1.setName("Ohno");
        assertEquals("Ohno",food1.getName());
    }

    @Test
    void testSetPrice(){
        Food food1 = new Food("Testfood1",10,20);
        food1.setPrice(15);
        assertEquals(15,food1.getPrice());
        food1.setPrice(0);
        assertEquals(1,food1.getPrice());
        food1.setPrice(-1);
        assertEquals(1,food1.getPrice());
    }

    @Test
    void testSetEnergy(){
        Food food1 = new Food("Testfood1",10,20);
        food1.setEnergy(15);
        assertEquals(15,food1.getEnergy());
        food1.setEnergy(0);
        assertEquals(1,food1.getEnergy());
        food1.setEnergy(-1);
        assertEquals(1,food1.getEnergy());
    }


}
