package Object_Code;
public class SimpleDice {
	final static int MAX = 6;
	int faceValue;

	public SimpleDice(int faceValue) {
		// faceValue = val
		this.faceValue = faceValue;
	}

	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;
		return faceValue;
	}

	public static void main(String[] args) {
		SimpleDice diceA = new SimpleDice(1);
		System.out.println(diceA.MAX);
		System.out.println(SimpleDice.MAX);

		System.out.println(Math.PI);
		System.out.println(Math.random());
		System.out.println(Math.floor(1.2));
	}
}
