package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Database;
import logic.Janitor;
import logic.OfficeWorker;

class DatabaseTest {
	
	Database d;
	
	@BeforeEach
	void setUp(){
		d = new Database();
		
		//Initialize Employee database here
		d.addEmployee(new OfficeWorker("Rose",1,"CEO"));
		d.addEmployee(new OfficeWorker("Oleana",2,"Secretary"));
		d.addEmployee(new Janitor("Ball Guy",3,"Wyndon Stadium"));
	
		d.getEmployeeByIndex(1).setBonus(550);
	}

	@Test
	void testGetAllEmployeeDescriptions() {
		
		String[] target = {
		"1 Rose [Office Worker in CEO Department] [Bonus: 0$]",
		"2 Oleana [Office Worker in Secretary Department] [Bonus: 550$]",
		"3 Ball Guy [Janitor at Wyndon Stadium] [Bonus: 0$]"};
		
		ArrayList<String> result = d.getAllEmployeeDescriptions();
		
		for(int i=0;i<3;i++) {
			assertEquals(target[i],result.get(i));
		}
		
	}

	@Test
	void testCalculateAllSalary() {
		assertEquals(13750,d.calculateAllSalary());
	}

}
