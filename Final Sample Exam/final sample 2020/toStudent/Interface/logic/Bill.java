package logic;

import java.util.ArrayList;

public class Bill {
	
	public ArrayList<BillItem> itemsInBill;
	
	public Bill() {
		itemsInBill = new ArrayList<BillItem>();
	}
	
	public void printAllItemsInBill() {
		if(itemsInBill.isEmpty()) {
			System.out.println("Bill is empty!");
		}else {
			int iteration = 0;
			for(BillItem b : itemsInBill) {
				System.out.println(iteration +") " + b.toString());
				iteration++;
			}
		}
	}
	
	public int getTotalBillPrice(boolean hasDiscount) {
		int totalMoney = 0;
		
		if(itemsInBill.isEmpty()) {
			return totalMoney;
		}
		
		for(BillItem b : itemsInBill) {
			totalMoney += b.getPrice(hasDiscount);
		}
		
		return totalMoney;
	}

}
