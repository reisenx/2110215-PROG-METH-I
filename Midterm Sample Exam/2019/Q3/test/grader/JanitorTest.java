package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Janitor;

class JanitorTest {

	Janitor o;
	
	@BeforeEach
	void setUp(){
		o = new Janitor("Adalyn",151119,"Rose Tower");
	}
	
	@Test
	void testConstructor() {
		assertEquals("Rose Tower",o.getArea());
	    assertEquals(15,o.getBaseSalary());
	}
	
	@Test
	void testArea() {
		o.setArea("Rose of the Rondelands");
	    assertEquals("Rose of the Rondelands",o.getArea());
	}
	
	@Test
	void testComputeSalary() {
		assertEquals(3600,o.computeSalary());
		o.setBonus(90);
		assertEquals(3690,o.computeSalary());
	}

}
