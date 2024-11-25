package logic;

import java.util.ArrayList;

public class Item {
	private String name;
	private  int pricePerPiece;


	public Item(String name, int pricePerPiece) {
	setName(name);
	setPricePerPiece(pricePerPiece);
	}
	public void setPricePerPiece(int pricePerPiece) {
		this.pricePerPiece = Math.max(1,pricePerPiece);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPricePerPiece() {
		return pricePerPiece;
	}


}
