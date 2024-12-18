package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

public class Monkey extends Actor {
	// Constructor Method
	public Monkey() {}
	
	// Methods
	@Override
	public void attack() {
		boolean HaveBanana = false;
		for(Item item : GameController.getInstance().getItems()) {
			if(item instanceof Banana) {
				HaveBanana = true;
				break;
			}
		}
		
		Ghost ghost = GameController.getInstance().getGhosts().get(0);
		int GhostHP = ghost.getHp();
		if(ghost instanceof LowGhost) {
			if(HaveBanana) {
				ghost.decreaseHp(GhostHP);
			}
			else {
				ghost.decreaseHp(this.getLevel());
			}
		}
	}
	public String toString() {
		return "Monkey";
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.MonkeyLevel;
	}
}