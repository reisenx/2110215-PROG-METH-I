package test.grader;

import logic.game.GameSystem;
import monkey.BaseMonkey;
import monkey.UgabugagaMonkey;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UgabugagaMonkeyTest {
    @Test
    public void testConstructor() {
        UgabugagaMonkey comp=new UgabugagaMonkey(80,20,10);
        assertEquals(80,comp.getMaxHp());
        assertEquals(80,comp.getHp());
        assertEquals(20,comp.getAtk());
        assertEquals(10,comp.getDef());
        assertEquals(1, comp.getBebuff());
        assertEquals(10, comp.getHeal());
        

        UgabugagaMonkey comp1=new UgabugagaMonkey(100,20,110);
        assertEquals(100,comp1.getMaxHp());
        assertEquals(100,comp1.getHp());
        assertEquals(20,comp1.getAtk());
        assertEquals(110,comp1.getDef());
        assertEquals(1, comp1.getBebuff());
        assertEquals(10, comp1.getHeal());
        
        
    }
    @Test
    public void testBadConstructor() {
        UgabugagaMonkey comp=new UgabugagaMonkey(-100,-20,-10);
        assertEquals(0,comp.getMaxHp());
        assertEquals(0,comp.getHp());
        assertEquals(0,comp.getAtk());
        assertEquals(0,comp.getDef());
        assertEquals(1, comp.getBebuff());
        assertEquals(10, comp.getHeal());

        UgabugagaMonkey comp1=new UgabugagaMonkey(-220,200,110);
        assertEquals(0,comp1.getMaxHp());
        assertEquals(0,comp1.getHp());
        assertEquals(200,comp1.getAtk());
        assertEquals(110,comp1.getDef());
        assertEquals(1, comp1.getBebuff());
        assertEquals(10, comp1.getHeal());

        UgabugagaMonkey comp2=new UgabugagaMonkey(100,-2000,-1012);
        assertEquals(100,comp2.getMaxHp());
        assertEquals(100,comp2.getHp());
        assertEquals(0,comp2.getAtk());
        assertEquals(0,comp2.getDef());
        assertEquals(1, comp2.getBebuff());
        assertEquals(10, comp2.getHeal());

        UgabugagaMonkey comp3=new UgabugagaMonkey(20,-2200,110);
        assertEquals(20,comp3.getMaxHp());
        assertEquals(20,comp3.getHp());
        assertEquals(0,comp3.getAtk());
        assertEquals(110,comp3.getDef());
        assertEquals(1, comp3.getBebuff());
        assertEquals(10, comp3.getHeal());
    }
    @Test
    public void testAttack() {
        UgabugagaMonkey comp=new UgabugagaMonkey(100,30,10);
        UgabugagaMonkey comp1=new UgabugagaMonkey(100,20,5);
        comp.attack(comp1);
        assertEquals(75,comp1.getHp());
        assertEquals(19,comp1.getAtk());
        assertEquals(4,comp1.getDef());

        UgabugagaMonkey comp2=new UgabugagaMonkey(100,10,10);
        UgabugagaMonkey comp3=new UgabugagaMonkey(100,3,5);
        for(int i = 0;i<4;i++) comp2.attack(comp3);
        assertEquals(74,comp3.getHp());
        assertEquals(0,comp3.getAtk());
        assertEquals(1,comp3.getDef());
    }

    @Test
    public void testHeal(){
        UgabugagaMonkey comp=new UgabugagaMonkey(100,45,10);
        BaseMonkey comp1 = new BaseMonkey(100,0,0);
        comp1.setHp(50);
        comp.heal(comp1);

        assertEquals(60,comp1.getHp());
        for (int i = 0; i<7;i++) comp.heal(comp1);
        assertEquals(100,comp1.getHp());


    }
}
