public class TestSuper {
	public static void main(String[] args) {
		Baby b1 = new Baby("Paula");
		GrandParent g = new Baby("Pop"); // upcasting (automatically)
//		Baby b2 = (Baby) new GrandParent(0); // downcasting (manually) – may have problem	
	}
}

class GrandParent {
	public GrandParent(int a) {
		System.out.println("Grand parent's age: " + a);
	}
}

class Parent extends GrandParent {
	public Parent() {
		super(100);
		System.out.println("Constructor Parent");
	}
}

class Baby extends Parent {
	public Baby(String n) {
		super();
		System.out.println("Baby name: " + n);
	}
}
