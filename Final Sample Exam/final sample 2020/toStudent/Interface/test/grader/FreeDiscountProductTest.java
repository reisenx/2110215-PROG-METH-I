package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import products.*;
import discount.*;

public class FreeDiscountProductTest {
	
	@Test
	void constructorTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Sardines", 23, 2, 1);
		assertEquals(23, fdp.getPrice());
		assertEquals("Canned Sardines", fdp.getProductName());
		assertEquals(2, fdp.getPromoQuantity());
		assertEquals(1, fdp.getFreeQuantity());
	}
	
	@Test
	void setPromoQuantityTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Tuna", 15, 3, 1);
		fdp.setPromoQuantity(2);
		assertEquals(2, fdp.getPromoQuantity());

	}
	
	@Test
	void setPromoQuantityLessThanOneTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Tuna", 15, 3, 2);
		fdp.setPromoQuantity(0);
		assertEquals(1, fdp.getPromoQuantity());

	}
	
	@Test
	void setFreeQuantityTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Salmon", 32, 3, 1);
		fdp.setFreeQuantity(2);
		assertEquals(2, fdp.getFreeQuantity());

	}
	
	@Test
	void setFreeQuantityLessThanOneTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Salmon", 32, 3, 1);
		fdp.setFreeQuantity(-3);
		assertEquals(1, fdp.getFreeQuantity());

	}
	
	
	@Test
	void calculateDiscountTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Mackerel", 10, 3, 1);
		assertEquals(10, fdp.calculateDiscount(4));
	}
	
	@Test
	void freeDiscountableTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Herring", 35, 1, 1);
		FreeDiscountable s = (FreeDiscountable) fdp;
		assertEquals(3, s.calcFreeDiscountPieces(6));
	}
	
	@Test
	void notPercentDiscountableTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Herring", 35, 1, 1);
		assertThrows(ClassCastException.class, ()->{
			PercentDiscountable s = (PercentDiscountable) fdp;
			s.calcDiscountPerPiece();
		});
	}
	
	@Test
	void toStringTest() {
		FreeDiscountProduct fdp = new FreeDiscountProduct("Canned Shrimp Roe", 70, 1, 1);
		assertEquals("Canned Shrimp Roe (Price: 70, Buy 1 Get 1 Free)", fdp.toString());
	}
	
}
