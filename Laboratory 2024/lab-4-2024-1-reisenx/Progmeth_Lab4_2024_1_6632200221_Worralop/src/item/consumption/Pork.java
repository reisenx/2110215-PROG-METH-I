package item.consumption;
import item.base.BaseConsumption;
import item.usage.*;
import java.util.HashMap;

public class Pork extends BaseConsumption implements Cookable, Healable {
	// Class Properties
	private CookState cookState;
	private final HashMap<CookState, Integer> RECOVER_PT = new HashMap<>();
	
	// Constructor Methods
	public Pork() {
		super("Pork");
		this.cookState = CookState.RAW;
		RECOVER_PT.put(CookState.RAW, 1);
		RECOVER_PT.put(CookState.COOKED, 2);
		RECOVER_PT.put(CookState.BURNT, 0);
	}
	
	// Methods
	@Override
	public String toString() {
		String s;
        switch (getCookState()) {
            case RAW -> { s = "Raw"; }
            case COOKED -> { s = "Cooked"; }
            case BURNT -> {s = "Burnt"; }
            default -> {s = "";}
        }
        return s + " " + getName() + " (+" + getRecoverPoint() + " HP)";
	}
	
	// Getters & Setters
	@Override
	public CookState getCookState() {
		return this.cookState;
	}
	@Override
	public void setCookState(CookState cookState) {
		this.cookState = cookState;
	}
	@Override
	public int getRecoverPoint() {
		return RECOVER_PT.get(this.getCookState());
	}
}
