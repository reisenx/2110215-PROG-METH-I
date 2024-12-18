package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class MaBongGhost extends LowGhost{
	// Class Properties
	private int power, speed;
	
	// Constructor Method
	public MaBongGhost() {
		super();
		this.power = Config.MaBongGhostPower;
		this.setSpeed(Config.MaBongGhostSpeed);
	}
	public MaBongGhost(int power) {
		super();
		this.power = power;
		this.setSpeed(Config.MaBongGhostSpeed);
	}
	public MaBongGhost(int power, int speed) {
		super();
		this.power = power;
		this.setSpeed(speed);
	}
	
	// Methods
	public String toString() {
		return "MaBongGhost [HP: " + this.getHp() + " , Power: " + this.power + " , Speed: " + this.getSpeed() + "]";
	}
	@Override
	public void attack() {
		int PlayerHP = GameController.getInstance().getHp();
		GameController.getInstance().setHp(PlayerHP - (this.power * this.getSpeed()));
	}
	
	// Getters & Setters
	public int getSpeed() {
		return this.speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
