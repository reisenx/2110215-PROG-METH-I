package logic.components;

public class Potion {
	// Class Properties
	private String name;
	private int price;
	private Status increasingStatus;
	
	// Constructor Method
	public Potion(String name, int price, Status increasingStatus) {
		this.setName(name);
		this.setPrice(price);
		this.setIncreasingStatus(increasingStatus);
	}
	
	// Equals Method
	public boolean equals(Object o) {
		Potion OtherPotion = (Potion) o;
		
		boolean CheckName = OtherPotion.getName().equals(this.getName());
		boolean CheckPrice = (this.price == OtherPotion.getPrice());
		boolean CheckStatus = OtherPotion.getIncreasingStatus().equals(this.getIncreasingStatus());
		
		return CheckName && CheckPrice && CheckStatus;
	}
	
	// Getter & Setter Method for name
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter & Setter Method for price
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		if(price < 1) this.price = 1;
		else this.price = price;
	}
	
	// Getter & Setter Method for increasingStatus
	public Status getIncreasingStatus() {
		return this.increasingStatus;
	}
	public void setIncreasingStatus(Status increasingStatus) {
		this.increasingStatus = increasingStatus;
	}
}
