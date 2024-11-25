package logic.zombies;

import logic.game.GameManager;
import logic.game.Player;

public class Zombie {
	int health;
	int maxHealth;
	int power;
	int defense;
	int decay;
	
	public Zombie(int maxHealth, int power, int defense) {
		setMaxHealth(maxHealth);
		setHealth(maxHealth);
		setPower(power);
		setDefense(defense);
		setDecay(0);
	}
	
	public void setMaxHealth(int maxHealth) {
		if (maxHealth <= 0) maxHealth = 0;
		this.maxHealth = maxHealth;
	}
	
	public int getMaxHealth() {
		return this.maxHealth;
	}
	
	public void setHealth(int health) {
		if (health <= 0) {
			health = 0;
		}else if (health >= this.getMaxHealth()) {
			health = this.getMaxHealth();
		}
		
		this.health = health;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setDecay(int decay) {
		if (decay <= 0) decay = 0;
		this.decay = decay;
	}
	
	public int getDecay() {
		return this.decay;
	}
	
	public void setDefense(int defense) {
		if (defense <= 0) defense = 0;
		this.defense = defense;
	}
	
	public int getDefense() {
		return this.defense;
	}
	
	public void setPower(int power) {
		if (power <= 0) power = 0;
		this.power = power;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int dealDamage(Player player) {
		player.setHealth(player.getHealth() - this.getPower());
		return getPower();
	}
	
	public int doAction() {
		return dealDamage(GameManager.player);
	}
	
	public void decay() {
		setHealth(getHealth() - getDecay());
	}
	
	public String toString() {
		return "Zombie: " + getHealth() + "/" + getMaxHealth() + " HP, " + getPower() + " POW, " + getDefense() + " DEF, " + getDecay() + " Decay"; 
	}
	
}
