package products;

import discount.Sellable;

public class BaseProduct{
	protected String productName;
	protected int price;
	
	public BaseProduct(String name, int price) {
		setProductName(name);
		setPrice(price);
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		if(productName.isBlank()) productName = "PlaceholderProduct";
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price < 0 ? 0 : price;
	}
	
	//base product does not get any discounts
	@Override
	public int calculateDiscount(int quantity) {
		return 0;
	}
	
	public String toString() {
		return this.getProductName() + " (Price: " + this.getPrice() + ", No Promo)";
	}
}
