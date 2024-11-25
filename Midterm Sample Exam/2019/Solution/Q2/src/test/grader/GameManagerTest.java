package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import logic.game.*;
import logic.rocks.*;
import logic.zombies.*;

public class GameManagerTest {

	@Test
	void testAttackZombie() {
		Player terry = new Player(250);
		GameManager.initializeManager(terry);

		NormalRock rockA = new NormalRock(25);
		NormalRock rockB = new NormalRock(13);

		GameManager.currentRock = rockA;
		GameManager.nextRock = rockB;

		Zombie zombie = new Zombie(200, 10, 2);

		assertEquals(11, GameManager.attackZombie(zombie));
		assertEquals(189, zombie.getHealth());
		assertEquals(rockB, GameManager.currentRock);
	}

}
