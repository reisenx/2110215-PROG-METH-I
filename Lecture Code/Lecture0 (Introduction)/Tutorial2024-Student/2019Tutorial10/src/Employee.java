
public class Employee {
	public static String company = "ISE";
	public String name;
	private int salary;
	public int id;

	public Employee() {
		this("nameless", 15000, 1);
	}

	public Employee(Employee x) {
		name = new String(x.name);
		salary = x.salary;
		id = x.id;
	}

	public Employee(String name, int salary, int id) {
		super();
		this.name = name;
		setSalary(salary);
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public boolean setSalary(int salary) {
		if (salary < 0) {
			return false;
		}

		this.salary = salary;
		return true;

	}

	public String toString() {
		return "Name: " + name + ", ID:" + id + ", company: " + company;
	}

	public boolean hasHigherSalary(Employee anotherEmployee) {
		return this.getSalary() > anotherEmployee.getSalary();
	}

	public void promote(int promotion) {
		setSalary(getSalary() + promotion);
	}

}
