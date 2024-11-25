package test.student;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.User;
import logic.Channel;
import logic.Message;


public class ChannelTest {

	Channel c;
	Message m1, m2, m3;
	
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	void testConstructor() {
		c = new Channel("Let's Chill");
		
		assertEquals("Let's Chill", c.getName());
		assertEquals(0, c.getMessageList().size());
	}
	
	@Test
	void testConstructorEmptyName() {
		c = new Channel("");
		
		assertEquals("off-topic", c.getName());
		assertEquals(0, c.getMessageList().size());
	}
	
	@Test 
	void testSetName() {
		c = new Channel("Let's Chill");
		c.setName("Let's Rock");
		
		assertEquals("Let's Rock", c.getName());
	}
	
	@Test
	void testSetNameEmpty() {
		c = new Channel("Let's Chill");
		c.setName("       ");
		
		assertEquals("off-topic", c.getName());
		
	}
	
	
	@Test
	void testAddMessage() {
		c = new Channel("RandomText");
		m1 = new Message("Premium Grade Sashimi On Sale !", new User("Sanji"));
		m2 = new Message("Don't forget to brush your teeth !", new User("Mommy"));
		m3 = new Message("Shizuka ni shizuka ni maku wa kiri otoshi ~", new User("Sid"));
		
		ArrayList<Message> listToTest = c.getMessageList();
		
		c.addMessage(m1);
		assertEquals(1, listToTest.size());
		assertEquals("Premium Grade Sashimi On Sale !", listToTest.get(0).getText());
		assertEquals("Sanji", listToTest.get(0).getSender().getName());
		
		c.addMessage(m2);
		assertEquals(2, listToTest.size());
		assertEquals("Don't forget to brush your teeth !", listToTest.get(1).getText());
		assertEquals("Mommy", listToTest.get(1).getSender().getName());
		
		
		c.addMessage(m3);
		assertEquals(3, listToTest.size());
		assertEquals("Shizuka ni shizuka ni maku wa kiri otoshi ~", listToTest.get(2).getText());
		assertEquals("Sid", listToTest.get(2).getSender().getName());
	}
	
	@Test
	void testGetMessageCount() {
		c = new Channel("RandomText");
		for (int i = 0; i < 50; ++i) {
			c.addMessage(new Message("Oops", new User("Mr. " + Integer.toString(i))));
			assertEquals(i + 1, c.getMessageCount());
		}
	}
	
}