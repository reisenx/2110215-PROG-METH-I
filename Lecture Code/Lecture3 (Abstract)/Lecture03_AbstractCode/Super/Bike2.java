package Super;

class Vehicle2 {
	Vehicle2() {
		System.out.println("Vehicle is created");
	}
}

public class Bike2 extends Vehicle2 {
	Bike2() {
		super();// will invoke parent class constructor
		System.out.println("Bike is created");
	}

	public static void main(String args[]) {
		Bike2 b = new Bike2();
	}
}