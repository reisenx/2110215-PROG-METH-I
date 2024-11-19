package monkey;

public class BaseMonkey {
	// Class Properties
	private int maxHp, hp, atk, def;
	
	// Constructor Method
	public BaseMonkey() {
		this.setMaxHp(30);
		this.setHp(30);
		this.setAtk(20);
		this.setDef(5);
	}
	public BaseMonkey(int maxHp, int atk, int def) {
		this.setMaxHp(maxHp);
		this.setHp(maxHp);
		this.setAtk(atk);
		this.setDef(def);
	}
	
	// Attack method
	public void attack(BaseMonkey m) {
		int EnemyHp = m.getHp();
		int DMG = this.getAtk() - m.getDef();
		m.setHp(Math.max(0, EnemyHp - DMG));
	}
	
	// GetType method
	public String getType() {
		return "BaseMonkey";
	}
	
	// toString method
	public String toString() {
		return this.getType() + " hp=" + this.getHp() + ", atk=" + this.getAtk() + ", def=" + this.getDef();
	}
	
	// Getter & Setter for MaxHp
	public int getMaxHp() {
		return this.maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = Math.max(0, maxHp);
	}
	
	// Getter & Setter for hp
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = Math.max(0,hp);
		this.hp = Math.min(this.hp, this.getMaxHp());
	}
	
	// Getter & Setter for atk
	public int getAtk() {
		return this.atk;
	}
	public void setAtk(int atk) {
		this.atk = Math.max(0,atk);
	}
	
	// Getter & Setter for def
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = Math.max(0, def);
	}
}
