package application;

import java.util.ArrayList;
import java.util.Scanner;

import logic.Item;
import logic.OrderItem;
import logic.Order;
public class CPShop {

	private static ArrayList<Item> itemList;
	private static ArrayList<Order> orderList;
	
	private static boolean isEnd = false;

	private static Scanner kb =  new Scanner(System.in);

	public static void main(String[] args) {
		initializeData();
		
		while(!isEnd) {
		System.out.println("===========CP Shop===========");
		System.out.println("What do you want to do?");
		System.out.println("[1] Add New Item");
		System.out.println("[2] List All Items");
		System.out.println("[3] Create New Order");
		System.out.println("[4] List All Orders");
		System.out.println("[5] Quit");
		System.out.print("> Please select your option:\t");
		
		int command = kb.nextInt();
		
		kb.nextLine();
		System.out.println("=========================================");
		
		switch(command) {
		case 1:
			handleAddItem();
			break;
		case 2:
			showAllItems();
			break;
		case 3:
			handleCreateNewOrder();
			break;
		case 4:
			showAllOrder();
			break;
		case 5:
			isEnd = true;
			break;
		default:
			System.out.println("Invalid Command.");
		}
		System.out.println("=========================================\n");
		}
			
	}
	
	public static void addItemToOrder(Order order, int index, int amount) {
		// TODO
		// Add item at given itemIndex from itemList to the order with given amount. 
		
	}

//===================================================================================================	
	
	public static boolean addNewItem(String name, int price) {
		if (name.isBlank() || isItemExisted(name)) {
			return false;
		}
		itemList.add(new Item(name, price));
		return true;
	}
	

	public static boolean isItemExisted(String name) {
		for (Item item : itemList) {
			if (item.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	private static void handleAddItem() {
		System.out.println("> Please enter item name:");
		String name = kb.nextLine();
		System.out.println("> Please enter price per pieces of item:");
		int price = kb.nextInt();
		boolean isSuccess = addNewItem(name, price);
		if(isSuccess) {
			Item item = itemList.get(itemList.size()-1);
			System.out.println(item.getName() + " (" + item.getPricePerPiece() + ") has been added to item list successfully!");
		} else {
			System.out.println("Error item name [" + name + "] already exists or item name is Blank!");
		}		
	}

	private static void handleCreateNewOrder() {
		showAllItems();
		Order order = new Order();
		boolean isEnd = false;
		while (!isEnd) {
			System.out.println("> Enter index of item to add to order / Enter blank to end order.");
			String cmd = kb.nextLine();
			if (cmd.isBlank()) {
				isEnd = true;
				continue;
			}
			int index = -1;
			try {
				index = Integer.parseInt(cmd.strip());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input");
			} finally {
				if(index >= itemList.size() || index < 0){
					System.out.println("Error: Invalid index number!");
				} 
				else {
					System.out.println("> Please enter of amount of the item.");		
					int amount = kb.nextInt();
					kb.nextLine();
					addItemToOrder(order, index, amount);
				}
			}
		}
		orderList.add(order);								
		System.out.println("Order No." + order.getOrderNumber() + " created successfully!");
	}

	private static void showAllItems() {
		int n = 0;
		for(Item item: itemList) {
			System.out.println("[" + n + "] " + item.getName() + " price per piece: " + item.getPricePerPiece() );
			n++;
		}
		
	}

		
	private static void showAllOrder() {
		for(Order order : orderList) {
			System.out.println("Order No." + order.getOrderNumber() + " : total price " + order.calculateOrderTotalPrice());			
			ArrayList<OrderItem> itemListInOrder = order.getOrderItemList();
			for (OrderItem orderItem : itemListInOrder) {
				System.out.println(" -- " + orderItem.getItem().getName() + " " + orderItem.getItemAmount() + " piece(s) * " + orderItem.getItem().getPricePerPiece() + " per piece.");
			}
		}
	}

	public static ArrayList<Order> getOrderList(){
		return orderList;
	}
	
	public static void addBlankOrder() {
		orderList.add(new Order());
	}
	
	public static void initializeData() {
		itemList = new ArrayList<Item>();
		orderList = new ArrayList<Order>();
		itemList.add(new Item("Yggdrasil Leaf", 4000));
		itemList.add(new Item("Red Potion", 100));
		itemList.add(new Item("White Potion", 215));
		itemList.add(new Item("Blink Dagger", 2250));
	}
	
}
