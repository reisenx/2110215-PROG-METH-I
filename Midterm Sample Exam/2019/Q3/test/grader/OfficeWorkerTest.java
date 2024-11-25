package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.OfficeWorker;

class OfficeWorkerTest {

	OfficeWorker o;
	
	@BeforeEach
	void setUp(){
		o = new OfficeWorker("Eric",151119,"MC Insurance");
	}
	
	@Test
	void testConstructor() {
		assertEquals("MC Insurance",o.getDepartment());
	    assertEquals(30,o.getBaseSalary());
	}
	
	@Test
	void testDepartment() {
		o.setDepartment("MC Air");
	    assertEquals("MC Air",o.getDepartment());
	}
	
	@Test
	void testComputeSalary() {
		assertEquals(4800,o.computeSalary());
		o.setBonus(90);
		assertEquals(4890,o.computeSalary());
	}

}
