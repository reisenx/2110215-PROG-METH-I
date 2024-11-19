package item.armor;
import item.base.BaseArmor;

public class Boots extends BaseArmor {
	// Class Properties
	private final int DEF = 1;
	
	// Constructor Methods
	public Boots() {
		super("Boots",5);
	}
	
	// Getters & Setters
	@Override
	public int getDef() {
		return this.DEF;
	}
	
}
