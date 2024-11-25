public class Person3 implements Cloneable {

	private String name;
	private Department department;

	public Person3(String name, Department department) {
		this.name = name;
		this.department = department;
	}

	@Override
	public Person3 clone() {
		// shallow clone
		try {
			return (Person3) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) {
		Person3 p = new Person3("Sam", new Department(1, "HR"));
		Person3 pClone = (Person3) p.clone();
		System.out.println(pClone.name);
		System.out.println(pClone.department.getName()); 
		
		pClone.department.setName("Finance");
		System.out.println(p.department.getName()); 
		System.out.println(pClone.department.getName()); 
	}
}