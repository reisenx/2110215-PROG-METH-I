package application;

import java.util.ArrayList;
import java.util.Scanner;

import logic.Building;
import logic.EnterProfile;
import logic.Person;

public class CVChecker {
	private static ArrayList<Person> personList;
	private static Building building;
	
	private static boolean isEnd = false;

	private static Scanner kb =  new Scanner(System.in);

	public static void main(String[] args) {
		initializeData();
		
		while(!isEnd) {
		System.out.println("===========CV Checker===========");
		System.out.println("Population = " + building.getPopulationCount() + " : Potential Infected = " + building.getPotentialInfectedCount());
		System.out.println("================================");
		System.out.println("What do you want to do?");
		System.out.println("[1] Create New Person");
		System.out.println("[2] List All People");
		System.out.println("[3] Person Enter the Building");
		System.out.println("[4] List All Enter Profile");
		System.out.println("[5] Quit");
		System.out.print("> Please select your option:\t");
		
		int command = kb.nextInt();
		
		kb.nextLine();
		System.out.println("=========================================");
		
		switch(command) {
		case 1:
			handleAddPerson();
			break;
		case 2:
			showPeopleList();
			break;
		case 3:
			handleCreateNewEnterProfile();
			break;
		case 4:
			showEnterProfileList();
			break;
		case 5:
			isEnd = true;
			break;
		default:
			System.out.println("Invalid Command.");
		}
		System.out.println("=========================================\n");
		}
			
	}
	
	public static void addProfileToBuilding( int index, int temper) {
		building.addProfile(personList.get(index), temper);
	}

	public static boolean addNewPerson(String name, int id) {
		if (isPersonExisted(id)) {
			return false;
		}
		personList.add(new Person(name, id));
		return true;
	}
	

	public static boolean isPersonExisted(int id) {
		for (Person person : personList) {
			if (person.getID() == id) {
				return true;
			}
		}
		return false;
	}

	private static void handleAddPerson() {
		System.out.println("> Please enter person name:");
		String name = kb.nextLine();
		System.out.println("> Please enter person id:");
		int id = kb.nextInt();
		boolean isSuccess = addNewPerson(name, id);
		if(isSuccess) {
			Person person = personList.get(personList.size()-1);
			System.out.println(person.getName() + " (" + person.getID() + ") has been added to person list successfully!");
		} else {
			System.out.println("Error person name [" + name + "] already exists or person name is Blank!");
		}		
	}

	private static void handleCreateNewEnterProfile() {
		showPeopleList();
		//Building building = new Building();
		boolean isEnd = false;
		while (!isEnd) {
			System.out.println("> Enter person's ID to enter the building / Enter blank to go back to menu.");
			String cmd = kb.nextLine();
			if (cmd.isBlank()) {
				isEnd = true;
				continue;
			}
//			System.out.println(cmd.strip());
			int id = -1;
			int index = -1;
			try {
				id = Integer.parseInt(cmd.strip());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input");
			} finally {
				for (int i = 0 ; i < personList.size() ; i++) {
					if(personList.get(i).getID() == id) {
						index = i;
					}
				}				
				if(index >= personList.size() || index < 0){
//					System.out.println(index);
					System.out.println("Error: Invalid ID!");
				} 
				else {
					System.out.println("> Please enter of this person temperature");		
					int temper = kb.nextInt();
					kb.nextLine();
					addProfileToBuilding( index, temper);
					System.out.println("A Person has enter this buidling");
				}
			}
		}
		//building.addProfile(person, temputure)
		//buildingList.add(building);								
		
	}

	private static void showPeopleList() {
		int n = 0;
		for(Person person: personList) {
			System.out.println("[ID: " + person.getID() + "] " + person.getName() );
			n++;
		}
		
	}

		
	private static void showEnterProfileList() {
			//System.out.println("Population limit " + building.getPopulationLimit());			
			ArrayList<EnterProfile> personListInOrder = building.getEnterProfileList();
			for (EnterProfile enterProfile : personListInOrder) {
				System.out.println(" -- " + enterProfile.getPerson().getName() + " --- " + (enterProfile.hasFever()?"Positive":"Negative"));
			}
		
	}

	public static Building getBuilding(){
		return building;
	}
	
	/*
	public static void addBlankOrder() {
		enterProfileList.add(new Order());
	}
	*/
	
	public static void initializeData() {
		personList = new ArrayList<Person>();
		building = new Building();
		personList.add(new Person("Ace", 1));
		personList.add(new Person("Deuce", 2));
		personList.add(new Person("Trey", 3));
		personList.add(new Person("Cater", 4));
	}
	
}