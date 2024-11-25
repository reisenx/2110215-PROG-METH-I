package disease;

import util.SevereLevel;

public class Hypopnea extends Disease{

	@Override
	protected SevereLevel severeLevel(boolean isVacinate) {
		// TODO Auto-generated method stub
		return SevereLevel.MildOrLess;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hypopnea";
	}
	
}
