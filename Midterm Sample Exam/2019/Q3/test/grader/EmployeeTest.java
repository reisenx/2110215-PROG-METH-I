package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Employee;
import logic.OfficeWorker;

class EmployeeTest {

	Employee o;
	
	@BeforeEach
	void setUp(){
		o = new OfficeWorker("Eric",151119,"MC Insurance");
	}
	
	@Test
	void testConstructor(){
		assertEquals("Eric",o.getName());
		assertEquals(151119,o.getId());
		assertEquals(30,o.getBaseSalary());
		assertEquals(0,o.getBonus());
	}
	
	@Test
	void testSetName() {
		o.setName("Rose");
	    assertEquals("Rose",o.getName());
	}

	@Test
	void testSetId() {
		o.setId(420);
	    assertEquals(420,o.getId());
	}

	@Test
	void testSetBaseSalary() {
		o.setBaseSalary(900);
		assertEquals(900,o.getBaseSalary());
	}
	
	@Test
	void testSetBaseSalaryNegative() {
		o.setBaseSalary(-1);
		assertEquals(0,o.getBaseSalary());
	}

	@Test
	void testSetBonus() {
		o.setBonus(900);
		assertEquals(900,o.getBonus());
	}
	
	@Test
	void testSetBonusNegative() {
		o.setBonus(-1);
		assertEquals(0,o.getBonus());
	}

}
