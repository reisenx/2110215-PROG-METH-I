package main;

import java.util.ArrayList;
import java.util.Scanner;

import logic.Database;
import logic.Employee;
import logic.Janitor;
import logic.OfficeWorker;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static Database database = new Database();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeEmployeeData();
		try {
			System.out.println("Macro Cosmos Employee Database v.1.0");
			System.out.println("================================");
			while(true) {
			System.out.println("What would you like to do today?");
			System.out.println("1. Add Employee");
			System.out.println("2. Remove Employee");
			System.out.println("3. View Employee List");
			System.out.println("4. Manage Employee Bonus");
			System.out.println("5. Calculate Total Salary");
			System.out.print("> ");
			String choice = sc.nextLine();
			System.out.println("================================");
			switch(choice) {
			case "1":
				addingEmployeeMenu();
				break;
			case "2" :
				removeEmployeeMenu();
				break;
			case "3" :
				System.out.println("List of all Employee.");
				listAllEmployee();
				break;
			case "4" :
				bonusManagementMenu();
				break;
			case "5" :
				System.out.println("The total salary of the company for this month is");
				System.out.println(database.calculateAllSalary()+"$");
				break;
			default:
				System.out.println("Error, please re-run the program.");
				return;
			}
			System.out.println("================================");
			}
		}catch(Exception e) {
			System.out.println("Error, please re-run the program.");
			return;
		}
	}
	
	public static void addingEmployeeMenu() {
		System.out.println("Adding new Employee Entry.");
		System.out.println("Please input the name.");
		System.out.print("> ");
		String name = sc.nextLine();
		System.out.println("Please input the id.");
		System.out.print("> ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Which type of the employee are they?");
		System.out.println("1) Office Worker");
		System.out.println("2) Janitor");
		System.out.print("> ");
		String choice = sc.nextLine();
		System.out.println("================================");
		Employee e;
		switch(choice) {
		case "1":
			System.out.println("Please input the department.");
			System.out.print("> ");
			String dept = sc.nextLine();
			e = new OfficeWorker(name,id,dept);
			break;
		case "2" :
			System.out.println("Please input the working area.");
			System.out.print("> ");
			String area = sc.nextLine();
			e = new Janitor(name,id,area);
			break;
		default:
			System.out.println("Error, please re-run the program.");
			return;
		}
		if(database.addEmployee(e)) {
			System.out.println(e.getDescription()+" has been added to the employee database!");
		}else {
			System.out.println("Error Adding Employee ID."+id+"\nEmployee Record with the same ID already exists.");
		}
		
	}
	
	public static void removeEmployeeMenu() {
		System.out.println("Removing Employee Entry.");
		System.out.println("Please input the id of the employee to be removed.");
		System.out.print("> ");
		int id = Integer.parseInt(sc.nextLine());
		if(database.removeEmployeeById(id)) {
			System.out.println("Removing Employee ID."+id+" Successfully.");
		}else {
			System.out.println("Error Removing Employee ID."+id+"\nEmployee Record does not exist.");
		}
	}
	
	public static void bonusManagementMenu() {
		System.out.println("Employee Bonus Management.");
		System.out.println("Which employee bonus should be tweaked?");
		listAllEmployee();
		System.out.println("===================");
		System.out.print("> ");
		if(database.getTotalEmployeeCount()<=0) {
			System.out.println("There are no employee records.\nReturning back to the main menu.");
			return;
		}
		int id = Integer.parseInt(sc.nextLine());
		Employee e = database.getEmployeeByIndex(id-1);
		bonusTweakMenu(e);
	}
	
	public static void bonusTweakMenu(Employee e) {
		System.out.println(e.getId()+" "+e.getName());
		System.out.println("Base Salary: "+e.getBaseSalary()+"$/hrs");
		System.out.println("Current Bonus "+e.getBonus()+"$");
		System.out.println("===================");
		System.out.println("How much the bonus be changed?\n> ");
		int amount = Integer.parseInt(sc.nextLine());
		e.setBonus(e.getBonus()+amount);
		System.out.println("Bonus of the employee No."+e.getId()+" "+e.getName()+" has been changed to "+e.getBonus()+"$");
	}
	
	public static void listAllEmployee(){
		ArrayList<String> employeedesc = database.getAllEmployeeDescriptions();
		if(employeedesc.size()==0) {
			System.out.println("-The Employee Record is Empty-");
		}
		for(int i=0;i<employeedesc.size();i++) {
			System.out.println((i+1)+") "+employeedesc.get(i));
		}
	}
	
	public static void initializeEmployeeData() {
		database.addEmployee(new OfficeWorker("Mateor",11034,"MC Insurance"));
		database.addEmployee(new OfficeWorker("Kevin",11035,"MC Air"));
		database.addEmployee(new Janitor("Jane",231,"Hotel Ionia Main Entrance"));
		database.addEmployee(new Janitor("Carla",232,"Hammerlocke Stadium Corridor"));
	}
	

}
