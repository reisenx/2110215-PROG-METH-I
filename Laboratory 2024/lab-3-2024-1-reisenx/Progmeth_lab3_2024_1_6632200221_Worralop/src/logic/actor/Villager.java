package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Item;
import utils.Config;

public class Villager extends Actor {
	// Constructor Method
	public Villager() {}
	
	// Methods
	@Override
	public void attack() {
		boolean HaveAmulet = false;
		for(Item item : GameController.getInstance().getItems()) {
			if(item instanceof Amulet) {
				HaveAmulet = true;
				break;
			}
		}
		
		Ghost ghost = GameController.getInstance().getGhosts().get(0);
		if(ghost instanceof LowGhost) {
			if(HaveAmulet) {
				ghost.decreaseHp(this.getLevel() + 1);
			}
			else {
				ghost.decreaseHp(this.getLevel());
			}
		}
	}
	public String toString() {
		return "Villager";
	}
	
	// Getters
	@Override
	public int getLevel() {
		return Config.VillagerLevel;
	}
}