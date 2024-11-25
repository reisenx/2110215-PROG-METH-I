package Object_Code;
public class SimpleDice2 {
	final static int MAX = 6;
	int faceValue;

	public SimpleDice2(int faceValue) {
		// faceValue = val
		this.faceValue = faceValue;
	}

	public SimpleDice2() {
		this.faceValue = this.roll();
	}

	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;
		return faceValue;
	}
}
