//********************************************************************
//  Die.java       Author: Lewis/Loftus
//
//  Represents one die (singular of dice) with faces showing values
//  between 1 and 6.
//********************************************************************

package Object_Code;
public class Dice {
	private static final int MAX = 6; // maximum face value

	private int faceValue; // current value showing on the die

	// -----------------------------------------------------------------
	// Constructor: Sets the initial face value.
	// -----------------------------------------------------------------
	public Dice() {
		faceValue = 1;
	}
	
	public Dice(int faceValue) {
		this.faceValue = faceValue;
	}

	// -----------------------------------------------------------------
	// Rolls the die and returns the result.
	// -----------------------------------------------------------------
	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;

		return faceValue;
	}

	// -----------------------------------------------------------------
	// Face value mutator.
	// -----------------------------------------------------------------
	public void setFaceValue(int value) {
		faceValue = value;
	}

	// -----------------------------------------------------------------
	// Face value accessor.
	// -----------------------------------------------------------------
	public int getFaceValue() {
		return faceValue;
	}

	// -----------------------------------------------------------------
	// Returns a string representation of this die.
	// -----------------------------------------------------------------
	public String toString() {
		String result = Integer.toString(faceValue);

		return result;
	}
	
	public static void main(String[] args) {
		Dice diceA = new Dice(1);
		Dice diceB = new Dice(5);
	}
}
