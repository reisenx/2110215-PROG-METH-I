
public class CompoundAssignment {
	public static void main(String[] args) {
		int a = 1, b = 5;
		double d = 2.5;
		a += 2;   // a = a+2 ; -> a ==3
		b += a;   // b = b + a; -> b == 8 
		d += 2.3;  //d = d + 2.3; -> d == 4.8  
		String s = "Hello";
		s += " World!";   // s = s+ " World!"; -> s ==  "Hello World!"

		System.out.println(a);
		System.out.println(b);
		System.out.println(d);
		System.out.println(s);

		// complex expression
		int x = 2, y = 2;
		y *= x + y; // y * (x+y)  ->  y == 2*4 
		System.out.println(y);

		// right associative
		int x2, y2;
		x2 = y2 = 10;
		System.out.println(x2 + "," + y2);

		x2 = 5 * (y2 = 6);
		//                       x2 = 5*y2 = 6;                        //error
		System.out.println(x2 + "," + y2);

		int y3 = 2;
		int z3 = 3;
		int x3 = y3 += z3 *= 2;  //-> z3 == 6, y3 == 8, x3 == 8
		System.out.println(x3);

	}
}
