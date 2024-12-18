package logic.components;
import exception.BadStatusException;

public class Monster {
	// Class Properties
	private String name;
	private Status status;
	private Food food;
	private Potion potion;
	
	// Constructor Method
	public Monster(String name, Status status) {
		if(status.getHp() < 1) {
			try { status.setHp(1); }
			catch(BadStatusException e) {}
		}
		this.setStatus(status);
		this.setName(name);;
		this.setFood(null);
		this.setPotion(null);
	}
	
	// Attack Method
	public void attack(Player player) {
		int HP = player.getStatus().getHp();
		int PureDMG = this.getStatus().getAttack();
		int DURABILITY = player.getStatus().getDurability();
		int ExactDMG = Math.max(0, PureDMG-DURABILITY);
		
		try { player.getStatus().setHp(Math.max(0, HP-ExactDMG)); }
		catch (BadStatusException e) {}
	}
	
	// Magic Method
	public void magicAttack(Player player) {
		int HP = player.getStatus().getHp();
		int DMG = this.getStatus().getMagic();
		
		try { player.getStatus().setHp(Math.max(0, HP-DMG)); }
		catch (BadStatusException e) {}
	}
	
	// Getter & Setter Method for name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter & Setter Method for status
	public Status getStatus() {
		return this.status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	// Getter & Setter Method for food
	public Food getFood() {
		return this.food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	
	// Getter & Setter Method for potion
	public Potion getPotion() {
		return this.potion;
	}
	public void setPotion(Potion potion) {
		this.potion = potion;
	}
}
