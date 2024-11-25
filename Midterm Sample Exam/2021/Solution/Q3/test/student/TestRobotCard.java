package test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.card.BaseCard;
import logic.card.RobotCard;
import logic.player.Player;

public class TestRobotCard {
	Player player;
	RobotCard robot1;
	RobotCard robot2;
	BaseCard robot3;

	@BeforeEach
	void setUp() {
		player = new Player();
		robot1 = new RobotCard("Roboco", 4, 5, 3);
		robot2 = new RobotCard("PO3", 2, 2, 0);
		robot3 = new RobotCard("Ruin Guard", 3, 5, 2);
	}

	@Test
	void testConstructorLegalValue() {
		assertEquals("Roboco", robot1.getName());
		assertEquals(4, robot1.getPower());
		assertEquals(5, robot1.getHealth());
		assertEquals(3, robot1.getEnergyCost());
		assertEquals(0, robot2.getEnergyCost());
	}

	@Test
	void testConstructorIllegalValue() {
		RobotCard negativeRobot = new RobotCard("Dark Robot", -1, -1, -1);
		assertEquals(0, negativeRobot.getHealth());
		assertEquals(0, negativeRobot.getPower());
		assertEquals(0, negativeRobot.getEnergyCost());
	}

	@Test
	void testSetEnergyCost() {
		robot1.setEnergyCost(5);
		assertEquals(5, robot1.getEnergyCost());
		robot1.setEnergyCost(-5);
		assertEquals(0, robot1.getEnergyCost());
	}

	@Test
	void testCanPlay() {
		assertEquals(false, robot1.canPlay(player));
		assertEquals(true, robot2.canPlay(player));
		player.setEnergy(3);
		assertEquals(true, robot1.canPlay(player));
		assertEquals(true, robot2.canPlay(player));
	}

	@Test
	void testPlay() {
		player.setEnergy(10);
		robot2.play(player);
		// RobotCard play() method do not place card
		assertEquals(null, player.getField().get(0));

		assertEquals(10, player.getEnergy());
		robot1.play(player);
		assertEquals(7, player.getEnergy());
		robot3.play(player);
		assertEquals(5, player.getEnergy());
	}

	@Test
	void testPlayNoEnergy() {
		player.setEnergy(2);
		// Should be able to play, No need to check if energy is enough when call this
		// method.
		robot1.play(player);
		assertEquals(0, player.getEnergy());
		robot3.play(player);
		assertEquals(0, player.getEnergy());
	}

	@Test
	void testAttackNoExcess() {
		assertEquals(0, robot1.attack(robot3));
		assertEquals(1, robot3.getHealth());
	}

	@Test
	void testAttackWithExcess() {
		assertEquals(2, robot1.attack(robot2));
		assertEquals(0, robot2.getHealth());
	}
}
