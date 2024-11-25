package test.grader;

import logic.game.GameSystem;
import monkey.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameSystemTest {

    @Test
    void testAddApe() {
        ArrayList<BaseMonkey> apeContainer = GameSystem.getInstance().getApeContainer();
        apeContainer.clear();

        GameSystem.getInstance().addApe();
        assertEquals(3, apeContainer.size());

        for (int i = 0; i < 3; i++) {
            assertEquals(200, apeContainer.get(i).getMaxHp());
            assertEquals(30, apeContainer.get(i).getAtk());
            assertEquals(10, apeContainer.get(i).getDef());
        }
    }

    @Test
    void testRemoveDeadEntity() {
        ArrayList<BaseMonkey> apeContainer = GameSystem.getInstance().getApeContainer();
        apeContainer.clear();
        GameSystem.getInstance().addApe();

        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getApeContainer());
        assertEquals(3, GameSystem.getInstance().getApeContainer().size());

        apeContainer.get(0).setHp(0);
        apeContainer.get(1).setHp(0);

        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getApeContainer());
        assertEquals(1, GameSystem.getInstance().getApeContainer().size());

        ArrayList<BaseMonkey> monkeyContainer = GameSystem.getInstance().getMonkeyContainer();
        monkeyContainer.clear();
        BaseMonkey m1 = new BaseMonkey(100, 15, 10);
        MuscleMonkey m2 = new MuscleMonkey(200, 20, 10);
        MommyMonkey m3 = new MommyMonkey(80, 0, 10);
        UgabugagaMonkey m4 = new UgabugagaMonkey(80, 10, 15);

        monkeyContainer.add(m1);
        monkeyContainer.add(m2);
        monkeyContainer.add(m3);
        monkeyContainer.add(m4);

        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getMonkeyContainer());
        assertEquals(4, GameSystem.getInstance().getMonkeyContainer().size());

        monkeyContainer.get(0).setHp(0);
        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getMonkeyContainer());
        assertEquals(3, GameSystem.getInstance().getMonkeyContainer().size());

        monkeyContainer.get(1).setHp(0);
        GameSystem.getInstance().removeDeadEntity(GameSystem.getInstance().getMonkeyContainer());
        assertEquals(2, GameSystem.getInstance().getMonkeyContainer().size());
        
        assertEquals("MuscleMonkey",GameSystem.getInstance().getMonkeyContainer().get(0).getClass().getSimpleName());
        assertEquals("UgabugagaMonkey",GameSystem.getInstance().getMonkeyContainer().get(1).getClass().getSimpleName());

        GameSystem.getInstance().getMonkeyContainer().clear();
    }
    
    @Test 
    void testFight(){
    	Ape ape = new Ape(50, 10, 5);
    	BaseMonkey base = new BaseMonkey(50,10,5);
    	MommyMonkey mommy = new MommyMonkey(50, 10, 5);
    	MuscleMonkey muscle = new MuscleMonkey(50, 10, 5);
    	UgabugagaMonkey uga = new UgabugagaMonkey(50, 10, 5);
    	
    	ArrayList<BaseMonkey> container = GameSystem.getInstance().getMonkeyContainer();
    	container.add(base);
    	container.add(mommy);
    	container.add(muscle);
    	container.add(uga);
    	
    	BaseMonkey r1 = GameSystem.fight(base, mommy);
    	assertTrue(r1 instanceof MommyMonkey);
    	assertEquals(45, r1.getHp());
    	
    	r1 = GameSystem.fight(mommy, muscle);
    	assertTrue(r1 instanceof MuscleMonkey);
    	assertEquals(50, r1.getHp());
    	
    	r1 = GameSystem.fight(muscle, uga);
    	assertTrue(r1 instanceof UgabugagaMonkey);
    	assertEquals(40, r1.getHp());
    	
    	r1 = GameSystem.fight(uga, ape);
    	assertTrue(r1 instanceof Ape);
    	assertEquals(45, r1.getHp());
    	assertEquals(9, r1.getAtk());
    	assertEquals(4, r1.getDef());
    	
    	r1 = GameSystem.fight(ape, base);
    	assertEquals("BaseMonkey", r1.getClass().getSimpleName());
    	assertEquals(46, r1.getHp());
	
    	
    }
    
}