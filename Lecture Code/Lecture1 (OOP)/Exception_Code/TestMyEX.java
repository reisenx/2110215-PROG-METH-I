package Exception_Code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMyEX {

	public static int methodThrow(int b) throws MyEX {
		if (b == 1) {
			MyEX a = new MyEX("1");
			throw a;
		}
		return 10;
	}

	public static int boo() {
		return 10 / 0;
	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testCreate() {
		MyEX a = new MyEX("1");
		assertEquals("1", a.x);
	}

	@Test
	void testThrow() {
		assertThrows(MyEX.class, () -> {
			TestMyEX.methodThrow(1);
		});
	}

	@Test
	void testArith() {
		assertThrows(ArithmeticException.class, () -> {
			TestMyEX.boo();
		});
	}

}
