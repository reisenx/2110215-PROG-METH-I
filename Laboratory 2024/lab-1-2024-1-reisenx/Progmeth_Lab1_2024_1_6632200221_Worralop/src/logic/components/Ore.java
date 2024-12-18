package logic.components;

public class Ore {
	// Class Properties
	private String name;
	private int cost;
	
	// Constructor Method
	public Ore(String name, int cost) {
		this.setName(name);
		this.setCost(cost);
	}
	
	// Equals Method
	public boolean equals(Object o) {
		Ore OtherOre = (Ore) o;
		
		boolean CheckName = OtherOre.getName().equals(this.getName());
		boolean CheckCost = (this.getCost() == OtherOre.getCost());
		
		return CheckName && CheckCost;
	}	
	
	// Getter & Setter Method for name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter & Setter Method for cost
	public int getCost() {
		return this.cost;
	}
	public void setCost(int cost) {
		if(cost < 1) this.cost = 1;
		else this.cost = cost;
	}
}
