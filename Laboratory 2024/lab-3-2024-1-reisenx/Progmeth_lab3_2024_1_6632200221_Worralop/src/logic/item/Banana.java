package logic.item;

import logic.game.GameController;
import logic.ghost.Ghost;
import utils.Config;

public class Banana extends Item{
	// Constructor Methods
	public Banana() {}
	
	// Methods
	@Override
	public void effect() {
		for(Ghost ghost : GameController.getInstance().getGhosts()) {
			System.out.print(ghost + " ");
		}
		System.out.print("\n");
	}
	public String toString() {
		return "Banana";
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.BananaLevel;
	}
}
