package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PongGhost extends HighGhost{
	// Class Properties
	private int power;
	
	// Constructor Methods
	public PongGhost() {
		super();
		this.power = Config.PongGhostPower;
	}
	public PongGhost(int power) {
		super();
		this.power = power;
	}
	
	// Methods
	public String toString() {
		return "PongGhost [HP: " + this.getHp() + " , Power: " + this.power + "]";
	}
	@Override
	public void attack() {
		int PlayerHP = GameController.getInstance().getHp();
		GameController.getInstance().setHp(PlayerHP - this.power);
	}
	@Override
	public void damage() {
		for(Ghost ghost : GameController.getInstance().getGhosts()) {
			if(ghost instanceof LowGhost) {
				ghost.decreaseHp(-1 * this.power);
			}
		}
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.PongGhostLevel;
	}
}
