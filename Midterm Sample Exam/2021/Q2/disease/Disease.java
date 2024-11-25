package disease;

import util.SevereLevel;

public abstract class Disease {
	
	public final SevereLevel getSevereLevel(boolean isVacinate) {
		return severeLevel(isVacinate);
	}
	
	protected abstract SevereLevel severeLevel(boolean isVacinate);
}
