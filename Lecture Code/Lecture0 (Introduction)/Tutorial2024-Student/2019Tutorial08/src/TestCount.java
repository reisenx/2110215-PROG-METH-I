import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCount {

	char[] c1 = {'a','b','d','f','g','g','f','a','d','f','g','f'};
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testCount() {
		assertEquals(2,Count.count(c1,'a'));
	}
	

}
