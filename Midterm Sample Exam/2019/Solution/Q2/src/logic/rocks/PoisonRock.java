package logic.rocks;

import logic.zombies.Zombie;

public class PoisonRock extends NormalRock {
	private int damageOverTime;
	public PoisonRock(int damage,int damageOverTime) {
		super(damage);
		setDamageOverTime(damageOverTime);
	}
	public void setDamageOverTime(int damageOverTime) {
		this.damageOverTime = Math.max(0,damageOverTime);
	}
	public int getDamageOverTime() {
		return damageOverTime;
	}
	public int dealDamage(Zombie zombie) {
		zombie.setDecay(zombie.getDecay()+damageOverTime);
		if(zombie.getDefense()>=getDamage()){
			return 0;
		}
		else {int reduceHealth=getDamage()- zombie.getDefense();
			zombie.setHealth(zombie.getHealth()-reduceHealth);
			return reduceHealth;

		}
	}
	
	@Override
	public String toString() {
		return "Poison Rock (" + getDamage() +", DoT = "
				+getDamageOverTime() +")";
	}

}
