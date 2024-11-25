import java.util.Arrays;

public class SortedFruit1 {

	public static void main(String[] args) {
		// 1. Array
		String[] fruits = new String[] {"Pineapple","Apple", "Orange", "Banana"};

		Arrays.sort(fruits);

		int i=0;
		for(String temp: fruits){
			System.out.println("fruits " + ++i + " : " + temp);
		}
		
	}

}
