package item.consumption;
import item.base.BaseConsumption;
import item.usage.*;


public class HealingPotion extends BaseConsumption implements Healable {
	// Class Properties
	private int level;
	private final int MAX_LEVEL = 3;
	private final int[] RECOVER_PT = {3,5,7,10};
	
	// Constructor Method
	public HealingPotion() {
		super("HealingPotion");
		this.level = 0;
	}
	
	// Methods
	@Override
	public String toString() {
		return this.getName() + " (+" + this.getRecoverPoint() + " HP, Level: " + this.getLevel() + ")";
	}
	
	// Getters & Setters
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int level) {
		if(level < 0 || level > MAX_LEVEL) this.level = 0;
		else this.level = level;
	}

	public int getMaxLevel() {
		return this.MAX_LEVEL;
	}
	
	@Override
	public int getRecoverPoint() {
		return RECOVER_PT[this.getLevel()];
	}
}
