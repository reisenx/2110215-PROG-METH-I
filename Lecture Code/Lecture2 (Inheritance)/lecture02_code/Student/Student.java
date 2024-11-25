package Student;
import java.util.Arrays;

public class Student {

	protected final static int NUM_OF_TESTS = 3;

	protected String name;
	protected int[] test;
	protected String courseGrade;

	public Student() {
		this("No Name");
	}

	public Student(String studentName) {
		name = studentName;
		test = new int[NUM_OF_TESTS];
		courseGrade = "****";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTestScore(int testNumber) {
		return (testNumber <= NUM_OF_TESTS) ? test[testNumber - 1] : test[0];
	}

	public void setTestScore(int testNumber, int testScore) {
		test[testNumber - 1] = testScore;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	public void printName() {
		System.out.println("Student");
	}

	public static void printA() {
		System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
	}
	
	public String toString() {
		return "[name=" + name + ", test=" + Arrays.toString(test) + "]";
	}

}
