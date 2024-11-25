package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import products.*;
import discount.*;

public class PercentDiscountProductTest {
	
	@Test
	void constructorTest() {
		PercentDiscountProduct pdp = new PercentDiscountProduct("Apple Juice", 50, 20);
		assertEquals(50, pdp.getPrice());
		assertEquals("Apple Juice", pdp.getProductName());
		assertEquals(20, pdp.getPercent());
	}
	
	@Test
	void setPercentTest() {
		PercentDiscountProduct pdp = new PercentDiscountProduct("Grape Juice", 80, 25);
		pdp.setPercent(50);
		assertEquals(50, pdp.getPercent());
	}
	
	@Test
	void setPercentLessThanZeroTest() {
		PercentDiscountProduct pdp = new PercentDiscountProduct("Grape Juice", 80, 25);
		pdp.setPercent(-3);
		assertEquals(0, pdp.getPercent());
	}
	
	@Test
	void setPercentGreaterThanHundredTest() {
		PercentDiscountProduct pdp = new PercentDiscountProduct("Grape Juice", 80, 25);
		pdp.setPercent(200);
		assertEquals(100, pdp.getPercent());
	}
	
	@Test
	void calculateDiscountTest() {
		PercentDiscountProduct pdp = new PercentDiscountProduct("Lemon Juice", 90, 10);
		assertEquals(27, pdp.calculateDiscount(3));
	}
	
	@Test
	void percentDiscountableTest() {
		PercentDiscountProduct pdp = new PercentDiscountProduct("Pineapple Juice", 50, 50);
		PercentDiscountable s = (PercentDiscountable) pdp;
		assertEquals(25, s.calcDiscountPerPiece());
	}
	
	@Test
	void notFreeDiscountableTest() {
		PercentDiscountProduct pdp = new PercentDiscountProduct("Pineapple Juice", 50, 50);
		assertThrows(ClassCastException.class, ()->{
			FreeDiscountable s = (FreeDiscountable) pdp;
			s.calcFreeDiscountPieces(100);
		});
	}

	
	@Test
	void toStringTest() {
		PercentDiscountProduct pdp = new PercentDiscountProduct("Orange Juice", 30, 10);
		assertEquals("Orange Juice (Price: 30, 10.0% Off)", pdp.toString());
	}
	
}
