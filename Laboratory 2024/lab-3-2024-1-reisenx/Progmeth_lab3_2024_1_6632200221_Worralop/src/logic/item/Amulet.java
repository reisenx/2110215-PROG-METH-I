package logic.item;

import logic.game.GameController;
import utils.Config;

public class Amulet extends Item{
	// Constructor Methods
	public Amulet() {}
	
	// Methods
	@Override
	public void effect() {
		int PlayerHP = GameController.getInstance().getHp();
		GameController.getInstance().setHp(Math.max(PlayerHP, 5));
	}
	public String toString() {
		return "Amulet";
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.AmuletLevel;
	}

}
