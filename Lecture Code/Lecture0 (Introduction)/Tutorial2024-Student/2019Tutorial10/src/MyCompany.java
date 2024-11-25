
public class MyCompany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee1 = new Employee();
		Employee employee2 = new Employee("emp2", 30000, 2);

		System.out.println(employee1);
		System.out.println(employee2);

		employee1.name = "emp1";
		employee1.id = 1;
		employee1.setSalary(60000);

		if (employee1.hasHigherSalary(employee2)) {
			System.out.println("Employee1 has higher salary.");
		} else if (employee2.hasHigherSalary(employee1)) {
			System.out.println("Employee1 has higher salary.");
		} else {
			System.out.println("Employee1 and 2 has equal salary.");
		}

		Employee employee3 = new Employee(employee1);
		employee3.promote(50000);

		if (employee2.hasHigherSalary(employee3)) {
			System.out.println("Employee2 has higher salary.");
		} else if (employee3.hasHigherSalary(employee2)) {
			System.out.println("Employee3 has higher salary.");
		} else {
			System.out.println("Employee2 and 3 has equal salary.");
		}

		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);

	}

}
