package fighters.derived;

import fighters.base.Guardable;
import fighters.base.Unit;

public class Tank extends Unit implements Guardable{

	public Tank(int maxHealth, int
			speed, int defense, int
			location) {
		super("Tank", "t", maxHealth, speed, location, true);
		this.setDefense(defense);
	}

	@Override
	public void guard() {
		setOnGuard(true);
		// TODO Auto-generated method stub
		
	}
	public boolean move(int spaces) {
		setOnGuard(false);
		// TODO Auto-generated method stub
		 return super.move(spaces);
		
	}
	
}