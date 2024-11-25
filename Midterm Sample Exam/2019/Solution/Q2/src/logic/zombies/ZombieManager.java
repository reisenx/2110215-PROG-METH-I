package logic.zombies;

import logic.game.GameManager;

public class ZombieManager {
	
	public static Zombie randomZombie() {
		int health = GameManager.getRandomNumberInRange(10, 50);
		int power = GameManager.getRandomNumberInRange(10, 30);
		int defense = GameManager.getRandomNumberInRange(0, 10);
		return new Zombie(health, power, defense);
	}

}
