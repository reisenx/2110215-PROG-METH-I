package item.weapon;
import item.base.BaseWeapon;

public class Stick extends BaseWeapon {
	// Class Properties
	private final int ATT = 1;
	
	// Constructor Methods
	public Stick() {
		super("Stick", 3, 0);
	}
	
	// Getters & Setters
	public int getAtt() {
		return this.ATT;
	}
}
