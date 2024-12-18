package logic.components;

import java.util.ArrayList;

public class Market
{
	// Class Properties
	private String name;
	private ArrayList<Food> foods;
	private ArrayList<Potion> potions;
	
	// Constructor Method
	public Market(String name) {
		this.setName(name);
		this.setFoods(new ArrayList<Food>());
		this.setPotions(new ArrayList<Potion>());
	}
	
	// Getter & Setter Method for name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter & Setter Method for foods
	public ArrayList<Food> getFoods() {
		return this.foods;
	}
	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}
	
	// Getter & Setter Method for potions
	public ArrayList<Potion> getPotions() {
		return this.potions;
	}
	public void setPotions(ArrayList<Potion> potions) {
		this.potions = potions;
	}
}
