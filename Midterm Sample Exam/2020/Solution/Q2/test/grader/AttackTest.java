package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.attack.Attack;
import logic.monster.Monster;

class AttackTest {
	Attack a;
	
	@BeforeEach
	void setUp(){
		a = new Attack(7,"Fire Punch",false);
	}

	@Test
	void testCalculateDamage() {
		Monster target = new Monster("Raichu",12,1,3,null);
		assertEquals(6,a.calculateDamage(target));
	}
	
	@Test
	void testCalculateDamageZero() {
		Monster target = new Monster("Raichu",12,7,1,null);
		assertEquals(0,a.calculateDamage(target));
	}
	
	@Test
	void testCalculateDamageNegative() {
		Monster target = new Monster("Raichu",12,8,1,null);
		assertEquals(0,a.calculateDamage(target));
	}

}
