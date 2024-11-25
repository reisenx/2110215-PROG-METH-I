package Object_Code;

public class SimpleDiceTest3 {
    public static void main(String[] args) {
        SimpleDice diceA = new SimpleDice(1);
        System.out.println(diceA.faceValue);

        diceA.faceValue =5;
        System.out.println(diceA.faceValue);

        System.out.println(diceA.roll());
        System.out.println(diceA.faceValue);

        //System.out.println(diceA);
    }


}
