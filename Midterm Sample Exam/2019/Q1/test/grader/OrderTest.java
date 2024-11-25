package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Item;
import logic.Order;

class OrderTest {

	static Item item1 = new Item("Item1",100);
	static Item item2 = new Item("Item2",200);
	static Item item3 = new Item("Item3",300);
	
	@BeforeEach
	void reset() {
		Order.resetTotalOrderCount();
	}
	
	@Test
	void testConstructor() {
		assertEquals(0, Order.getTotalOrderCount());
		Order order = new Order();
		assertEquals(1, Order.getTotalOrderCount());
		assertEquals(0, order.getOrderNumber());
		assertNotNull(order.getOrderItemList());
	}
	
	@Test
	void testAddItemNormal() {
		Order order = new Order();
		order.addItem(item1, 30);
		assertEquals(30, order.getOrderItemList().get(0).getItemAmount());
		assertEquals(item1, order.getOrderItemList().get(0).getItem());
		
		order.addItem(item2, 522);
		assertEquals(522, order.getOrderItemList().get(1).getItemAmount());
		assertEquals(item2, order.getOrderItemList().get(1).getItem());
	}

	@Test
	void testAddItemExisted() {
		Order order = new Order();
		order.addItem(item3, 30);
		
		assertEquals(30, order.getOrderItemList().get(0).getItemAmount());
		assertEquals(item3, order.getOrderItemList().get(0).getItem());
		
		order.addItem(item3, 522);
		assertEquals(1, order.getOrderItemList().size());
		assertEquals(552, order.getOrderItemList().get(0).getItemAmount());
		assertEquals(item3, order.getOrderItemList().get(0).getItem());
		
	}
	
	@Test
	void testAddItemNegativeAmount() {
		Order order = new Order();
		order.addItem(item2, -30);
		assertEquals(0, order.getOrderItemList().get(0).getItemAmount());
		assertEquals(item2, order.getOrderItemList().get(0).getItem());
	}

	@Test
	void testAddItemExistedNegativeAmount() {
		Order order = new Order();
		order.addItem(item3, -30);
		assertEquals(0, order.getOrderItemList().get(0).getItemAmount());
		assertEquals(item3, order.getOrderItemList().get(0).getItem());

		order.addItem(item3, 522);
		assertEquals(1, order.getOrderItemList().size());
		assertEquals(522, order.getOrderItemList().get(0).getItemAmount());
		assertEquals(item3, order.getOrderItemList().get(0).getItem());
		
		order.addItem(item3, -1234);
		assertEquals(1, order.getOrderItemList().size());
		assertEquals(522, order.getOrderItemList().get(0).getItemAmount());
		assertEquals(item3, order.getOrderItemList().get(0).getItem());
		
	}
	
	@Test
	void testCalculateOrderTotalPrice() {
		Order order = new Order();
		assertEquals(0, order.calculateOrderTotalPrice());
		order.addItem(item1, 20);
		assertEquals(20*100, order.calculateOrderTotalPrice());
		order.addItem(item2, 30);
		assertEquals(20*100+30*200, order.calculateOrderTotalPrice());
	}
}
