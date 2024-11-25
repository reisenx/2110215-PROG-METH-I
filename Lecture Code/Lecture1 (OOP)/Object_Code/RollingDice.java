package Object_Code;
//********************************************************************
//  RollingDice.java       Author: Lewis/Loftus
//
//  Demonstrates the creation and use of a user-defined class.
//********************************************************************

public class RollingDice {
	// -----------------------------------------------------------------
	// Creates two Die objects and rolls them several times.
	// -----------------------------------------------------------------
	public static void main(String[] args) {
		Dice die1, die2;
		int sum;

		die1 = new Dice();
		die2 = new Dice();

		die1.roll();
		die2.roll();
		System.out.println("Die One: " + die1 + ", Die Two: " + die2);

		die1.roll();
		die2.setFaceValue(4);
		System.out.println("Die One: " + die1 + ", Die Two: " + die2);

		sum = die1.getFaceValue() + die2.getFaceValue();
		System.out.println("Sum: " + sum);

		sum = die1.roll() + die2.roll();
		System.out.println("Die One: " + die1 + ", Die Two: " + die2);
		System.out.println("New sum: " + sum);
	}
}
