package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PooYaGhost extends HighGhost{
	// Class Properties
	private int power;
	
	// Constructor Method
	public PooYaGhost(int power) {
		super();
		this.power = power;
	}
	
	// Methods
	public String toString() {
		return "PooYaGhost [HP: " + this.getHp() + " , Power: " + this.power + "]";
	}
	@Override
	public void attack() {
		int PlayerHP = GameController.getInstance().getHp();
		int PlayerScore = GameController.getInstance().getScore();
		GameController.getInstance().setHp(PlayerHP - this.power);
		GameController.getInstance().setScore(PlayerScore - this.power);
	}
	@Override
	public void damage() {
		for(Ghost ghost : GameController.getInstance().getGhosts()) {
			ghost.decreaseHp(-1 * this.power);
		}
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.PooYaGhostLevel;
	}
}
