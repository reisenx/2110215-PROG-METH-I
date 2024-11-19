package item.weapon;
import item.base.BaseWeapon;
import item.usage.Upgradable;

public class Sword extends BaseWeapon implements Upgradable {
	// Class Properties
	private int level;
	private final int MAX_LEVEL = 3;
	private final int[] ATT = {3,5,8,12};
	
	// Constructor Method
	public Sword() {
		super("Sword", 15, 1);
		this.level = 0;
	}
	
	// Methods
	public String toString() {
		return this.getName() + " (Att: " + this.getAtt() + ", Range: " + this.getRange() + ", Level: " + this.getLevel() + ", " + this.getDurability() + " uses left)";
	}

	// Getters & Setters
	@Override
	public int getLevel() {
		return this.level;
	}
	@Override
	public void setLevel(int level) {
		if(level < 0 || level > MAX_LEVEL) this.level = 0;
		else this.level = level;
	}
	
	@Override
	public int getMaxLevel() {
		return this.MAX_LEVEL;
	}
	
	@Override
	public int getAtt() {
		return ATT[this.getLevel()];
	}
}
