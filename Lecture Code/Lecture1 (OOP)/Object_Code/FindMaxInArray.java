
package Object_Code;
import javax.swing.JOptionPane;

public class FindMaxInArray {

	final static int SIZE = 3;

	public static int findMax(int data[]) {
		int maxData = data[0];
		for (int i = 1; i < data.length; ++i) {
			if (maxData < data[i])
				maxData = data[i];
		}

		return maxData;
	}

	public static void main(String[] args) {
		int data[] = new int[SIZE];

		// user input
		JOptionPane.showMessageDialog(null, "Please enter " + SIZE + " integers");
		String str;
		for (int i = 0; i < data.length; ++i) {
			int idx = i + 1;
			str = JOptionPane.showInputDialog(null, "Please enter integer" + idx + ": ");
			data[i] = Integer.parseInt(str);
		}

		// find max
		int maxData = findMax(data);

		// output
		JOptionPane.showMessageDialog(null, "The maximum number is " + maxData + ".");
	}

}
