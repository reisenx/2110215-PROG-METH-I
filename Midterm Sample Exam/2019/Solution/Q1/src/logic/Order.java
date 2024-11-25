package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		orderItemList=new ArrayList<OrderItem>();
		totalOrderCount=orderNumber;
		totalOrderCount++;
	}

	public OrderItem addItem(Item item, int amount) {

		for (OrderItem orderItem:orderItemList){//check ว่ามีอยู่เดิมไหม
			if(orderItem.getItem().equals(item)){
				if(amount>0){
				orderItem.setItemAmount(orderItem.getItemAmount()+amount);}
				return orderItem;
			}
		}

			OrderItem orderItem = new OrderItem(item, amount);
			orderItemList.add(orderItem);
			return orderItem;
		}



	public int calculateOrderTotalPrice() {
		int orderTotalPrice=0;
		for (OrderItem orderItem:orderItemList){
			orderTotalPrice+=orderItem.calculateTotalPrice();

		}
		return orderTotalPrice;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
