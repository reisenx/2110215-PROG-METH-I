package monkey;

public class MuscleMonkey extends BaseMonkey {
	// Class Properties
	private final int POWER_UP = 4;
	
	// Constructor Method
	public MuscleMonkey(int maxHp, int atk, int def) { super(maxHp, atk, def); }
	
	// GetPowerUp Method
	public int getPowerUp() { return POWER_UP; }
	
	// Attack Method
	@Override
	public void attack(BaseMonkey m) {
		super.attack(m);
		super.attack(m);
	}
	
	// Buff Method
	public void buff() {
		this.setAtk(this.getAtk() + getPowerUp());
		this.setDef(this.getDef() + getPowerUp());
	}
	
	// GetType Method
	@Override
	public String getType() {
		return "MuscleMonkey";
	}
}
