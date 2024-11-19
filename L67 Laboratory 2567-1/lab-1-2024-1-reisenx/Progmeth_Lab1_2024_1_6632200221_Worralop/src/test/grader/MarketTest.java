package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import exception.BadStatusException;
import logic.components.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MarketTest {
    @Test
    void testConstructor(){
        Market market1 = new Market("market");
        Market market2 = new Market("market2");
        assertEquals("market",market1.getName());
        assertEquals(new ArrayList<Food>(),market1.getFoods());
        assertEquals(new ArrayList<Potion>(),market1.getPotions());

        assertEquals("market2",market2.getName());
        assertEquals(new ArrayList<Food>(),market2.getFoods());
        assertEquals(new ArrayList<Potion>(),market2.getPotions());
    }

    @Test
    void testSetName(){
        Market market1 = new Market("Tokyo");
        Market market2 = new Market("Tokyo2");
        market1.setName("nara1");
        market2.setName("nara2");
        assertEquals("nara1",market1.getName());
        assertEquals("nara2",market2.getName());
    }
    @Test
    void testSetFood(){
        ArrayList<Food> foods=new ArrayList<Food>();
        ArrayList<Food> foods2=new ArrayList<Food>();

        Food food1 = new Food("Nuggets",13,6);
        Food food2 = new Food("Bread",10,3);
        Food food11 = new Food("Nuggets",13,6);
        Food food22 = new Food("Bread",10,3);

        Market market1= new Market("testMarket");

        market1.setFoods(foods);
        assertEquals(foods,market1.getFoods());

        foods.add(food1);
        foods2.add(food11);
        market1.setFoods(foods);
        assertEquals(foods2,market1.getFoods());

        foods.add(food2);
        foods2.add(food22);
        market1.setFoods(foods);
        assertEquals(foods2,market1.getFoods());
    }
    @Test
    void testSetPotions(){
        try {
            ArrayList<Potion> potions = new ArrayList<Potion>();
            ArrayList<Potion> potions2 = new ArrayList<Potion>();
            Potion potion1 = new Potion("Heal1", 13, new Status(6, 5, 4, 3));
            Potion potion2 = new Potion("Magic1", 12, new Status(2, 1, 5, 7));
            Potion potion11 = new Potion("Heal1", 13, new Status(6, 5, 4, 3));
            Potion potion22 = new Potion("Magic1", 12, new Status(2, 1, 5, 7));

            Market market = new Market("testMarket");
            market.setPotions(potions);
            assertEquals(potions, market.getPotions());

            potions.add(potion2);
            potions2.add(potion22);
            market.setPotions(potions);
            assertEquals(potions2, market.getPotions());

            potions.add(potion1);
            potions2.add(potion11);
            market.setPotions(potions);
            assertEquals(potions2, market.getPotions());
        }
        catch(BadStatusException e){
            fail();
        }
    }
}
