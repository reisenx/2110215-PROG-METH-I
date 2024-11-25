package logic;

public class OfficeWorker extends Employee{

	private String department;


	public OfficeWorker(String name, int id,String department) {
		super(name, id, 30);
		setDepartment(department);
	}
	public int computeSalary(){//ไปดูในBackEndAPI
		return BackEndAPI.calculateMonthlySalary(getBaseSalary(),getBonus(),20);
	}
	public String getDescription(){
		return BackEndAPI.getOfficeWorkerDescription(getId(),getName(),getDepartment(),getBonus());
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
