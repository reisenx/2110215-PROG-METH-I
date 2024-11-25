package Student;
public class StudentTest1 {
	public static void main(String[] args) {
		Student s1 = new UndergraduateStudent("Toey");
		Student s2 = new GraduateStudent("Nat");
		Student s3 = new Student("Jump");

		s1.printName();
		s2.printName();
		s3.printName();
	}
}
