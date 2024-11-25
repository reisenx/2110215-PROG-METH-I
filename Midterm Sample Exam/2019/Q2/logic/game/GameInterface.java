package logic.game;

import logic.zombies.*;
import java.util.Scanner;

public class GameInterface {
	
	static int startingHealth = 500;
	
	public static void main(String[] args) {
		System.out.println("---Terry VS Zombies---");
		Player player = new Player(startingHealth);
		GameManager.initializeManager(player);
		Scanner sc = new Scanner(System.in);
		int killCount = 0;
		System.out.println("Kill as many zombies as possible!");
		System.out.println("Each wave has 3 zombies.");
		System.out.println("For each wave you clear, recover some health!");
		System.out.println("Choose your target wisely!");
		System.out.println("-ZOMBIES-");
		System.out.println("Bucket Zombies ignore Decay.");
		System.out.println("Decay Zombies deal high damage but spawn with Decay.");
		System.out.println("Healers Zombies heal a random zombie instead of attacking.");
		System.out.println("-ROCKS-");
		System.out.println("Pierce ignores Defense.");
		System.out.println("Poison deals Decay. Decay deals damage when zombies take their turn.");
		System.out.println("Crit has chance to deal x3 damage.");
		System.out.println("Good luck!");
		System.out.println("");
		System.out.println("----------------");
		System.out.println("---GAME START---");
		System.out.println("----------------");
		
		while(player.getHealth() > 0) {
			
			if(GameManager.allZombiesDead()) {
				System.out.println("---!!!CONGRATULATIONS!!!---");
				System.out.println("Wave cleared!");
				int recover = (int)(player.getMaxHealth() * 0.1);
				player.setHealth(player.getHealth() + recover);
				System.out.println("You recovered " + recover + " HP!");
				System.out.println("A new wave of zombies appear!");
				System.out.println("---GET READY!---");
				GameManager.randomizeAllZombies();
			}
			
			System.out.println("---YOUR TURN---");
			System.out.println(GameManager.player);
			System.out.println("Current: " + GameManager.currentRock);
			System.out.println("Next: " + GameManager.nextRock);
			GameManager.printAllZombies();
			System.out.println("Choose your target: ");
			while(true) {
				try {
					String choice = sc.nextLine();
					int choiceNumber = Integer.parseInt(choice) - 1;
					if(choiceNumber < 0 || choiceNumber > 2) {
						System.out.println("Out of range! Please input again.");
						continue;
					}
					if(GameManager.zombies.get(choiceNumber).getHealth() <= 0) {
						System.out.println("That zombie is already dead! Please input again.");
						continue;
					}
					int damage = GameManager.attackZombie(GameManager.zombies.get(choiceNumber));
					System.out.println("Dealt " + damage + " damage!");
					if (GameManager.zombies.get(choiceNumber).getHealth() <= 0) {
						System.out.println("Zombie No. " + (choiceNumber+1) + " is defeated!");
						killCount++;
					}
					
					if(!GameManager.allZombiesDead()) {
						System.out.println("---ZOMBIE TURN---");
						int zombieNo = 1;
						for(Zombie z : GameManager.zombies) {
							if(z.getHealth() > 0) {
								int zombieDamage = GameManager.takeTurn(z);
								if(zombieDamage == -1) {
									System.out.println("Zombie No. " + zombieNo + " tries to attack, but has already decayed!");
									killCount++;
								}else {
									System.out.println("Zombie No. " + zombieNo + " deals " + zombieDamage + " damage!");
								}
							}
							zombieNo++;
						}
					}
				break;
				}catch(Exception e) {
					System.out.println("Not a number! Please input again.");
				}
			}
		}
		
		System.out.println("You were slain...");
		System.out.println("Final score: " + killCount);
	}

}
