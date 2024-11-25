package products;

import discount.FreeDiscountable;
import discount.Sellable;
import logic.ShopUtil;

public class FreeDiscountProduct extends BaseProduct implements FreeDiscountable {
	private int promoQuantity;
	private int freeQuantity;

	public FreeDiscountProduct(String name,int price, int promoQ, int freeQ) {
		super(name,price);
		setPromoQuantity(promoQ);
		setFreeQuantity(freeQ);
	}

	public int calcFreeDiscountPieces(int totalQuantityBought){
		return ShopUtil.calculateFreeDiscountPieces(freeQuantity,promoQuantity,totalQuantityBought);
	}
	@Override
	public int calculateDiscount(int quantity){
		return calcFreeDiscountPieces(quantity)*getPrice();
	}

	public String toString() {
		return this.getProductName() + " (Price: " + this.getPrice() + ", Buy " + this.getPromoQuantity() + " Get " + this.getFreeQuantity() + " Free)";
	}

	public int getPromoQuantity() {
		return promoQuantity;
	}

	public void setPromoQuantity(int promoQuantity) {
		this.promoQuantity = promoQuantity<1?1:promoQuantity;

	}

	public int getFreeQuantity() {
		return freeQuantity;
	}

	public void setFreeQuantity(int freeQuantity) {

		this.freeQuantity = freeQuantity<1?1:freeQuantity;
	}



}
