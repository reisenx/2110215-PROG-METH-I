package Exception_Code;

public class TestFinally {
	public static void main(String[] args) {
		functionWithFinally();
	}

	public static void functionWithFinally() {
		int result = 0;
		for (int i = 0; i < 4; ++i) {
			try {
				result = 10 / i;
				System.out.println("i=" + i + " and result=" + result);
				if (i == 2)
					break;
			} catch (ArithmeticException ae) {
				System.out.println("catch");
				return;
				//System.exit(-1);
			} finally {
				System.out.println("finally");
			}
			System.out.println("End Step\n");
		}
		System.out.println("End Main Loop");
	}
}
