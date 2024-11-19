package item.consumption;
import item.base.BaseConsumption;
import item.usage.*;

public class Pill extends BaseConsumption implements Healable {
	// Class Properties
	private final int RECOVER_PT = 2;
	
	// Constructor Methods
	public Pill() {
		super("Pill");
	}
	
	// Methods
	@Override
	public String toString() {
		return this.getName() + " (+" + this.getRecoverPoint() + " HP)";
	}
	
	// Getters & Setters
	@Override
	public int getRecoverPoint() {
		return this.RECOVER_PT;
	}
}
