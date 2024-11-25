package app;

import products.*;
import logic.*;
import discount.*;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	
	static Bill bill = new Bill();
	static ArrayList<Sellable> shop = new ArrayList<Sellable>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		System.out.println("Welcome to Smoke Shop!");
		boolean programRunning = true;
		
		while(programRunning) {
			System.out.println("Choose Action");
			System.out.println("0) View Items in Shop");
			System.out.println("1) Add Items to Shop");
			System.out.println("2) Remove Items from Shop");
			System.out.println("3) Add Item to Bill");
			System.out.println("4) Remove Item from Bill");
			System.out.println("5) Calculate Price at Checkout");
			System.out.println("6) Quit");
			
			String choice = sc.nextLine();
		
			try{
				int choiceInt = Integer.parseInt(choice);
				switch(choiceInt) {
				case(0):
					showItems();
					break;
				case(1):
					boolean addSuccess = addItem();
					if(!addSuccess) {
						System.out.println("Failed to add product. Returning to menu.");
					}
					break;
				case(2):
					boolean removeSuccess = removeItem();
					if(!removeSuccess) {
						System.out.println("Failed to remove product. Returning to menu.");
					}
					break;
				case(3):
					boolean addBillSuccess = addItemToBill();
					if(!addBillSuccess) {
						System.out.println("Failed to add item to bill. Returning to menu.");
					}
					break;
				case(4):
					boolean removeBillSuccess = removeItemFromBill();
					if(!removeBillSuccess) {
						System.out.println("Failed to remove item from bill. Returning to menu.");
					}
					break;
				case(5):
					System.out.println("Checkout");
					bill.printAllItemsInBill();
					System.out.println("No Discount Price: " +bill.getTotalBillPrice(false));
					System.out.println("Discounted Price: " +bill.getTotalBillPrice(true));
					break;
				case(6):
					programRunning = false;
					break;
				default:
					System.out.println("Not a valid choice!");
				}
					
			}catch(Exception e) {
				System.out.println("Not a valid choice!");
			}
			System.out.println("-----xxxxx-----");
		}
		
		
	}
	
	public static void showItems() {
		
		if(shop.isEmpty()) {
			System.out.println("There are no items in this shop!");
		}else {
			int enumerate = 0;
			System.out.println("List of shop items:");
			for(Sellable p : shop) {
				System.out.println(enumerate + ") " + p.toString());
				enumerate++;
			}
		}
	}
	
	public static boolean addItem() {
		try {
			System.out.println("Please input item name: ");
			String itemName = sc.nextLine();
			
			System.out.println("Please input the base price: ");
			String bp = sc.nextLine();
			int basePrice = Integer.parseInt(bp);
			
			System.out.println("Does this item have a Buy X Get Y Free promotion? (Y/N)");
			String choice = sc.nextLine();
			
			int promoDecider = 0;
			int promoQuantity = 0;
			int freeQuantity = 0;
			
			boolean freePromo = false;
			if(choice.toLowerCase().equals("y")) {
				promoDecider += 1;
				System.out.println("Please input the X and Y, separated by a line break.");
				String pq = sc.nextLine();
				String fq = sc.nextLine();
				promoQuantity = Integer.parseInt(pq);
				freeQuantity = Integer.parseInt(fq);
				System.out.println("Your item is now Buy " + promoQuantity + " Get " + freeQuantity + " Free.");
				freePromo = true;
			}else if(choice.toLowerCase().equals("n")) {
				System.out.println("Your item does not have a Buy X Get X Free promotion.");
			}else {
				return false;
			}
			
			double percentDiscount = 0;
			
			if(!freePromo) {
				System.out.println("Does this item have a Percent promotion? (Y/N)");
				choice = sc.nextLine();

				if(choice.toLowerCase().equals("y")) {
					promoDecider += 2;
					System.out.println("Please input the percentage discount.");
					String pdq = sc.nextLine();
					percentDiscount = Double.parseDouble(pdq);
					System.out.println("Your item now has " + percentDiscount + "% discount.");
				}else if(choice.toLowerCase().equals("n")) {
					System.out.println("Your item does not have a Percent promotion.");
				}else {
					return false;
				}
			}
			
			BaseProduct item;
			
			switch(promoDecider) {
			
			case 0:
				//no discount at all
				item = new BaseProduct(itemName, basePrice);
				System.out.println("Your New Item: " + item);
				break;
			case 1:
				//only has bogo discount
				item = new FreeDiscountProduct(itemName, basePrice, promoQuantity, freeQuantity);
				System.out.println("Your New Item: " + (FreeDiscountProduct) item);
				break;
			case 2:
				//only has percent discount
				item = new PercentDiscountProduct(itemName, basePrice, percentDiscount);
				System.out.println("Your New Item: " + (PercentDiscountProduct) item);
				break;
			default:
				return false;
			}
			
			shop.add(item);
			System.out.println(item.getProductName() + " added to the shop!");
			return true;
			
		}catch (Exception e){
			return false;
		}

	}
	
	public static boolean removeItem() {
		try{
			System.out.println("Please choose an item to remove.");
			showItems();
			
			String choice = sc.nextLine();
			int numberChoice = Integer.parseInt(choice);
			
			Sellable removedItem = shop.remove(numberChoice);
			
			System.out.println(removedItem.getProductName() + " successfully removed.");
			
			return true;
		}catch(Exception e) {
			return false;
		}
		

		
	}
	
	public static boolean addItemToBill() {
		
		System.out.println("Please choose an item to add to the bill.");
		showItems();
		
		try {
			
			//Things you need to do here:
			//A1. Accept a string input with sc.nextLine()
			//A2. Attempt to parse the string into an int (the try/catch will handle bad cases automatically)
			//A3. Use the int from step A2 to get a Sellable object from the ArrayList called shop
			
			System.out.println("Please choose the quantity of the items you want to buy.");
			
			//Things you need to do here:
			//B1. Accept a string input with sc.nextLine()
			//B2. Attempt to parse the string into an int (the try/catch will handle bad cases automatically)
			//B3. Use the Sellable from step A3 and the quantity from step B2 to initialize a new BillItem
			//B4. Add the BillItem in step B3 to bill.itemsInBill
			
			//If you wrote this function correctly, then you should be able to correctly add items to your bill
			
			System.out.println(newBillItem + " added to the bill.");
			return true;
		}catch (Exception e) {
			return false;
		}

		
	}
	
	public static boolean removeItemFromBill() {
		System.out.println("Please choose an item to remove from the bill.");
		bill.printAllItemsInBill();
		
		try {
			String removeChoice = sc.nextLine();
			int removeChoiceNumber = Integer.parseInt(removeChoice);
			
			BillItem removedLine = bill.itemsInBill.remove(removeChoiceNumber);
			
			System.out.println(removedLine + " removed from bill.");
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
}
