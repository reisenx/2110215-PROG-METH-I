package monkey;

public class UgabugagaMonkey extends BaseMonkey {
	// Class Properties
	private static final int DEBUFF = 1, HEAL = 10;
	
	// UgabugagaMonkey Method
	public UgabugagaMonkey(int maxHp, int atk, int def) { super(maxHp, atk, def); }
	
	// Attack Method
	@Override
	public void attack(BaseMonkey m) {
		super.attack(m);
		m.setAtk(m.getAtk() - getDebuff());
		m.setDef(m.getDef() - getDebuff());
	}
	
	// Heal Method
	public void heal(BaseMonkey m) {
		m.setHp(m.getHp() + getHeal());
	}
	
	// GetType Method
	public String getType() {
		return "UgabugagaMonkey";
	}
	
	// GetDebuff Method
	public int getDebuff() { return DEBUFF; }
	
	// GetHeal Method
	public int getHeal() { return HEAL; }
}
