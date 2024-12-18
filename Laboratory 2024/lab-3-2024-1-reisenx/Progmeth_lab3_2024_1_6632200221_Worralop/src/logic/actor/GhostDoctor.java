package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

public class GhostDoctor extends Actor {
	// Constructor Methods
	public GhostDoctor() {}
	
	// Methods
	@Override
	public void attack() {
		Ghost ghost = GameController.getInstance().getGhosts().get(0);
		int GhostHP = ghost.getHp();
		if(ghost instanceof LowGhost) {
			ghost.decreaseHp(GhostHP);
		}
	}
	public String toString() {
		return "GhostDoctor";
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.GhostDoctorLevel;
	}
}