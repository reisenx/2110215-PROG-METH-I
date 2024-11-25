package logic.game;

import java.util.ArrayList;
import logic.zombies.*;
import logic.rocks.*;

public class GameManager {
	
	public static Player player;
	public static ArrayList<Zombie> zombies;
	public static NormalRock currentRock;
	public static NormalRock nextRock;
	
	public static void initializeManager(Player p) {
		player = p;
		zombies = new ArrayList<>();
		currentRock = RockManager.randomRock();
		nextRock = RockManager.randomRock();
		randomizeAllZombies();
	}

	public static int attackZombie(Zombie zombie) {
		//TODO: deal damage with current rock to the given zombie
		currentRock=nextRock;
		nextRock=RockManager.randomRock();
		return currentRock.dealDamage(zombie);
	}
	
	public static int takeTurn(Zombie zombie) {
		zombie.decay();
		if(zombie.getHealth() <= 0) {
			return -1;
		}
		
		return zombie.doAction();
	}
	
	public static Zombie getRandomLivingZombie() {
		ArrayList<Zombie> livingZombies = new ArrayList<>();
		
		for(Zombie z : zombies) {
			if (z.getHealth() > 0) livingZombies.add(z);
		}
		int chooseLivingZombie = getRandomNumberInRange(0, livingZombies.size() - 1);
		return livingZombies.get(chooseLivingZombie);
	}
	
	public static void randomizeAllZombies() {
		zombies.clear();
		for(int i = 0; i < 3; i++) {
			zombies.add(ZombieManager.randomZombie());
		}
	}
	
	public static boolean allZombiesDead() {
		boolean allDead = true;
		for(Zombie z : zombies) {
			if(z.getHealth() > 0) allDead = false;
		}
		return allDead;
	}
	
	public static void printAllZombies() {
		int i = 1;
		for(Zombie z : zombies) {
			System.out.println(i + ") " + z);
			i++;
		}
	}
	
	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) throw new IllegalArgumentException("max must be greater than min!");
		
		return (int) (Math.random() * ((max - min) + 1) + min);
	}
}
