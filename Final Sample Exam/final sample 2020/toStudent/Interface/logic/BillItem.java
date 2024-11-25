package logic;

import discount.*;

public class BillItem {
	Sellable itemInLine;
	int quantity;
	
	public BillItem(Sellable itemInLine, int quantity) {
		setItemInLine(itemInLine);
		setQuantity(quantity);
	}

	public Sellable getItemInLine() {
		return itemInLine;
	}

	public void setItemInLine(Sellable itemInLine) {
		this.itemInLine = itemInLine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity > 0 ? quantity : 1;
	}
	
	public int getPrice(boolean withDiscount) {
		if(!withDiscount) {
			return itemInLine.getPrice() * quantity;
		}else {
			int totalPrice = quantity * itemInLine.getPrice();
			return totalPrice - itemInLine.calculateDiscount(quantity);
		}
	}
	
	public String toString() {
		return this.getItemInLine().toString() + " x " + this.getQuantity() + "pc(s)";
	}
	
}
