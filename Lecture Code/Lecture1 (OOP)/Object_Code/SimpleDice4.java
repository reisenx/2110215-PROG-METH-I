package Object_Code;
public class SimpleDice4 {
	final static int MAX = 6;
	private int faceValue;

	public SimpleDice4(int faceValue) {
		// faceValue = val
		this.faceValue = faceValue;
	}

	public SimpleDice4() {
		this.faceValue = this.roll();
	}

	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;
		return faceValue;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}

	@Override
	public String toString() {
		return "SimpleDice4 [faceValue=" + faceValue + "]";
	}

	public boolean equals(Object o) {
		Dice otherDice = (Dice) o;
		if (this.getFaceValue() == otherDice.getFaceValue())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		SimpleDice4 a = new SimpleDice4();
		SimpleDice4 b = new SimpleDice4();
		//return a.equals(b);

	}
}
