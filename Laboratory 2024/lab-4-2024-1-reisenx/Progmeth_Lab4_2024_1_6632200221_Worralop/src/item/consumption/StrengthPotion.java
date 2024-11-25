package item.consumption;
import item.base.BaseConsumption;
import item.usage.*;

public class StrengthPotion extends BaseConsumption implements AttBuffable {
	// Class Properties
	private int level;
	private final int MAX_LEVEL = 3;
	private final int[] ATT_BUFF = {3,5,7,10};
	private final int BUFF_TURN = 3;
	
	// Constructor Methods
	public StrengthPotion() {
		super("StrengthPotion");
		this.level = 0;
	}
	
	// Methods
	public String toString() {
		return this.getName() + " (+" + this.getAttBuff() + " Att for next " + this.getBuffTurn() + " turns, Level: " + this.getLevel() + ")";
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
	public int getAttBuff() {
		return this.ATT_BUFF[this.getLevel()];
	}
	@Override
	public int getBuffTurn() {
		return this.BUFF_TURN;
	}
}
