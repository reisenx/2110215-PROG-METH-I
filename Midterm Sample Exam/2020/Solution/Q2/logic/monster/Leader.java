package logic.monster;

import logic.attack.Attack;

public class Leader extends Monster {
	int maxChargeTurns, currentChargeTurns;
	boolean isGuard;


	public Leader(String name, int hp, int def, int sp_def, Attack attack, int chargeTurns) {
		super(name, hp, def, sp_def, attack);
		setMaxChargeTurns(chargeTurns);
		setCurrentChargeTurns(0);

	}

	public void setCurrentChargeTurns(int currentChargeTurns) {
		this.currentChargeTurns = Math.max(0, currentChargeTurns);
		this.currentChargeTurns = Math.min(getMaxChargeTurns(), getCurrentChargeTurns());
	}

	public boolean isReady() {
		return getCurrentChargeTurns() >= getMaxChargeTurns();
	}

	public int takeDamage(Attack attack) {
		int dmg =0;//ไว้return
		if(isGuard()){return dmg;}//return 0
		if(attack.isLeader()){
			dmg = attack.calculateDamage(this);
			setHp(getHp() - attack.calculateDamage(this));
		}
		else{ dmg = attack.calculateDamage(this);
		setHp(getHp() - (int)(Math.ceil(dmg*0.5)));}

		if (getHp() <= 0) {
			setDead(true);
		}

		return dmg;
	}


	public void setMaxChargeTurns(int maxChargeTurns) {
		this.maxChargeTurns = maxChargeTurns;
	}

	public int getMaxChargeTurns() {
		return maxChargeTurns;
	}

	public int getCurrentChargeTurns() {
		return currentChargeTurns;
	}
	public boolean isGuard() {
		return isGuard;
	}

	public void setGuard(boolean guard) {
		isGuard = guard;
	}


}