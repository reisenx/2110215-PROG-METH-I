package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.attack.Attack;
import logic.attack.SPAttack;
import logic.monster.Monster;

class SPAttackTest {
	SPAttack a;
	
	@BeforeEach
	void setUp(){
		a = new SPAttack(7,"Flamethrower",false);
	}

	@Test
	void testConstructor() {
		assertEquals(7,a.getPower());
		assertEquals("Flamethrower",a.getName());
		assertEquals(false,a.isLeader());
	}
	
	@Test
	void testCalculateDamage() {
		Monster target = new Monster("Raichu",20,5,4,null);
		assertEquals(3,a.calculateDamage(target));
	}
	
	@Test
	void testCalculateDamageZero() {
		Monster target = new Monster("Pikachu",20,2,7,null);
		assertEquals(0,a.calculateDamage(target));
	}
	
	@Test
	void testCalculateDamageNegative() {
		Monster target = new Monster("Pikachu",20,2,8,null);
		assertEquals(0,a.calculateDamage(target));
	}
	
	@Test
	void testInheritance() {
		Attack a2 = new SPAttack(7,"Flamethrower",false);
		assertEquals(7,a2.getPower());
		
		SPAttack a3 = (SPAttack) a2;
		assertEquals(7,a3.getPower());
	}

	

}
