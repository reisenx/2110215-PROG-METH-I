package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Person;

class PersonTest {

	@Test
	void testConstructor() {
		Person warrior = new Person("Sora",13);
		assertEquals("Sora", warrior.getName());
		assertEquals(13, warrior.getID());
	}
	
	@Test
	void testConstructorMinusID() {
		Person warrior = new Person("Yozora",-13);
		assertEquals(1, warrior.getID());
	}
	
	@Test
	void testGetName() {
		Person warrior2 = new Person("Donald",2);
		assertEquals("Donald", warrior2.getName());
	}
	
	
	@Test 
	void testSetName() {
		Person warrior2 = new Person("Donald",2);
		warrior2.setName("Goofy");
		assertEquals("Goofy", warrior2.getName());
	}
	
	@Test 
	void testSetID() {
		Person warrior2 = new Person("Donald",2);
		warrior2.setID(14);
		assertEquals(14, warrior2.getID());
	}
	
	@Test 
	void testSetIDZero() {
		Person warrior2 = new Person("Donald",2);
		warrior2.setID(0);
		assertEquals(1, warrior2.getID());
	}
	




}
