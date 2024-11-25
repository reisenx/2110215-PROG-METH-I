package Object_Code;

import java.util.Objects;

public class SimpleDice3 {
	final static int MAX = 6;
	private int faceValue;

	public SimpleDice3(int faceValue) {
		// faceValue = val
		this.faceValue = faceValue;
	}

	public SimpleDice3() {
		this.faceValue = this.roll();
	}

	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;
		return faceValue;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int v) {
		if (v < 1)
			faceValue = 1;
		else if (v > MAX)
			faceValue = MAX;
		else
			faceValue = v;
	}

	/*@Override
	public String toString() {
		return "SimpleDice3 [faceValue -> " + faceValue + "]";
	}*/

	/*@Override
	public int hashCode() {
		return Objects.hash(faceValue);
	}*/

	
	/*@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SimpleDice3 that)) return false;
		return getFaceValue() == that.getFaceValue();
	}*/

/*@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleDice3 other = (SimpleDice3) obj;
		return faceValue == other.faceValue;
	}*/
	
	
	
	public static void main(String[] args) {
		SimpleDice3 s = new SimpleDice3();
		s.faceValue =5; 
		System.out.println(s.faceValue);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(faceValue);
	}

	
	
	
	
	

}
