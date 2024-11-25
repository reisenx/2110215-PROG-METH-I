package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.CPShop;
import logic.Order;
import logic.OrderItem;

class CPShopTest {

	
	@BeforeEach
	void setUp() {
		CPShop.initializeData();
//		Item("Yggdrasil Leaf", 4000));
//		Item("Red Potion", 100));
//		Item("White Potion", 215));
//		Item("Blink Dagger", 2250));
		CPShop.addNewItem("[4] Item5 test", 999);
		
	}
	
	
	@Test
	void testAddItemToOrder() {
		CPShop.addBlankOrder();
		Order order = CPShop.getOrderList().get(0);
		CPShop.addItemToOrder(order, 3, 50);
		assertEquals("Blink Dagger", order.getOrderItemList().get(0).getItem().getName());
		assertEquals(50, order.getOrderItemList().get(0).getItemAmount());

		CPShop.addItemToOrder(order, 4, 88);
		OrderItem orderItem2 = order.getOrderItemList().get(1);
		assertEquals("[4] Item5 test", orderItem2.getItem().getName());
		assertEquals(88, orderItem2.getItemAmount());
	}


}
