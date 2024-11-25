
public class TypeConversionDemo2 {

	public static void main(String[] args) {
		int i, j, k;
		double d1 = 0.5, d2 = 0.5, d3, d4;

		
		i = (int)(d1 + 8.735f);    //9
		
		j = (int)(d1 + d2);    // cast the result  //1
		
		k= (int)d1 + (int)d2; // cast each one  //0 
		
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		System.out.println("k = " + k);
		

		d3 = i - j;     //8.0
		d4 = (int)(i - j);      //8.0
		System.out.println("d3= " + d3);
		System.out.println("d4= " + d4);
		
		short s1;
		s1 = (short)2000;
		System.out.println(s1);

		short s2;
		s2 = (short)327674;
		System.out.println(s2);

	}

}
