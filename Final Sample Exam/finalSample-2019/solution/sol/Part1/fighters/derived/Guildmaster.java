package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Guardable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Guildmaster extends Unit implements Guardable,Attackable{

	public Guildmaster(int
			maxHealth, int speed, int
			power, int defense, int
			location) {
		super("Guildmaster", "G", maxHealth, speed, location, false);
		this.setRange(1);
		this.setPower(power);
		this.setDefense(defense);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guard() {
		
		// TODO Auto-generated method stub
		
	}
	public boolean move(int spaces) {
		// TODO Auto-generated method stub
		 return super.move(-1);
		
	}

	@Override
	public int attack(fighters.base.Unit e) {
		if (!this.sameTeam(e)) {
		if(BattleUtils.validRange(this.getRange(),this.getLocation(),e.getLocation()))
		{return BattleUtils.calculateDamage(power, e);}
	}
	return -1;
}
}
	
