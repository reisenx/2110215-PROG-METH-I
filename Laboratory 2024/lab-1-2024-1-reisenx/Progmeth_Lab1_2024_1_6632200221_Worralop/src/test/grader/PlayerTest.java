package test.grader;


import exception.BadStatusException;
import logic.components.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PlayerTest {
    @Test
    void testConstructor()  {
        try {
            Player player1 = new Player("Player1", new Status(1, 3, 6, 7));
            Player player2 = new Player("Player2", new Status(0, 0, 0, 0));
            assertEquals("Player1", player1.getName());
            assertEquals(1, player1.getStatus().getHp());
            assertEquals(3, player1.getStatus().getDurability());
            assertEquals(6, player1.getStatus().getAttack());
            assertEquals(7, player1.getStatus().getMagic());
            assertEquals(new ArrayList<Food>(), player1.getFoods());
            assertEquals(10, player1.getEnergy());
            assertEquals(100, player1.getMoney());
            assertEquals(new ArrayList<Potion>(), player1.getPotions());
            assertEquals(new ArrayList<Ore>(), player1.getOres());

            assertEquals("Player2", player2.getName());
            assertEquals(1, player2.getStatus().getHp());
            assertEquals(0, player2.getStatus().getDurability());
            assertEquals(0, player2.getStatus().getAttack());
            assertEquals(0, player2.getStatus().getMagic());
            assertEquals(new ArrayList<Food>(), player2.getFoods());
            assertEquals(10, player2.getEnergy());
            assertEquals(100, player2.getMoney());
            assertEquals(new ArrayList<Potion>(), player2.getPotions());
            assertEquals(new ArrayList<Ore>(), player2.getOres());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testDetailedConstructor()  {
        try {
            Player player1 = new Player("testPlayer1", new Status(10, 25, 30, 40), 15, 30);
            Player player2 = new Player("testPlayer2", new Status(0, 0, 0, 0), -2, -8);
            assertEquals("testPlayer1", player1.getName());
            assertEquals(10, player1.getStatus().getHp());
            assertEquals(25, player1.getStatus().getDurability());
            assertEquals(30, player1.getStatus().getAttack());
            assertEquals(40, player1.getStatus().getMagic());
            assertEquals(new ArrayList<Food>(), player1.getFoods());
            assertEquals(15, player1.getEnergy());
            assertEquals(30, player1.getMoney());
            assertEquals(new ArrayList<Potion>(), player1.getPotions());
            assertEquals(new ArrayList<Ore>(), player1.getOres());

            assertEquals("testPlayer2", player2.getName());
            assertEquals(1, player2.getStatus().getHp());
            assertEquals(0, player2.getStatus().getDurability());
            assertEquals(0, player2.getStatus().getAttack());
            assertEquals(0, player2.getStatus().getMagic());
            assertEquals(new ArrayList<Food>(), player2.getFoods());
            assertEquals(0, player2.getEnergy());
            assertEquals(0, player2.getMoney());
            assertEquals(new ArrayList<Potion>(), player2.getPotions());
            assertEquals(new ArrayList<Ore>(), player2.getOres());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testBuyOre()  {
        try {
            Player player1 = new Player("testPlayer1", new Status(10, 10, 10, 10), 10, 1100);
            Ore ore1 = new Ore("testOre1", 700);
            Ore ore2 = new Ore("testOre2", 250);
            Ore ore3 = new Ore("testOre3", 200);
            ArrayList<Ore> ores = new ArrayList<Ore>();
            assertEquals(true, player1.buyOre(ore1));
            ores.add(ore1);
            assertEquals(ores, player1.getOres());
            assertEquals(400, player1.getMoney());

            assertEquals(true, player1.buyOre(ore2));
            ores.add(ore2);
            assertEquals(ores, player1.getOres());
            assertEquals(150, player1.getMoney());

            assertEquals(false, player1.buyOre(ore3));
            assertEquals(ores, player1.getOres());
            assertEquals(150, player1.getMoney());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testDrinkPotion()  {
        try {
            Player player = new Player("testPlayer1", new Status(10, 12, 13, 14), 10, 100);
            Potion potion1 = new Potion("testPotion1", 20, new Status(2, 3, 4, 5));
            Potion potion2 = new Potion("testPotion2", 40, new Status(1, 3, 5, 7));
            ArrayList<Potion> potions = new ArrayList<Potion>();
            potions.add(potion1);
            potions.add(potion2);
            player.getPotions().add(potion1);
            player.getPotions().add(potion2);
            player.drinkPotion(-1);
            assertEquals(10, player.getStatus().getHp());
            assertEquals(12, player.getStatus().getDurability());
            assertEquals(13, player.getStatus().getAttack());
            assertEquals(14, player.getStatus().getMagic());
            player.drinkPotion(2);
            assertEquals(10, player.getStatus().getHp());
            assertEquals(12, player.getStatus().getDurability());
            assertEquals(13, player.getStatus().getAttack());
            assertEquals(14, player.getStatus().getMagic());
            player.drinkPotion(0);
            assertEquals(12, player.getStatus().getHp());
            assertEquals(15, player.getStatus().getDurability());
            assertEquals(17, player.getStatus().getAttack());
            assertEquals(19, player.getStatus().getMagic());
            potions.remove(0);
            assertEquals(potions, player.getPotions());
            player.drinkPotion(0);
            assertEquals(13, player.getStatus().getHp());
            assertEquals(18, player.getStatus().getDurability());
            assertEquals(22, player.getStatus().getAttack());
            assertEquals(26, player.getStatus().getMagic());
            potions.remove(0);
            assertEquals(potions, player.getPotions());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testEatFood()  {
        try {
            Player player = new Player("testPlayer1", new Status(10, 12, 13, 14), 10, 100);
            Food food1 = new Food("testFood1", 12, 10);
            Food food2 = new Food("testFood2", 10, 5);
            ArrayList<Food> foods = new ArrayList<Food>();
            foods.add(food1);
            foods.add(food2);
            player.getFoods().add(food1);
            player.getFoods().add(food2);
            player.eatFood(-1);
            assertEquals(10, player.getEnergy());
            player.eatFood(2);
            assertEquals(10, player.getEnergy());
            player.eatFood(1);
            assertEquals(15, player.getEnergy());
            foods.remove(1);
            assertEquals(foods, player.getFoods());
            player.eatFood(0);
            assertEquals(25, player.getEnergy());
            foods.remove(0);
            assertEquals(foods, player.getFoods());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testSellPotion()  {
        try {
            Player player = new Player("testPlayer1", new Status(10, 12, 13, 14), 10, 100);
            Potion potion1 = new Potion("testPotion1", 30, new Status(1, 2, 3, 4));
            Potion potion2 = new Potion("testPotion2", 50, new Status(1, 3, 5, 7));
            ArrayList<Potion> potions = new ArrayList<Potion>();
            potions.add(potion1);
            potions.add(potion2);
            player.getPotions().add(potion1);
            player.getPotions().add(potion2);
            player.sellPotion(-1);
            assertEquals(100, player.getMoney());
            player.sellPotion(2);
            assertEquals(100, player.getMoney());
            player.sellPotion(1);
            assertEquals(150, player.getMoney());
            potions.remove(1);
            assertEquals(potions, player.getPotions());
            player.sellPotion(1);
            assertEquals(150, player.getMoney());
            assertEquals(potions, player.getPotions());
            player.sellPotion(0);
            assertEquals(180, player.getMoney());
            potions.remove(0);
            assertEquals(potions, player.getPotions());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testSellFood()  {
        try {
            Player player = new Player("testPlayer1", new Status(10, 12, 13, 14), 10, 100);
            Food food1 = new Food("testFood1", 12, 3);
            Food food2 = new Food("testFood2", 20, 4);
            ArrayList<Food> foods = new ArrayList<Food>();
            foods.add(food1);
            foods.add(food2);
            player.getFoods().add(food1);
            player.getFoods().add(food2);
            player.sellFood(-1);
            assertEquals(100, player.getMoney());
            player.sellFood(2);
            assertEquals(100, player.getMoney());
            player.sellFood(0);
            assertEquals(112, player.getMoney());
            foods.remove(0);
            assertEquals(foods, player.getFoods());
            player.sellFood(1);
            assertEquals(112, player.getMoney());
            assertEquals(foods, player.getFoods());
            player.sellFood(0);
            assertEquals(132, player.getMoney());
            foods.remove(0);
            assertEquals(foods, player.getFoods());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testAttack()  {
        try {
            Player player = new Player("testPlayer", new Status(5, 3, 6, 3));
            Monster monster1 = new Monster("testMonster1", new Status(5, 2, 3, 3));
            player.attack(monster1);
            assertEquals(1, monster1.getStatus().getHp());
            player.attack(monster1);
            assertEquals(0, monster1.getStatus().getHp());

            Monster monster2 = new Monster("testMonster2", new Status(10, 6, 2, 1));
            player.attack(monster2);
            assertEquals(10, monster2.getStatus().getHp());

            Monster monster3 = new Monster("testMonster3", new Status(8, 7, 3, 4));
            player.attack(monster3);
            assertEquals(8, monster3.getStatus().getHp());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testMagicAttack()  {
        try {
            Player player = new Player("testPlayer", new Status(5, 3, 5, 6));
            Monster monster1 = new Monster("testMonster1", new Status(15, 2, 3, 3));
            player.magicAttack(monster1);
            assertEquals(9, monster1.getStatus().getHp());
            player.magicAttack(monster1);
            assertEquals(3, monster1.getStatus().getHp());
            player.magicAttack(monster1);
            assertEquals(0, monster1.getStatus().getHp());

        }
        catch(BadStatusException e){
            fail();
        }
    }


    @Test
    void testSetName()  {
        try {
            Player player1 = new Player("testPlayer1", new Status(5, 3, 5, 3));
            player1.setName("newPlayer");
            assertEquals("newPlayer", player1.getName());
            player1.setName("Beginner");
            assertEquals("Beginner", player1.getName());
        }
        catch(BadStatusException e){
            fail();
        }
    }



    @Test
    void testSetStatus()  {
        try {
            Player player1 = new Player("testPlayer1", new Status(5, 3, 1, 4));
            player1.setStatus(new Status(9, 2, 3, 4));
            assertEquals(9, player1.getStatus().getHp());
            assertEquals(2, player1.getStatus().getDurability());
            assertEquals(3, player1.getStatus().getAttack());
            assertEquals(4, player1.getStatus().getMagic());
            player1.setStatus(new Status(0, 0, 0, 0));
            assertEquals(0, player1.getStatus().getHp());
            assertEquals(0, player1.getStatus().getDurability());
            assertEquals(0, player1.getStatus().getAttack());
            assertEquals(0, player1.getStatus().getMagic());
        }
        catch(BadStatusException e){
            fail();
        }
    }



    @Test
    void testSetEnergy()  {
        try {
            Player player1 = new Player("testPlayer1", new Status(5, 3, 1, 4));
            player1.setEnergy(20);
            assertEquals(20, player1.getEnergy());
            player1.setEnergy(-4);
            assertEquals(0, player1.getEnergy());
        }
        catch(BadStatusException e){
            fail();
        }
    }


    @Test
    void testSetMoney()  {
        try {
            Player player1 = new Player("testPlayer1", new Status(5, 3, 1, 4));
            player1.setMoney(300);
            assertEquals(300, player1.getMoney());
            player1.setMoney(-8);
            assertEquals(0, player1.getMoney());
        }
        catch(BadStatusException e){
            fail();
        }
    }


    @Test
    void testSetFoods()  {
        try {
            Player player1 = new Player("testPlayer1", new Status(5, 3, 1, 4));
            Food food1 = new Food("Pizza", 13, 5);
            Food food2 = new Food("Spaghetti", 11, 3);

            Food food11 = new Food("Pizza", 13, 5);
            Food food22 = new Food("Spaghetti", 11, 3);

            ArrayList<Food> foods = new ArrayList<Food>();
            ArrayList<Food> foods2 = new ArrayList<Food>();

            foods.add(food1);
            foods2.add(food11);
            player1.setFoods(foods);
            assertEquals(foods2, player1.getFoods());

            foods.add(food2);
            foods2.add(food22);
            player1.setFoods(foods);
            assertEquals(foods2, player1.getFoods());

        }
        catch(BadStatusException e){
            fail();
        }
    }


    @Test
    void testSetOres()  {
        try {
            Player player1 = new Player("testPlayer1", new Status(5, 3, 1, 4));
            Ore ore1 = new Ore("ore1", 800);
            Ore ore2 = new Ore("ore2", 300);

            Ore ore11 = new Ore("ore1", 800);
            Ore ore22 = new Ore("ore2", 300);

            ArrayList<Ore> ores = new ArrayList<Ore>();
            ArrayList<Ore> ores2 = new ArrayList<Ore>();

            assertEquals(ores, player1.getOres());
            ores.add(ore1);
            ores2.add(ore11);
            player1.setOres(ores);
            assertEquals(ores2, player1.getOres());

            ores.add(ore2);
            ores2.add(ore22);
            player1.setOres(ores);
            assertEquals(ores2, player1.getOres());
        }catch(BadStatusException e){
            fail();
        }
    }
}
