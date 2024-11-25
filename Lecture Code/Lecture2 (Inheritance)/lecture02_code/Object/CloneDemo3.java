package Object;

public class CloneDemo3 {
	public static void main(String args[]) throws CloneNotSupportedException {
		A3 obj1 = new A3(37);
		A3 obj2 = (A3) obj1.clone();
		System.out.println(obj2.getx());
	}
}

class A3 implements Cloneable {
	private int x;

	public A3(int i) {
		x = i;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	public int getx() {
		return x;
	}
}
