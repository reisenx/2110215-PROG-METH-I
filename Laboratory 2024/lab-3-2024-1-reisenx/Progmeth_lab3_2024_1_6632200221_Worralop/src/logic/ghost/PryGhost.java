package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PryGhost extends LowGhost{
	// Class Properties
	private int power;
	private int ppt;
	
	// Constructor Method
	public PryGhost() {
		super();
		this.power = Config.PryGhostPower;
		this.setPpt(0);
	}
	public PryGhost(int power) {
		super();
		this.power = power;
		this.setPpt(0);
	}
	public PryGhost(int power, int ppt) {
		super();
		this.power = power;
		this.setPpt(ppt);
	}
	
	// Methods
	public String toString() {
		return "PryGhost [HP: " + this.getHp() + " , Power: " + this.power + " , PPT: " + this.getPpt() + "]";
	}
	@Override
	public void attack() {
		int PlayerHP = GameController.getInstance().getHp();
		GameController.getInstance().setHp(PlayerHP - (this.power - this.getPpt()));
	}
	
	// Getters & Setter
	public int getPpt() {
		return this.ppt;
	}
	public void setPpt(int ppt) {
		this.ppt = ppt;
	}
}
