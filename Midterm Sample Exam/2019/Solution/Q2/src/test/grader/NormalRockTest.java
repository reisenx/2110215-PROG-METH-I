package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import logic.rocks.*;
import logic.zombies.*;

public class NormalRockTest {
	
	@Test
	void testConstructor() {
		NormalRock rock = new NormalRock(20);
		assertEquals(20, rock.getDamage());
	}
	
	@Test
	void testConstructorZero() {
		NormalRock rock = new NormalRock(0);
		assertEquals(0, rock.getDamage());
	}
	
	@Test
	void testConstructorNegative() {
		NormalRock rock = new NormalRock(-44);
		assertEquals(0, rock.getDamage());
	}
	
	@Test
	void testSetDamage() {
		NormalRock rock = new NormalRock(56);
		
		rock.setDamage(8);
		assertEquals(8, rock.getDamage());
	}
	
	@Test
	void testSetDamageZero() {
		NormalRock rock = new NormalRock(22);
		
		rock.setDamage(0);
		assertEquals(0, rock.getDamage());
	}
	
	@Test
	void testSetDamageNegative() {
		NormalRock rock = new NormalRock(75);
		
		rock.setDamage(-100);
		assertEquals(0, rock.getDamage());
	}
	
	@Test
	void testDealDamage() {
		Zombie zombie = new Zombie(20, 4, 0);
		NormalRock rock = new NormalRock(15);
		assertEquals(15, rock.dealDamage(zombie));
		assertEquals(5, zombie.getHealth());
		assertEquals(0, zombie.getDecay());
	}
	
	@Test
	void testDealDamageOnSomeDefense() {
		Zombie zombie = new Zombie(30, 6, 7);
		NormalRock rock = new NormalRock(10);
		assertEquals(3, rock.dealDamage(zombie));
		assertEquals(27, zombie.getHealth());
		assertEquals(0, zombie.getDecay());
	}
	
	@Test
	void testDealDamageOnFullDefense() {
		Zombie zombie = new Zombie(50, 12, 10);
		NormalRock rock = new NormalRock(5);
		assertEquals(0, rock.dealDamage(zombie));
		assertEquals(50, zombie.getHealth());
		assertEquals(0, zombie.getDecay());
	}
	
	@Test
	void testDealDamageOverkill() {
		Zombie zombie = new Zombie(5, 11, 0);
		NormalRock rock = new NormalRock(28);
		assertEquals(28, rock.dealDamage(zombie));
		assertEquals(0, zombie.getHealth());
		assertEquals(0, zombie.getDecay());
	}
}
