package logic.game;

public class Player {
	private int health;
	private int maxHealth;
	
	public Player(int maxHealth) {
		setMaxHealth(maxHealth);
		setHealth(maxHealth);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health <= 0) health = 0;
		if (health >= getMaxHealth()) health = getMaxHealth();
		this.health = health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		if (maxHealth <= 0) maxHealth = 0;
		this.maxHealth = maxHealth;
	}
	
	public String toString(){
		return "Terry: " + getHealth() + "/" + getMaxHealth();
	}
}
