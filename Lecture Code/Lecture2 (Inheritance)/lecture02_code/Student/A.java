package Student;

public class A {
	public static void main(String[] args) {
		A a = new B();
		a.foo();
	}
	
	private void foo() {
		System.out.println("A");
	}
}
