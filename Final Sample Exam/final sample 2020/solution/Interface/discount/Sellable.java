package discount;

public interface Sellable {
	public abstract int calculateDiscount(int quantity);
	public abstract void setProductName(String productName);
	public abstract String getProductName();
	public abstract void setPrice(int price);
	public abstract int getPrice();
}
