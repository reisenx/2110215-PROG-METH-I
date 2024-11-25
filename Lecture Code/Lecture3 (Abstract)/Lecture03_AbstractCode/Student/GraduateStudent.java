package Student;

public class GraduateStudent extends Student {
	String advisorName;

	public GraduateStudent(String studentName) {
		super(studentName);
		this.advisorName = "No Advisor";
	}

	public GraduateStudent(String studentName, String advisorName) {
		super(studentName);
		this.advisorName = advisorName;
	}

	public String getAdvisorName() {
		return advisorName;
	}

	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
	}

	public void computeCourseGrade() {
		int total = 0;
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			total += test[i];
		}

		if (total / NUM_OF_TESTS >= 80) {
			courseGrade = "Pass";
		} else {
			courseGrade = "Not Pass";
		}
	}

	@Override
	public void printName() {
		System.out.println("GraduateStudent [" + name + "]");
	}

	@Override
	public String toString() {
		return "GraduateStudent " + super.toString() + " / [advisorName="
				+ advisorName + ", courseGrade=" + courseGrade + "]";
	}

}
