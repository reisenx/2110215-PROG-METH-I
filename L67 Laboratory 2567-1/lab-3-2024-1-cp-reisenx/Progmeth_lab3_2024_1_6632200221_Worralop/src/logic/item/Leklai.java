package logic.item;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import utils.Config;

public class Leklai extends Item{
	// Constructor Methods
	public Leklai() {}
	
	// Methods
	@Override
	public void effect() {
		for(Ghost ghost : GameController.getInstance().getGhosts()) {
			if(ghost.getLevel() <= this.getLevel()) {
				if(ghost instanceof LowGhost) {
					ghost.decreaseHp(5);
				}
				else if(ghost instanceof HighGhost) {
					ghost.decreaseHp(4);
				}
			}
		}
	}
	public String toString() {
		return "Leklai";
	}
	
	// Getter
	@Override
	public int getLevel() {
		return Config.LeklaiLevel;
	}

}
