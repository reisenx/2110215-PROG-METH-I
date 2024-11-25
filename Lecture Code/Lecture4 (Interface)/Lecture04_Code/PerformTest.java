
public class PerformTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perform mul = (x, y) -> x * y;
		Perform add = (x, y) -> x + y;
		System.out.println(mul.compute(2, 5));
		System.out.println(add.compute(2, 5));
	}

}
