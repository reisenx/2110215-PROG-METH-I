package test.grader;
import static org.junit.jupiter.api.Assertions.*;
import logic.components.Food;
import org.junit.jupiter.api.Test;

import exception.BadStatusException;
import logic.components.*;

public class PotionTest {
    @Test
    void testConstructor(){
        try {
            Potion potion1 = new Potion("testPotion1", 20, new Status(5, 3, 1, 2));
            assertEquals("testPotion1", potion1.getName());
            assertEquals(20, potion1.getPrice());
            assertEquals(5, potion1.getIncreasingStatus().getHp());
            assertEquals(3, potion1.getIncreasingStatus().getDurability());
            assertEquals(1, potion1.getIncreasingStatus().getAttack());
            assertEquals(2, potion1.getIncreasingStatus().getMagic());


            Potion potion2 = new Potion("testPotion2", -6, new Status(0, 0, 0, 0));
            assertEquals("testPotion2", potion2.getName());
            assertEquals(1, potion2.getPrice());
            assertEquals(0, potion2.getIncreasingStatus().getHp());
            assertEquals(0, potion2.getIncreasingStatus().getDurability());
            assertEquals(0, potion2.getIncreasingStatus().getAttack());
            assertEquals(0, potion2.getIncreasingStatus().getMagic());
        }
        catch(BadStatusException e){
            fail();
        }
    }
    @Test
    void testSetName(){
        try {
            Potion potion1 = new Potion("testPotion", 13, new Status(6, 4, 2, 2));
            potion1.setName("newPotion");
            assertEquals("newPotion", potion1.getName());
            potion1.setName("LittlePotion");
            assertEquals("LittlePotion", potion1.getName());
        }
        catch(BadStatusException e){
            fail();
        }
    }
    @Test
    void testSetPrice(){
        try{
        Potion potion1=new Potion("testPotion",21,new Status(6,4,2,2));
        potion1.setPrice(20);
        assertEquals(20,potion1.getPrice());
        potion1.setPrice(-1);
        assertEquals(1,potion1.getPrice());
        }
        catch(BadStatusException e){
            fail();
        }
    }
    @Test
    void testSetIncreasingStatus(){
        try {
            Potion potion1 = new Potion("testPotion1", 21, new Status(6, 4, 2, 3));
            potion1.setIncreasingStatus(new Status(0, 0, 0, 0));
            assertEquals(0, potion1.getIncreasingStatus().getHp());
            assertEquals(0, potion1.getIncreasingStatus().getDurability());
            assertEquals(0, potion1.getIncreasingStatus().getAttack());
            assertEquals(0, potion1.getIncreasingStatus().getMagic());
            potion1.setIncreasingStatus(new Status(4, 3, 6, 2));
            assertEquals(4, potion1.getIncreasingStatus().getHp());
            assertEquals(3, potion1.getIncreasingStatus().getDurability());
            assertEquals(6, potion1.getIncreasingStatus().getAttack());
            assertEquals(2, potion1.getIncreasingStatus().getMagic());
        }
        catch(BadStatusException e){
            fail();
        }
    }
}
