package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class GaGhost extends LowGhost{
	// Class Properties
	private int energy;
	
	// Constructor Methods
	public GaGhost() {
		super();
		this.energy = Config.GaGhostEnergy;
	}
	public GaGhost(int energy) {
		super();
		this.energy = energy;
	}
	
	// Methods
	public String toString() {
		return "GaGhost [HP: " + this.getHp() + " , Energy: " + this.energy + "]";
	}
	@Override
	public void attack() {
		int PlayerHP = GameController.getInstance().getHp();
		GameController.getInstance().setHp(PlayerHP - this.energy);
	}
	
}
