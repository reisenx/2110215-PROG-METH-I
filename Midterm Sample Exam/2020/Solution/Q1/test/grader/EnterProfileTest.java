package test.grader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.EnterProfile;
import logic.Person;

class EnterProfileTest {
	
	static Person fighter1 = new Person("Sora",7);
	static Person fighter2 = new Person("Riku",13);
	static Person fighter3 = new Person("Kairi",20);

	@Test
	void testConstructor() {
		EnterProfile enterProfile = new EnterProfile(fighter1,35);
		assertEquals(fighter1, enterProfile.getPerson());
		assertEquals(35, enterProfile.getBodyTemperature());		
	}
	
	@Test
	void testConstructorBelow35Temp() {
		EnterProfile enterProfile = new EnterProfile(fighter2,31);
		assertEquals(fighter2, enterProfile.getPerson());
		assertEquals(35, enterProfile.getBodyTemperature());			
	}
	@Test
	void testConstructorAbove42Temp() {
		EnterProfile enterProfile = new EnterProfile(fighter3,47);
		assertEquals(fighter3, enterProfile.getPerson());
		assertEquals(42, enterProfile.getBodyTemperature());			
	}
	@Test
	void testHasFever() {
		EnterProfile enterProfile = new EnterProfile(fighter1,35);
		assertEquals(false, enterProfile.hasFever());
		EnterProfile enterProfile2 = new EnterProfile(fighter2,38);
		assertEquals(true, enterProfile2.hasFever());
	}
	
	@Test 
	void testSetBodyTemperatureNormal() {
		EnterProfile e = new EnterProfile(fighter1,38);
		e.setBodyTemperature(35);
		assertEquals(35, e.getBodyTemperature());
		e.setBodyTemperature(40);
		assertEquals(40, e.getBodyTemperature());
	}
	
	@Test 
	void testSetBodyTemperatureTooLow() {
		EnterProfile e = new EnterProfile(fighter2,37);
		e.setBodyTemperature(33);
		assertEquals(35, e.getBodyTemperature());
		e.setBodyTemperature(30);
		assertEquals(35, e.getBodyTemperature());
	}
	
	@Test 
	void testSetBodyTemperatureTooHigh() {
		EnterProfile e = new EnterProfile(fighter3,39);
		e.setBodyTemperature(47);
		assertEquals(42, e.getBodyTemperature());
		e.setBodyTemperature(43);
		assertEquals(42, e.getBodyTemperature());
	}
	
}
