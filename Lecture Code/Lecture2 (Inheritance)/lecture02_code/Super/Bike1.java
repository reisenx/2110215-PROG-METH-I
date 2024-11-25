package Super;

class Vehicle1 {
	int speed = 50;
}

class Bike1 extends Vehicle1 {
	int speed = 100;

	void display() {
		System.out.println(super.speed);// will print speed of Vehicle now
	}

	public static void main(String args[]) {
		Bike1 b = new Bike1();
		b.display();
	}
}