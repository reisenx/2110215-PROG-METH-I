package logic;

public class BackEndAPI {
	public static int calculateMonthlySalary(int baseSalary,int bonus, int day) {
		return baseSalary*8*day+bonus;
	}
	
	public static String getOfficeWorkerDescription(int id,String name,String department,int bonus) {
		return id+" "+name+" [Office Worker in "+department+" Department] [Bonus: "+bonus+"$]";
	}
	
	public static String getJanitorDescription(int id,String name,String area,int bonus) {
		return id+" "+name+" [Janitor at "+area+"] [Bonus: "+bonus+"$]";
	}
}
