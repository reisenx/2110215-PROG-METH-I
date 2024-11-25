package Student;
public class UndergraduateStudent extends Student {
	public UndergraduateStudent(String studentName) {
		super(studentName);
	}

	public void computeCourseGrade() {
		int total = 0;
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			total += test[i];
		}

		if (total / NUM_OF_TESTS >= 70) {
			courseGrade = "Pass";
		} else {
			courseGrade = "Not Pass";
		}
	}

	@Override
	public void printName() {
		System.out.println("UndergraduateStudent [" + name + "]");
	}

	@Override
	public String toString() {
		return "UndergraduateStudent " + super.toString() + " / [courseGrade="
				+ courseGrade + "]";
	}
}
