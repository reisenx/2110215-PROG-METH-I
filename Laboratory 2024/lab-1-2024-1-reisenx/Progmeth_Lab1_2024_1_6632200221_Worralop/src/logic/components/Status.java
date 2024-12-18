package logic.components;
import exception.BadStatusException;

public class Status {
	// Class Properties
	private int hp, durability, attack, magic;
	
	// Constructor Method
	public Status(int hp, int durability, int attack, int magic) throws BadStatusException {
		this.setHp(hp);
		this.setDurability(durability);
		this.setAttack(attack);
		this.setMagic(magic);
	}
	
	// Add Status Method
	public void addStatus(Status another) throws BadStatusException {
		this.setHp(this.getHp() + another.getHp());
		this.setDurability(this.getDurability() + another.getDurability()); 
		this.setAttack(this.getAttack() + another.getAttack());
		this.setMagic(this.getMagic() + another.getMagic());
	}
	
	// Equals Method
	public boolean equals(Object o) {
		Status OtherStatus = (Status) o;
		
		boolean CheckHP = (this.getHp() == OtherStatus.getHp());
		boolean CheckDurability = (this.getDurability() == OtherStatus.getDurability());
		boolean CheckAttack = (this.getAttack() == OtherStatus.getAttack());
		boolean CheckMagic = (this.getMagic() == OtherStatus.getMagic());
		
		return CheckHP && CheckDurability && CheckAttack && CheckMagic;
	}

	// Getter & Setter Method for HP
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) throws BadStatusException {
		if(hp < 0) throw new BadStatusException();
		else this.hp = hp;
	}
	
	// Getter & Setter Method for durability
	public int getDurability() {
		return this.durability;
	}
	public void setDurability(int durability) throws BadStatusException {
		if(durability < 0) throw new BadStatusException(); 
		else this.durability = durability;
	}
	
	// Getter & Setter Method for attack
	public int getAttack() {
		return this.attack;
	}
	public void setAttack(int attack) throws BadStatusException {
		if(attack < 0) throw new BadStatusException();
		this.attack = attack;
	}

	// Getter & Setter Method for magic
	public int getMagic() {
		return this.magic;
	}
	public void setMagic(int magic) throws BadStatusException {
		if(magic < 0) throw new BadStatusException();
		else this.magic = magic;
	}
}