public class Person1 {
	private String name;
	private Department department;

	public Person1(String name, Department department) {
		this.name = name;
		this.department = department;
	}

	public static void main(String[] args) {
		Person1 p = new Person1("Sam", new Department(1, "HR"));
		try {
			Person1 pClone = (Person1) p.clone();
			System.out.println(pClone.name);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
