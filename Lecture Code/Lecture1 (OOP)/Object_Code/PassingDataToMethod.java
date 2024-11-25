package Object_Code;
import java.awt.Point;

public class PassingDataToMethod {
	public static void main(String[] args) {
		int v = 2;
		Point p = new Point(2, 2);

		passByValueSetToTen(v);
		passByReferenceSetToTen(p);

		System.out.println("v=" + v);
		System.out.println(p.toString());
	}

	public static void passByValueSetToTen(int a) {
		a = 10;
	}

	public static void passByReferenceSetToTen(Point a) {
		a.x = 10;
		a.y = 10;
	}
}
