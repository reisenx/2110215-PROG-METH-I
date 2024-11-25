package test.grader;

import logic.game.GameSystem;
import monkey.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApeTest {

    @Test
    void testConstructor() {
        Ape test1 = new Ape(1, 3, 5);
        assertEquals(1, test1.getHp());
        assertEquals(1, test1.getMaxHp());
        assertEquals(3, test1.getAtk());
        assertEquals(5, test1.getDef());
    }

    @Test
    void testBadConstructor() {
        Ape test1 = new Ape(-1, -3 ,-5);
        assertEquals(0, test1.getHp());
        assertEquals(0, test1.getMaxHp());
        assertEquals(0, test1.getAtk());
        assertEquals(0, test1.getDef());
    }

    @Test
    void testAttack() {
        Ape attacker = new Ape(10,10,10);
        BaseMonkey  baseM = new BaseMonkey();
        MommyMonkey mommyM = new MommyMonkey(20, 10, 5);
        MuscleMonkey muscleM = new MuscleMonkey(20, 10, 5);
        UgabugagaMonkey ugabagagaM = new UgabugagaMonkey(20, 10, 5);

        attacker.attack(baseM);
        attacker.attack(mommyM);
        attacker.attack(muscleM);
        attacker.attack(ugabagagaM);

        assertEquals(30+5-10, baseM.getHp());
        assertEquals(20+5-10, mommyM.getHp());
        assertEquals(20+5-10, muscleM.getHp());
        assertEquals(20+5-10, ugabagagaM.getHp());

        attacker.setAtk(1000);
        attacker.attack(baseM);
        attacker.attack(mommyM);
        attacker.attack(muscleM);
        attacker.attack(ugabagagaM);

        assertEquals(0, baseM.getHp());
        assertEquals(0, mommyM.getHp());
        assertEquals(0, muscleM.getHp());
        assertEquals(0, ugabagagaM.getHp());


    }

    @Test
    void testAttackAOE() {
        ArrayList<BaseMonkey> monkeyContainer = GameSystem.getInstance().getMonkeyContainer();
        monkeyContainer.clear();
        Ape attacker = new Ape(10,10,10);

        BaseMonkey  baseM = new BaseMonkey();
        MommyMonkey mommyM = new MommyMonkey(20, 10, 5);
        MuscleMonkey muscleM = new MuscleMonkey(20, 10, 5);
        UgabugagaMonkey ugabagagaM = new UgabugagaMonkey(20, 10, 5);

        monkeyContainer.add(baseM);
        monkeyContainer.add(mommyM);
        monkeyContainer.add(muscleM);
        monkeyContainer.add(ugabagagaM);

        attacker.attackAOE();

        assertEquals(30+5-10, baseM.getHp());
        assertEquals(20+5-10, mommyM.getHp());
        assertEquals(20+5-10, muscleM.getHp());
        assertEquals(20+5-10, ugabagagaM.getHp());

    }
}
