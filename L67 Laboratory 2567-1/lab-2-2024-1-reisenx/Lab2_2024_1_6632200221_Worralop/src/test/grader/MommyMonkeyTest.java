package test.grader;

import logic.game.GameSystem;
import monkey.BaseMonkey;
import monkey.MommyMonkey;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MommyMonkeyTest {

	@Test
	public void testConstructor() {
		MommyMonkey comp = new MommyMonkey(80, 0, 10);
		assertEquals(80, comp.getMaxHp());
		assertEquals(80, comp.getHp());
		assertEquals(0, comp.getAtk());
		assertEquals(10, comp.getDef());

		MommyMonkey comp1 = new MommyMonkey(40, 20, 110);
		assertEquals(40, comp1.getMaxHp());
		assertEquals(40, comp1.getHp());
		assertEquals(20, comp1.getAtk());
		assertEquals(110, comp1.getDef());
	}

	@Test
	public void testBadConstructor() {
		MommyMonkey comp = new MommyMonkey(-100, -20, -10);
		assertEquals(0, comp.getMaxHp());
		assertEquals(0, comp.getHp());
		assertEquals(0, comp.getAtk());
		assertEquals(0, comp.getDef());

		MommyMonkey comp1 = new MommyMonkey(-220, 200, 110);
		assertEquals(0, comp1.getMaxHp());
		assertEquals(0, comp1.getHp());
		assertEquals(200, comp1.getAtk());
		assertEquals(110, comp1.getDef());

		MommyMonkey comp2 = new MommyMonkey(100, -2000, -1012);
		assertEquals(100, comp2.getMaxHp());
		assertEquals(100, comp2.getHp());
		assertEquals(0, comp2.getAtk());
		assertEquals(0, comp2.getDef());

		MommyMonkey comp3 = new MommyMonkey(20, -2200, 110);
		assertEquals(20, comp3.getMaxHp());
		assertEquals(20, comp3.getHp());
		assertEquals(0, comp3.getAtk());
		assertEquals(110, comp3.getDef());
	}

	@Test
	public void testAttack() {
		MommyMonkey comp = new MommyMonkey(100, 45, 10);
		MommyMonkey comp1 = new MommyMonkey(100, 20, 5);
		comp.attack(comp1);
		assertEquals(100, comp1.getHp());
		comp.attack(comp1);
		assertEquals(100, comp1.getHp());
	}

	@Test
	public void testBirth() {
		MommyMonkey comp = new MommyMonkey(100, 45, 10);
		GameSystem.getInstance().getMonkeyContainer().add(comp);
		comp.birth();
		assertEquals(2, GameSystem.getInstance().getMonkeyContainer().size());
		BaseMonkey k = GameSystem.getInstance().getMonkeyContainer().get(1);
		assertEquals("BaseMonkey",k.getClass().getSimpleName());
		
		for (int i = 0; i < 3; i++) {
			comp.birth();
			k = GameSystem.getInstance().getMonkeyContainer().get(i+2);
			assertEquals("BaseMonkey",k.getClass().getSimpleName());
		}
		assertEquals(5, GameSystem.getInstance().getMonkeyContainer().size());

		

	}
}
