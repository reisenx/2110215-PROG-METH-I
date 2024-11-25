package Super;

class Person1 {
	void message() {
		System.out.println("welcome");
	}
}

public class Student1 extends Person1 {
	void message() {
		System.out.println("welcome to java");
	}

	void display() {
		message();// will invoke current class message() method
		super.message();// will invoke parent class message() method
	}

	public static void main(String args[]) {
		Student1 s = new Student1();
		s.display();
	}
}
