package Exception_Code;

public class Throw1 {
	static void greet(String name) throws ClassNotFoundException,
			InterruptedException {
		if (name.equals("John"))
			throw new InterruptedException();

		System.out.println("Hello! " + name);
	}

	public static void main(String[] args)  throws ClassNotFoundException {
		try {
			greet("John");
		} catch (InterruptedException e) {
			System.out.println("Bye.");
		}
	}
}
