package Object;

public class CloneDemo4 {
	public static void main(String args[]) {
		A4 obj1 = new A4(37);
		A4 obj2 = new A4(obj1);
		System.out.println(obj2.getx());
		
		A4 obj3 = A4.newInstace(obj1);
		System.out.println(obj3.getx());
	}
}

class A4 implements Cloneable {
	private int x;

	public A4(int i) {
		this.x = i;
	}

	// 1. copy constructor
	public A4(A4 other) {
		this.x = other.getx();
	}
	
	// 2. static factory
	public static A4 newInstace(A4 other) {
		A4 obj = new A4(other.getx());
		return obj;
	}

	public int getx() {
		return x;
	}
}
