package Object_Code;

public class UseSimpleDice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDice3 s = new SimpleDice3();
		s.faceValue =5; 
		System.out.println(s.faceValue);
		
		SimpleDice3 a = new SimpleDice3();
		a.setFaceValue(1);
		
		SimpleDice3 b = new SimpleDice3();
		b.setFaceValue(1);
		
		System.out.println(a.getFaceValue());
		System.out.println(b.getFaceValue());
		
		System.out.println(a.equals(b));
		
	}

}
