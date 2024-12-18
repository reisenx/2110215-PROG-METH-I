package logic.components;

import java.util.ArrayList;
import exception.BadStatusException;

public class Player {
	// Class Properties
	private String name;
	private Status status;
	private int energy, money;
	private ArrayList<Food> foods;
	private ArrayList<Potion> potions;
	private ArrayList<Ore> ores;
	
	// Constructor Method
	public Player(String name, Status status) {
		if(status.getHp() < 1) {
			try {status.setHp(1);}
			catch(BadStatusException e) {}
		}
		this.setStatus(status);
		this.setName(name);
		this.setEnergy(10);
		this.setMoney(100);
		this.setFoods(new ArrayList<Food>());
		this.setPotions(new ArrayList<Potion>());
		this.setOres(new ArrayList<Ore>());
	}
	public Player(String name, Status status, int energy, int money) {
		if(status.getHp() < 1) {
			try {status.setHp(1);}
			catch(BadStatusException e) {}
		}
		this.setStatus(status);
		this.setName(name);
		this.setEnergy(energy);
		this.setMoney(money);
		this.setFoods(new ArrayList<Food>());
		this.setPotions(new ArrayList<Potion>());
		this.setOres(new ArrayList<Ore>());
	}
	
	// Buy Ore Method
	public boolean buyOre(Ore ore) {
		if(this.getMoney() > ore.getCost()) {
			this.setMoney(this.getMoney() - ore.getCost());
			this.getOres().add(ore);
			return true;
		}
		else return false;
	}
	
	// Drink Potion Method
	public void drinkPotion(int index) {
		if(index < this.getPotions().size() && index >= 0) {
			try { this.getStatus().addStatus( this.getPotions().get(index).getIncreasingStatus() ); }
			catch(BadStatusException e) {}
			
			this.getPotions().remove(index);
		}
	}
	
	// Eat Food Method
	public void eatFood(int index) {
		if(index < this.getFoods().size() && index >= 0) {
			this.setEnergy( this.getEnergy() + this.getFoods().get(index).getEnergy() );
			this.getFoods().remove(index);
		}
	}
	
	// Sell Potion Method
	public void sellPotion(int index) {
		if(index < this.getPotions().size() && index >= 0) {
			this.setMoney( this.getMoney() + this.getPotions().get(index).getPrice() );
			this.getPotions().remove(index);
		}
	}
	
	// Sell Food Method
	public void sellFood(int index) {
		if(index < this.getFoods().size() && index >= 0) {
			this.setMoney( this.getMoney() + this.getFoods().get(index).getPrice() );
			this.getFoods().remove(index);
		}
	}
	
	// Attack Method
	public void attack(Monster monster) {
		int HP = monster.getStatus().getHp();
		int PureDMG = this.getStatus().getAttack();
		int DURABILITY = monster.getStatus().getDurability();
		int ExactDMG = Math.max(0, PureDMG-DURABILITY);
		
		try { monster.getStatus().setHp(Math.max(0, HP-ExactDMG)); }
		catch (BadStatusException e) {}
	}
	
	// Magic Method
	public void magicAttack(Monster monster) {
		int HP = monster.getStatus().getHp();
		int DMG = this.getStatus().getMagic();
		
		try { monster.getStatus().setHp(Math.max(0, HP-DMG)); }
		catch (BadStatusException e) {}
	}
	
	// Getter & Setter Method for name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter & Setter Method for name
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	// Getter & Setter Method for energy
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		if(energy < 0) this.energy = 0;
		else this.energy = energy;
	}
	
	// Getter & Setter Method for money
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		if(money < 0) this.money = 0;
		else this.money = money;
	}
	
	// Getter & Setter Method for foods
	public ArrayList<Food> getFoods() {
		return foods;
	}
	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}
	
	// Getter & Setter Method for potion
	public ArrayList<Potion> getPotions() {
		return potions;
	}
	public void setPotions(ArrayList<Potion> potions) {
		this.potions = potions;
	}
	
	// Getter & Setter Method for ores
	public ArrayList<Ore> getOres() {
		return ores;
	}
	public void setOres(ArrayList<Ore> ores) {
		this.ores = ores;
	}
 }
