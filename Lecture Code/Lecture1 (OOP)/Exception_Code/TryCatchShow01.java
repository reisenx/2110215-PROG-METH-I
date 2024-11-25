package Exception_Code;

public class TryCatchShow01 {
	public static void main(String[] args) {
		int s[] = new int[2];

		try {
			for (int i = 0; i < 3; ++i) {
				s[i] = 1/i;
				System.out.println(s[i]);
			}
		} catch (ArrayIndexOutOfBoundsException arrE) {
			System.out.println(arrE.toString());
		} catch (ArithmeticException aE) {
			System.out.println(aE.getMessage());
			//System.out.println(aE.toString());
			//aE.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("End");
	}
}
