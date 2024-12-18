package logic.components;

public class Food {
	// Class Properties
	private String name;
	private int price, energy;
	
	// Constructor Method
	public Food(String name, int price, int energy) {
		this.setName(name);
		this.setPrice(price);
		this.setEnergy(energy);
	}
	
	// Equals Method
		public boolean equals(Object o) {
			Food OtherFood = (Food) o;
			
			boolean CheckName = OtherFood.getName().equals(this.getName());
			boolean CheckPrice = (this.getPrice() == OtherFood.getPrice());
			boolean CheckEnergy = (this.getEnergy() == OtherFood.getEnergy());
					
			return CheckName && CheckPrice && CheckEnergy;
		}
	
	// Getter & Setter Method for name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	// Getter & Setter Method for price
	public void setPrice(int price) {
		if(price < 1) this.price = 1;
		else this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	
	// Getter & Setter Method for energy
	public void setEnergy(int energy) {
		if(energy < 1) this.energy = 1;
		else this.energy = energy;
	}
	public int getEnergy() {
		return this.energy;
	}
}
