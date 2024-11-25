package monkey;
import logic.game.*;

public class MommyMonkey extends BaseMonkey {
	// Class Properties
	public MommyMonkey(int MaxHp, int atk, int def) { super(MaxHp, atk, def); }
	
	// Attack method
	@Override
	public void attack(BaseMonkey m) {}
	
	// Birth method
	public void birth() {
		BaseMonkey m = new BaseMonkey();
		GameSystem.getInstance().getMonkeyContainer().add(m);
	}
	
	// GetType Method
	@Override
	public String getType() {
		return "MommyMonkey";
	}
}
