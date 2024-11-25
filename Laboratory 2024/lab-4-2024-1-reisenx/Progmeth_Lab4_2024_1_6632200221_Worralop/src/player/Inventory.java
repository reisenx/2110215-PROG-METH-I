package player;

import item.base.BaseItem;

import java.util.*;

public class Inventory {

    private final ArrayList<BaseItem> ITEMS;
    private final int MAX_SIZE;
    private static final Scanner invScanner = new Scanner(System.in);

    public Inventory() {
        ITEMS = new ArrayList<>();
        MAX_SIZE = 10;
    }

    public ArrayList<BaseItem> getItems() {
        return ITEMS;
    }

    public void addItem(BaseItem item) {
        if (ITEMS.size() < MAX_SIZE) {
            ITEMS.add(item);
        }
        else {
            //use scanner to get index from user to replace item
            System.out.println("=====================================");
            System.out.println("Your inventory is full, select the item to replace");
            System.out.println("<-1> : void incoming item");
            printAllItem();
            String input = invScanner.nextLine();
            try {
                int index = Integer.parseInt(input);
                if (index != -1) {
                    ITEMS.set(index, item);
                    System.out.println(item.getName() + " has been added to your inventory");
                } else {
                    System.out.println("Item has been voided");
                }

            } catch (NumberFormatException e) {
                System.out.println("That is not number, try again");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bound, try again");
            }

        }
    }

    public void removeItem(BaseItem item) {
        ITEMS.remove(item);
    }

    public void printAllItem() {
        for (int i=0; i<getItems().size(); i++) {
            System.out.println("<" + i + "> " + getItems().get(i).toString());
        }
    }
}
