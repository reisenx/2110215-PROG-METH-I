// Program in case super is not required
package Super;

class Person2 {
	void message() {
		System.out.println("welcome");
	}
}

class Student2 extends Person2 {

	void display() {
		message();// will invoke parent class message() method
	}

	public static void main(String args[]) {
		Student2 s = new Student2();
		s.display();
	}
}