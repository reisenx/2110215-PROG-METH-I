public class Person4 implements Cloneable {

	private String name;
	private Department department;

	public Person4(String name, Department department) {
		this.name = name;
		this.department = department;
	}

	@Override
	public Person4 clone() {
		// deep clone
		try {
			Person4 p = (Person4) super.clone();
			p.department = (Department) this.department.clone();
			return p;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) {
		Person4 p = new Person4("Sam", new Department(1, "HR"));
		Person4 pClone = (Person4) p.clone();
		System.out.println(pClone.name);
		System.out.println(pClone.department.getName()); 
		
		System.out.println();
		pClone.department.setName("Finance");
		System.out.println(p.department.getName()); 
		System.out.println(pClone.department.getName()); 
	}
}