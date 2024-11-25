package logic.rocks;

import logic.game.GameManager;

public class RockManager {
	
	public static String randomRockType() {
		
		int rand = (int) GameManager.getRandomNumberInRange(0, 1);
		
		switch(rand) {
		case 0: return "Normal";
		case 1: return "Poison";
		default: return "Normal";
		}
	}
	
	public static NormalRock randomRock() {
		switch(randomRockType()) {
		case "Poison": return randomPoison();
		default: {
			int damage = GameManager.getRandomNumberInRange(10, 25);
			return new NormalRock(damage);
		}
		
		}
	}
	
	public static PoisonRock randomPoison() {
		int poison = GameManager.getRandomNumberInRange(1, 5);
		int damage = GameManager.getRandomNumberInRange(0, 10);
		return new PoisonRock(damage, poison);
	}
	
}
