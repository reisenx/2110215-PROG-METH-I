package monkey;
import java.util.ArrayList;
import logic.game.*;

public class Ape extends BaseMonkey {
	// Constructor Method
	public Ape(int maxHp, int atk, int def) { super(maxHp, atk, def); }
	
	// Attack Method
	@Override
	public void attack(BaseMonkey m) { super.attack(m); }
	
	// AttackAOE Method
	public void attackAOE() {
		ArrayList<BaseMonkey> monkeys = logic.game.GameSystem.getInstance().getMonkeyContainer();
		for(int i = 0; i < monkeys.size(); i++) {
			this.attack(monkeys.get(i));
		}
	}
	
	// getType Method
	@Override
	public String getType() {
		return "Ape";
	}
}
