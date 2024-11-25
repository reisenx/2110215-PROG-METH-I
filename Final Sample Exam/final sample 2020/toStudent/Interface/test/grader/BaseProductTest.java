package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import products.*;
import discount.*;

public class BaseProductTest {
	@Test
	void sellableTest() {
		BaseProduct bp = new BaseProduct("Strawberry Milk", 24);
		Sellable s = (Sellable) bp;
		assertEquals(0, s.calculateDiscount(2));
	}
}
