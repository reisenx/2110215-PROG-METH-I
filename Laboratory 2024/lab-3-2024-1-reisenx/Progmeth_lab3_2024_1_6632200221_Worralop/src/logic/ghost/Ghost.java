package logic.ghost;

public abstract class Ghost {
	// Class Properties
	private int hp;
	
	// Constructor Method
	public Ghost (int hp) {
		this.hp = hp;
	}
	
	// Methods
	public boolean isDestroyed() {
		return this.getHp() <= 0;
	}
	public void decreaseHp(int amount) {
		if(this.getHp() - amount < 0) this.hp = 0;
		else this.hp -= amount;
	}
	public abstract void attack();
	
	// Getters
	public abstract int getLevel();
	public int getHp() {
		return this.hp;
	}
}