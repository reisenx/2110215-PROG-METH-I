// https://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/

public class Fruit /* implements Comparable<Fruit> */{
	private String fruitName;
	private int quantity;

	public Fruit(String fruitName, int quantity) {
		this.fruitName = fruitName;
		this.quantity = quantity;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	public int compareTo(Fruit compareFruit) {
//		int compareQuantity = ((Fruit) compareFruit).getQuantity();
//		// return this.quantity - compareQuantity;
//
//		if (this.quantity > compareQuantity)
//			return 1;
//		else
//			return -1;
//	}

}
