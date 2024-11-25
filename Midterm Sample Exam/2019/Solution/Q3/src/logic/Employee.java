package logic;

public abstract class Employee {

	protected String name;
	protected int id,baseSalary,bonus;

	public Employee(String name, int id, int baseSalary) {
		setName(name);
		setId(id);
		setBaseSalary(baseSalary);
		setBonus(0);
	}
	public abstract int computeSalary();
	public abstract String getDescription();

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = Math.max(0,baseSalary);
	}
	public void setBonus(int bonus) {
		this.bonus = Math.max(0,bonus);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBaseSalary() {
		return baseSalary;
	}



	public int getBonus() {
		return bonus;
	}


}
