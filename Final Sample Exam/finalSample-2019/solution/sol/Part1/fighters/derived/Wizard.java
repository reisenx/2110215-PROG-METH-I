package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Wizard extends Unit implements Attackable{

	public Wizard(int maxHealth, int
			speed, int power, int
			location) {
		super("Wizard", "w", maxHealth, speed, location, true);
		this.setRange(2);
		this.setPower(power);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public int attack(fighters.base.Unit e) {
		if (!this.sameTeam(e)) {
		if(BattleUtils.validRange(this.getRange(),this.getLocation(),e.getLocation()))
		{return this.getPower();}
	}
	return -1;
}
}