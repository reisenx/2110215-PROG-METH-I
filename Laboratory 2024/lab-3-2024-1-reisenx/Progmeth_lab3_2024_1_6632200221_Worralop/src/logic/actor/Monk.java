package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import utils.Config;

public class Monk extends Actor {
	// Constructor Methods
	public Monk () {}
	
	// Methods
	@Override
	public void attack() {
		Ghost ghost = GameController.getInstance().getGhosts().get(0);
		if(ghost instanceof HighGhost) {
			ghost.decreaseHp(this.getLevel());
		}
	}
	public String toString() {
		return "Monk";
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.MonkLevel;
	}
}