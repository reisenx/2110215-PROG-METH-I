package discount;

public interface FreeDiscountable extends Sellable{
	public abstract int calcFreeDiscountPieces(int totalQuantityBought);
}
