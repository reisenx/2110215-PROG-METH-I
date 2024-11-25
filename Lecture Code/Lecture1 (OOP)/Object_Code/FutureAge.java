package Object_Code;
import java.io.*;

public class FutureAge {
	public static void main(String[] args) throws IOException {
		System.out.print("Enter your name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String userName = br.readLine();
		System.out.println("Hi " + userName + "\n");

		System.out.print("How old are you?: ");
		int age = Integer.parseInt(br.readLine());
		System.out.println("For the next 5 years,  you will be " + (age + 5)
				+ " years old.");
	}
}
