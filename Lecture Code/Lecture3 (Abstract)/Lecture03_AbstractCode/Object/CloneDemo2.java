package Object;

public class CloneDemo2 {
	public static void main(String args[]) {
		A2 obj1 = new A2(37);
		A2 obj2 = (A2) obj1.clone();
	}
}

class A2{
	private int x;

	public A2(int i) {
		x = i;
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
