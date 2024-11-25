package logic;

public class ShopUtil {
	public static int calculateFreeDiscountPieces(int freeQ, int promoQ, int totalQ) {
		int freeAmount = (totalQ / (freeQ + promoQ)) * freeQ;
		
		return freeAmount;
	}
	
	public static int calculateDiscountUsingPercent(int price, double percent) {
		return (int) (price * (percent / 100.0));
	}
}
