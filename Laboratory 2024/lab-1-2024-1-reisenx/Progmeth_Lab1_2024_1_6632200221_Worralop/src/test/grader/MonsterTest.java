package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import exception.BadStatusException;
import logic.components.*;
import org.junit.jupiter.api.Test;

public class MonsterTest {
    @Test
    void testConstructor(){
        try {
            Monster monster = new Monster("testMonster", new Status(5, 3, 1, 6));
            assertEquals("testMonster", monster.getName());
            assertEquals(5, monster.getStatus().getHp());
            assertEquals(3, monster.getStatus().getDurability());
            assertEquals(1, monster.getStatus().getAttack());
            assertEquals(6, monster.getStatus().getMagic());
            assertEquals(null, monster.getFood());
            assertEquals(null, monster.getPotion());
            Monster monster2 = new Monster("testMonster2", new Status(0, 0, 0, 0));
            assertEquals("testMonster2", monster2.getName());
            assertEquals(1, monster2.getStatus().getHp());
            assertEquals(0, monster2.getStatus().getDurability());
            assertEquals(0, monster2.getStatus().getAttack());
            assertEquals(0, monster2.getStatus().getMagic());
            assertEquals(null, monster2.getFood());
            assertEquals(null, monster2.getPotion());
        }
        catch(BadStatusException e){
            fail();
        }
    }
    @Test
    void testAttack()  {
        try {
            Monster monster = new Monster("testMonster", new Status(5, 4, 3, 6));
            Player player1 = new Player("testPlayer", new Status(2, 2, 3, 3));
            monster.attack(player1);
            assertEquals(1, player1.getStatus().getHp());
            monster.attack(player1);
            assertEquals(0, player1.getStatus().getHp());
            monster.attack(player1);
            assertEquals(0, player1.getStatus().getHp());

            Player player2 = new Player("testPlayer2", new Status(5, 3, 2, 1));
            monster.attack(player2);
            assertEquals(5, player2.getStatus().getHp());
            Player player3 = new Player("testPlayer3", new Status(6, 6, 3, 4));
            monster.attack(player3);
            assertEquals(6, player3.getStatus().getHp());
        }
        catch(BadStatusException e){
            fail();
        }
    }
    @Test
    void testMagicAttack() {
        try {
            Monster monster = new Monster("testMonster", new Status(5, 4, 2, 4));
            Player player1 = new Player("testPlayer", new Status(5, 3, 3, 3));
            monster.magicAttack(player1);
            assertEquals(1, player1.getStatus().getHp());
            monster.magicAttack(player1);
            assertEquals(0, player1.getStatus().getHp());

            Player player2 = new Player("testPlayer2", new Status(11, 5, 2, 1));
            monster.magicAttack(player2);
            assertEquals(7, player2.getStatus().getHp());
            monster.magicAttack(player2);
            assertEquals(3, player2.getStatus().getHp());
            monster.magicAttack(player2);
            assertEquals(0, player2.getStatus().getHp());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testSetName(){
        try {
            Monster monster1 = new Monster("testMonster1", new Status(3, 1, 2, 3));
            monster1.setName("newMon");
            assertEquals("newMon", monster1.getName());
            monster1.setName("SpawnMon");
            assertEquals("SpawnMon", monster1.getName());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testSetStatus(){
        try {
            Monster monster1 = new Monster("testMonster1", new Status(3, 1, 2, 4));
            monster1.setStatus(new Status(7, 3, 1, 8));
            assertEquals(7, monster1.getStatus().getHp());
            assertEquals(3, monster1.getStatus().getDurability());
            assertEquals(1, monster1.getStatus().getAttack());
            assertEquals(8, monster1.getStatus().getMagic());
            monster1.setStatus(new Status(0, 0, 0, 0));
            assertEquals(0, monster1.getStatus().getHp());
            assertEquals(0, monster1.getStatus().getDurability());
            assertEquals(0, monster1.getStatus().getAttack());
            assertEquals(0, monster1.getStatus().getMagic());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testSetFood(){
        try {
            Monster monster1 = new Monster("testMonster1", new Status(3, 1, 2, 4));
            Food food1 = new Food("testFood1", 13, 7);
            monster1.setFood(food1);
            assertEquals("testFood1", monster1.getFood().getName());
            assertEquals(13, monster1.getFood().getPrice());
            assertEquals(7, monster1.getFood().getEnergy());
            Food food2 = new Food("testFood2", -4, -2);
            monster1.setFood(food2);
            assertEquals("testFood2", monster1.getFood().getName());
            assertEquals(1, monster1.getFood().getPrice());
            assertEquals(1, monster1.getFood().getEnergy());
        }
        catch(BadStatusException e){
            fail();
        }
    }

    @Test
    void testSetPotion(){
        try {
            Monster monster1 = new Monster("testMonster1", new Status(3, 1, 2, 4));
            Potion potion1 = new Potion("testPotion1", 12, new Status(0, 0, 0, 0));
            monster1.setPotion(potion1);
            assertEquals("testPotion1", monster1.getPotion().getName());
            assertEquals(12, monster1.getPotion().getPrice());
            assertEquals(0, monster1.getPotion().getIncreasingStatus().getHp());
            assertEquals(0, monster1.getPotion().getIncreasingStatus().getDurability());
            assertEquals(0, monster1.getPotion().getIncreasingStatus().getAttack());
            assertEquals(0, monster1.getPotion().getIncreasingStatus().getMagic());
            Potion potion2 = new Potion("testPotion2", -5, new Status(4, 5, 2, 1));
            monster1.setPotion(potion2);
            assertEquals("testPotion2", monster1.getPotion().getName());
            assertEquals(1, monster1.getPotion().getPrice());
            assertEquals(4, monster1.getPotion().getIncreasingStatus().getHp());
            assertEquals(5, monster1.getPotion().getIncreasingStatus().getDurability());
            assertEquals(2, monster1.getPotion().getIncreasingStatus().getAttack());
            assertEquals(1, monster1.getPotion().getIncreasingStatus().getMagic());
        }
        catch(BadStatusException e){
            fail();
        }
    }
}
