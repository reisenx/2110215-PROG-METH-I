package Object_Code;
public class SimpleDiceTest2 {

	public static void main(String[] args) {
		SimpleDice diceA = new SimpleDice(1);
		SimpleDice diceB;
		diceB = diceA;
		diceB.faceValue = 5;
		System.out.println(diceA.faceValue);
		//System.out.println(diceA);
	}

}
