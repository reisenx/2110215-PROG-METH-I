package test.grader;

import monkey.MuscleMonkey;
import monkey.MommyMonkey;
import monkey.MuscleMonkey;
import monkey.UgabugagaMonkey;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MuscleMonkeyTest {
    @Test
    public void testConstructor() {
        MuscleMonkey comp=new MuscleMonkey(200,20,10);
        assertEquals(200,comp.getMaxHp());
        assertEquals(200,comp.getHp());
        assertEquals(20,comp.getAtk());
        assertEquals(10,comp.getDef());
        assertEquals(4,comp.getPowerUp());

        MuscleMonkey comp1=new MuscleMonkey(400,200,110);
        assertEquals(400,comp1.getMaxHp());
        assertEquals(400,comp1.getHp());
        assertEquals(200,comp1.getAtk());
        assertEquals(110,comp1.getDef());
        assertEquals(4,comp1.getPowerUp());
    }
    @Test
    public void testBadConstructor() {
        MuscleMonkey comp=new MuscleMonkey(-100,-20,-10);
        assertEquals(0,comp.getMaxHp());
        assertEquals(0,comp.getHp());
        assertEquals(0,comp.getAtk());
        assertEquals(0,comp.getDef());
        assertEquals(4,comp.getPowerUp());

        MuscleMonkey comp1=new MuscleMonkey(-220,200,110);
        assertEquals(0,comp1.getMaxHp());
        assertEquals(0,comp1.getHp());
        assertEquals(200,comp1.getAtk());
        assertEquals(110,comp1.getDef());
        assertEquals(4,comp1.getPowerUp());

        MuscleMonkey comp2=new MuscleMonkey(100,-2000,-1012);
        assertEquals(100,comp2.getMaxHp());
        assertEquals(100,comp2.getHp());
        assertEquals(0,comp2.getAtk());
        assertEquals(0,comp2.getDef());
        assertEquals(4,comp2.getPowerUp());

        MuscleMonkey comp3=new MuscleMonkey(20,-2200,110);
        assertEquals(20,comp3.getMaxHp());
        assertEquals(20,comp3.getHp());
        assertEquals(0,comp3.getAtk());
        assertEquals(110,comp3.getDef());
        assertEquals(4,comp3.getPowerUp());
    }
    
    @Test
    public void testAttack() {
        MuscleMonkey comp=new MuscleMonkey(100,45,10);
        MuscleMonkey comp1=new MuscleMonkey(100,20,5);
        comp.attack(comp1);
        assertEquals(20,comp1.getHp());
        comp.attack(comp1);
        assertEquals(0,comp1.getHp());

        MuscleMonkey comp2=new MuscleMonkey(100,10,10);
        MuscleMonkey comp3=new MuscleMonkey(50,20,5);
        comp2.attack(comp3);
        assertEquals(40,comp3.getHp());
        comp2.attack(comp3);
        assertEquals(30,comp3.getHp());
        
        MuscleMonkey comp4=new MuscleMonkey(100,10,10);
        MuscleMonkey comp5=new MuscleMonkey(50,20,20);
        comp4.attack(comp5);
        assertEquals(50,comp5.getHp());
        comp4.attack(comp5);
        assertEquals(50,comp5.getHp());
        
        
    }

    @Test
    public void testBuff(){
        MuscleMonkey comp=new MuscleMonkey(100,45,10);
        comp.buff();
        assertEquals(49,comp.getAtk());
        assertEquals(14,comp.getDef());

        MuscleMonkey comp1=new MuscleMonkey(100,20,5);
        comp1.buff();comp1.buff();comp1.buff();
        assertEquals(32,comp1.getAtk());
        assertEquals(17,comp1.getDef());


    }
}
