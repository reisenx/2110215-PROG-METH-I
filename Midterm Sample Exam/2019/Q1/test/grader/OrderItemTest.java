package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Item;
import logic.OrderItem;

class OrderItemTest {
	
	static Item item1 = new Item("Item1",100);
	static Item item2 = new Item("Item2",200);
	static Item item3 = new Item("Item3",300);

	@Test
	void testConstructor() {
		OrderItem orderItem = new OrderItem(item1,5);
		assertEquals(item1, orderItem.getItem());
		assertEquals(5, orderItem.getItemAmount());		
	}
	
	@Test
	void testConstructorNegativeAmount() {
		OrderItem orderItem = new OrderItem(item2,-40);
		assertEquals(item2, orderItem.getItem());
		assertEquals(0, orderItem.getItemAmount());		
	}
	
	@Test
	void testGetItem() {
		OrderItem orderItem = new OrderItem(item3,3);
		assertEquals(item3, orderItem.getItem());		
	}
	
	@Test
	void testGetItemAmount() {
		OrderItem orderItem = new OrderItem(item1,30);
		assertEquals(30, orderItem.getItemAmount());		
	}
	
	@Test
	void testSetItemAmount() {
		OrderItem orderItem = new OrderItem(item3,20);
		orderItem.setItemAmount(40);
		assertEquals(40, orderItem.getItemAmount());		
	}

	@Test
	void testSetItemAmountNegative() {
		OrderItem orderItem = new OrderItem(item1,50);
		orderItem.setItemAmount(-100);
		assertEquals(0, orderItem.getItemAmount());		
	}
	
	@Test
	void testCalculateTotalPrice() {
		int itemAmount = 30;
		OrderItem orderItem = new OrderItem(item1,30);
		assertEquals(100*itemAmount, orderItem.calculateTotalPrice());
	}
	
	@Test
	void testIncreaseItemAmount() {
		OrderItem orderItem = new OrderItem(item1,30);
		orderItem.increaseItemAmount(20);
		assertEquals(50, orderItem.getItemAmount());
	}

	@Test
	void testIncreaseItemAmountNegative() {
		OrderItem orderItem = new OrderItem(item1,30);
		orderItem.increaseItemAmount(-20);
		assertEquals(30, orderItem.getItemAmount());
	}
	
}
