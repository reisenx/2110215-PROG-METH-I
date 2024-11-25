package Exception_Code;

class MyException extends Exception {
	public MyException(String s) {
		System.out.println("MyException = " + s);
	}
}

public class TestMyException {
	static void welcome(String s) throws MyException {
		if (s.equals("JAVA"))
			System.out.println("Welome to JAVA World");
		else
			throw new MyException(s + " not allowed here");
	}

	public static void main(String[] args) {
		try {
			welcome("C#");
		} catch (MyException e1) {
			System.out.println("MyException.");
		}
	}

}
