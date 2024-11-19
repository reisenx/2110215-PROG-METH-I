package item.armor;
import item.base.BaseArmor;
import item.usage.Upgradable;

public class Suit extends BaseArmor implements Upgradable{
	// Class Properties
	private int level;
	private final int MAX_LEVEL = 3;
	private final int[] DEF = {1,2,3,5};
	
	// Constructor Methods
	public Suit() {
		super("Suit", 10);
		this.level = 0;
	}

	// Methods
	@Override
	public String toString() {
		return this.getName() + " (Def: " + this.getDef() + ", Level: " + this.getLevel() + ")";
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
	public int getDef() {
		return this.DEF[this.getLevel()];
	}
}
