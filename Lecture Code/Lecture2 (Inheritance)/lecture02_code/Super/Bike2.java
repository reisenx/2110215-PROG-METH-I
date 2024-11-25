package Super;

class Vehicle2 {
	Vehicle2() {
		System.out.println("Vehicle is created");
	}
	
	Vehicle2(int a) {
		System.out.println("Vehicle (1 parameter) is created");
	}
}

public class Bike2 extends Vehicle2 {
	Bike2() {
		//super();// will invoke parent class constructor
		System.out.println("Bike is created");
	}

	Bike2(int x) {
		super(x);// will invoke parent class constructor
		System.out.println("Bike (1 parameter) is created");
	}

	public static void main(String args[]) {
		//Bike2 b = new Bike2();
		Bike2 c = new Bike2(1);
		
	}
}