package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import logic.rocks.*;
import logic.zombies.*;

public class PoisonRockTest {
	
	@Test
	void testConstructor() {
		PoisonRock rock = new PoisonRock(7, 3);
		assertEquals(7, rock.getDamage());
		assertEquals(3, rock.getDamageOverTime());
	}
	
	@Test
	void testConstructorZero() {
		PoisonRock rock = new PoisonRock(0, 2);
		assertEquals(0, rock.getDamage());
		assertEquals(2, rock.getDamageOverTime());
		
		PoisonRock rock2 = new PoisonRock(5, 0);
		assertEquals(5, rock2.getDamage());
		assertEquals(0, rock2.getDamageOverTime());
		
		PoisonRock rock3 = new PoisonRock(0, 0);
		assertEquals(0, rock3.getDamage());
		assertEquals(0, rock3.getDamageOverTime());
	}
	
	@Test
	void testConstructorNegative() {
		PoisonRock rock = new PoisonRock(-6, 4);
		assertEquals(0, rock.getDamage());
		assertEquals(4, rock.getDamageOverTime());
		
		PoisonRock rock2 = new PoisonRock(5, -7);
		assertEquals(5, rock2.getDamage());
		assertEquals(0, rock2.getDamageOverTime());
		
		PoisonRock rock3 = new PoisonRock(-6, -3);
		assertEquals(0, rock3.getDamage());
		assertEquals(0, rock3.getDamageOverTime());
	}
	
	@Test
	void testInheritance() {
		NormalRock rock = new PoisonRock(12, 5);
		assertEquals(12, rock.getDamage());
		
		PoisonRock ps = (PoisonRock) rock;
		assertEquals(5, ps.getDamageOverTime());
	}
	
	@Test
	void testSetDamage() {
		PoisonRock rock = new PoisonRock(8, 7);
		
		rock.setDamage(12);
		assertEquals(12, rock.getDamage());
	}
	
	@Test
	void testSetDamageZero() {
		PoisonRock rock = new PoisonRock(9, 3);
		
		rock.setDamage(0);
		assertEquals(0, rock.getDamage());
	}
	
	@Test
	void testSetDamageNegative() {
		PoisonRock rock = new PoisonRock(99, 3);
		
		rock.setDamage(-999);
		assertEquals(0, rock.getDamage());
	}
	
	@Test
	void testSetDamageOverTime() {
		PoisonRock rock = new PoisonRock(7, 4);
		
		rock.setDamageOverTime(3);
		assertEquals(3, rock.getDamageOverTime());
	}
	
	@Test
	void testSetDamageOverTimeZero() {
		PoisonRock rock = new PoisonRock(6, 5);
		
		rock.setDamageOverTime(0);
		assertEquals(0, rock.getDamageOverTime());
	}
	
	@Test
	void testSetDamageOverTimeNegative() {
		PoisonRock rock = new PoisonRock(24, 2);
		
		rock.setDamageOverTime(-67);
		assertEquals(0, rock.getDamageOverTime());
	}
	
	@Test
	void testDealDamage() {
		Zombie zombie = new Zombie(25, 4, 0);
		PoisonRock rock = new PoisonRock(8, 2);
		assertEquals(8, rock.dealDamage(zombie));
		assertEquals(17, zombie.getHealth());
		assertEquals(2, zombie.getDecay());
	}
	
	@Test
	void testDealDamageOnSomeDefense() {
		Zombie zombie = new Zombie(20, 3, 4);
		PoisonRock rock = new PoisonRock(10, 4);
		assertEquals(6, rock.dealDamage(zombie));
		assertEquals(14, zombie.getHealth());
		assertEquals(4, zombie.getDecay());
	}
	
	@Test
	void testDealDamageOnFullDefense() {
		Zombie zombie = new Zombie(15, 3, 6);
		PoisonRock rock = new PoisonRock(5, 1);
		assertEquals(0, rock.dealDamage(zombie));
		assertEquals(15, zombie.getHealth());
		assertEquals(1, zombie.getDecay());
	}
	
	@Test
	void testDealDamageOverkill() {
		Zombie zombie = new Zombie(3, 12, 0);
		PoisonRock rock = new PoisonRock(5, 1);
		assertEquals(5, rock.dealDamage(zombie));
		assertEquals(0, zombie.getHealth());
		assertEquals(1, zombie.getDecay());
	}
	
	@Test
	void testDecay() {
		Zombie zombie = new Zombie(100, 8, 4);
		PoisonRock rock = new PoisonRock(0, 4);
		rock.dealDamage(zombie);
		assertEquals(4, zombie.getDecay());
		
		zombie.decay();
		assertEquals(96, zombie.getHealth());
		
		zombie.decay();
		assertEquals(92, zombie.getHealth());
		
		zombie.decay();
		assertEquals(88, zombie.getHealth());
		
		zombie.decay();
		assertEquals(84, zombie.getHealth());
		
		zombie.decay();
		assertEquals(80, zombie.getHealth());
		
		PoisonRock rock2 = new PoisonRock(0, 2);
		rock2.dealDamage(zombie);
		assertEquals(6, zombie.getDecay());
		
		zombie.decay();
		assertEquals(74, zombie.getHealth());
		
		zombie.decay();
		assertEquals(68, zombie.getHealth());
	}
	
}
