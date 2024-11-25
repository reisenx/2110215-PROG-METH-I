package Object;

public class CloneDemo1 {
	public static void main(String args[]) throws CloneNotSupportedException {
		A1 obj1 = new A1(37);
		A1 obj2 = (A1) obj1.clone();
	}
}

class A1 {
	private int x;

	public A1(int i) {
		x = i;
	}
}
