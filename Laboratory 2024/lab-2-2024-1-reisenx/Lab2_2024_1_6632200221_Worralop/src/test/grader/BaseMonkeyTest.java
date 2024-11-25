package test.grader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import monkey.BaseMonkey;
import monkey.MommyMonkey;
import monkey.MuscleMonkey;
import monkey.UgabugagaMonkey;
import org.junit.jupiter.api.Test;

//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;



public class BaseMonkeyTest {
    @Test
    public void testConstructor() {
        BaseMonkey comp=new BaseMonkey(100,20,10);
        assertEquals(100,comp.getMaxHp());
        assertEquals(100,comp.getHp());
        assertEquals(20,comp.getAtk());
        assertEquals(10,comp.getDef());

        BaseMonkey comp1=new BaseMonkey(20,200,110);
        assertEquals(20,comp1.getMaxHp());
        assertEquals(20,comp1.getHp());
        assertEquals(200,comp1.getAtk());
        assertEquals(110,comp1.getDef());
    }
    @Test
    public void testBadConstructor() {
        BaseMonkey comp=new BaseMonkey(-10,-20,-10);
        assertEquals(0,comp.getMaxHp());
        assertEquals(0,comp.getHp());
        assertEquals(0,comp.getAtk());
        assertEquals(0,comp.getDef());

        BaseMonkey comp1=new BaseMonkey(-20,200,110);
        assertEquals(0,comp1.getMaxHp());
        assertEquals(0,comp1.getHp());
        assertEquals(200,comp1.getAtk());
        assertEquals(110,comp1.getDef());

        BaseMonkey comp2=new BaseMonkey(100,-20,-10);
        assertEquals(100,comp2.getMaxHp());
        assertEquals(100,comp2.getHp());
        assertEquals(0,comp2.getAtk());
        assertEquals(0,comp2.getDef());

        BaseMonkey comp3=new BaseMonkey(20,-200,110);
        assertEquals(20,comp3.getMaxHp());
        assertEquals(20,comp3.getHp());
        assertEquals(0,comp3.getAtk());
        assertEquals(110,comp3.getDef());
    }
    @Test
    public void testAttack() {
        BaseMonkey comp=new BaseMonkey(100,30,10);
        BaseMonkey comp1=new BaseMonkey(50,20,5);
        comp.attack(comp1);
        assertEquals(25,comp1.getHp());
        comp.attack(comp1);
        assertEquals(0,comp1.getHp());

        BaseMonkey comp2=new BaseMonkey(100,20,10);
        BaseMonkey comp3=new BaseMonkey(50,20,5);
        comp2.attack(comp3);
        assertEquals(35,comp3.getHp());
        comp2.attack(comp3);
        assertEquals(20,comp3.getHp());
    }
    @Test
    public void testGetType() {
        BaseMonkey comp=new BaseMonkey(100,30,10);
        assertEquals("BaseMonkey",comp.getType());
        MuscleMonkey comp1=new MuscleMonkey(100,30,10);
        assertEquals("MuscleMonkey",comp1.getType());
        MommyMonkey comp2=new MommyMonkey(100,30,10);
        assertEquals("MommyMonkey",comp2.getType());
        UgabugagaMonkey comp3=new UgabugagaMonkey(100,30,10);
        assertEquals("UgabugagaMonkey",comp3.getType());
    }

    @Test
    public void testSetHp() {
        BaseMonkey comp=new BaseMonkey(100,30,10);
        comp.setHp(50);
        assertEquals(50,comp.getHp());
        comp.setHp(-4);
        assertEquals(0,comp.getHp());
    }
    @Test
    public void testSetPower() {
        BaseMonkey comp=new BaseMonkey(100,30,10);
        comp.setAtk(50);
        assertEquals(50,comp.getAtk());
        comp.setAtk(-4);
        assertEquals(0,comp.getAtk());
    }
}