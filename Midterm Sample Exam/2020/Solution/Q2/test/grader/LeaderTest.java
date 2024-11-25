package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.attack.Attack;
import logic.attack.SPAttack;
import logic.monster.Leader;
import logic.monster.Monster;

class LeaderTest {
	Leader l;
	Attack a;
	
	@BeforeEach
	void setUp(){
		l = new Leader("Zekrom",20,2,6,new Attack(10,"Fusion Bolt",true),2);
	}
	
	@Test
	void testConstructor() {
		assertEquals("Zekrom",l.getName());
		assertEquals(20,l.getHp());
		assertEquals(20,l.getMaxhp());
		assertEquals(2,l.getDefense());
		assertEquals(6,l.getSpecialDefense());
		
		assertEquals(false,l.isGuard());
		assertEquals(2,l.getMaxChargeTurns());
		assertEquals(0,l.getCurrentChargeTurns());
	}

	@Test
	void testInheritance() {
		Monster m = new Leader("Zekrom",20,2,6,new Attack(10,"Fusion Bolt",true),2);
		assertEquals(20,m.getHp());
		
		Leader l2 = (Leader) m;
		assertEquals(2,l2.getMaxChargeTurns());
	}
	
	@Test
	void testSetGuard() {
		l.setGuard(true);
		assertEquals(true,l.isGuard());
	}

	@Test
	void testSetMaxChargeTurns() {
		l.setMaxChargeTurns(5);
		assertEquals(5,l.getMaxChargeTurns());
	}

	@Test
	void testSetCurrentChargeTurns() {
		l.setCurrentChargeTurns(1);
		assertEquals(1,l.getCurrentChargeTurns());
	}
	
	@Test
	void testSetCurrentChargeTurns_Negative() {
		l.setCurrentChargeTurns(-5);
		assertEquals(0,l.getCurrentChargeTurns());
	}
	
	@Test
	void testSetCurrentChargeTurns_Max() {
		l.setCurrentChargeTurns(6);
		assertEquals(2,l.getCurrentChargeTurns());
	}
	
	@Test
	void testTakeDamage() {
		Attack opponent = new Attack(10,"Fusion Flare",true);
		l.takeDamage(opponent);
		
		assertEquals(12,l.getHp());
		assertEquals(false,l.isDead());
	}
	
	@Test
	void testTakeDamage_SP() {
		SPAttack opponent = new SPAttack(10,"Fusion Flare",true);
		l.takeDamage(opponent);
		
		assertEquals(16,l.getHp());
		assertEquals(false,l.isDead());
	}
	
	@Test
	void testTakeDamage_Reduced() {
		Attack opponent = new Attack(10,"Fusion Flare",false);
		l.takeDamage(opponent);
		
		assertEquals(16,l.getHp());
		assertEquals(false,l.isDead());
	}
	
	@Test
	void testTakeDamage_Guard() {
		Attack opponent = new Attack(10,"Fusion Flare",true);
		l.setGuard(true);
		l.takeDamage(opponent);
		
		assertEquals(20,l.getHp());
		assertEquals(false,l.isDead());
	}
	
	
	@Test
	void testTakeDamageDead() {
		Attack opponent = new Attack(30,"Fusion Flare",true);
		l.takeDamage(opponent);
		
		assertEquals(0,l.getHp());
		assertEquals(true,l.isDead());
	}
	
	

}
