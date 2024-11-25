public class Person2 implements Cloneable {

	private String name;
	private Department department;

	public Person2(String name, Department department) {
		this.name = name;
		this.department = department;
	}

	public static void main(String[] args) {
		// use default clone()
		Person2 p = new Person2("Sam", new Department(1, "HR"));
		try {
			Person2 pClone = (Person2) p.clone();
			System.out.println(pClone.name);
			
			System.out.println(p == pClone);
			System.out.println(p.getClass() == pClone.getClass());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}