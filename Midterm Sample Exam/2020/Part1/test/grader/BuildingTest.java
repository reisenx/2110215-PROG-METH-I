package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Person;
import logic.EnterProfile;
import logic.Building;

class BuildingTest {

	static Person per1 = new Person("Tidus", 10);
	static Person per2 = new Person("Yuna", 102);
	static Person per3 = new Person("Rikku", 10203);
	static Person per4 = new Person("Wakka", 410203);
	static Person per5 = new Person("Seymour", 910203);
	Building building = new Building();;

	void addAll() {
		building = new Building();
		building.addProfile(per1, 36);
		building.addProfile(per2, 38);
		building.addProfile(per3, 35);
		building.addProfile(per4, 39);
		building.addProfile(per5, 41);
	}

	void testAddProfileNormal() {
		Building building2 = new Building();

		building2.addProfile(per1, 36);
		assertEquals(36, building2.getEnterProfileList().get(0).getBodyTemperature());
		assertEquals(per1, building2.getEnterProfileList().get(0).getPerson());
		assertEquals(1, building2.getPopulationCount());
		assertEquals(0, building2.getPotentialInfectedCount());

		building2.addProfile(per2, 35);
		assertEquals(35, building2.getEnterProfileList().get(1).getBodyTemperature());
		assertEquals(per2, building2.getEnterProfileList().get(1).getPerson());
		assertEquals(2, building2.getPopulationCount());
		assertEquals(0, building2.getPotentialInfectedCount());
	}

	@Test
	void testAddProfileFever() {
		Building building2 = new Building();

		building2.addProfile(per1, 37);
		assertEquals(1, building2.getPopulationCount());
		assertEquals(1, building2.getPotentialInfectedCount());

		building2.addProfile(per2, 35);
		assertEquals(35, building2.getEnterProfileList().get(1).getBodyTemperature());
		assertEquals(per2, building2.getEnterProfileList().get(1).getPerson());
		assertEquals(2, building2.getPopulationCount());
		assertEquals(1, building2.getPotentialInfectedCount());

		building2.addProfile(per3, 41);
		assertEquals(3, building2.getPopulationCount());
		assertEquals(2, building2.getPotentialInfectedCount());

		building2.addProfile(per4, 32);
		assertEquals(35, building2.getEnterProfileList().get(3).getBodyTemperature());
		assertEquals(per4, building2.getEnterProfileList().get(3).getPerson());
		assertEquals(4, building2.getPopulationCount());
		assertEquals(2, building2.getPotentialInfectedCount());
	}

	@Test
	void testAddProfileExistedNormal() {
		Building building2 = new Building();

		building2.addProfile(per1, 36);
		building2.addProfile(per2, 36);
		building2.addProfile(per3, 35);

		building2.addProfile(per2, 35);
		assertEquals(35, building2.getEnterProfileList().get(1).getBodyTemperature());
		assertEquals(per3, building2.getEnterProfileList().get(1).getPerson());
		assertEquals(35, building2.getEnterProfileList().get(2).getBodyTemperature());
		assertEquals(per2, building2.getEnterProfileList().get(2).getPerson());
		assertEquals(3, building2.getPopulationCount());
		assertEquals(0, building2.getPotentialInfectedCount());
	}

	@Test
	void testAddProfileExistedFever() {
		Building building2 = new Building();

		building2.addProfile(per1, 36);
		assertEquals(1, building2.getPopulationCount());
		assertEquals(0, building2.getPotentialInfectedCount());

		building2.addProfile(per2, 38);
		assertEquals(38, building2.getEnterProfileList().get(1).getBodyTemperature());
		assertEquals(per2, building2.getEnterProfileList().get(1).getPerson());
		assertEquals(2, building2.getPopulationCount());
		assertEquals(1, building2.getPotentialInfectedCount());

		building2.addProfile(per3, 37);
		assertEquals(3, building2.getPopulationCount());
		assertEquals(2, building2.getPotentialInfectedCount());

		building2.addProfile(per4, 50);
		assertEquals(42, building2.getEnterProfileList().get(3).getBodyTemperature());
		assertEquals(per4, building2.getEnterProfileList().get(3).getPerson());
		assertEquals(4, building2.getPopulationCount());
		assertEquals(3, building2.getPotentialInfectedCount());

		building2.addProfile(per1, 47);
		assertEquals(42, building2.getEnterProfileList().get(3).getBodyTemperature());
		assertEquals(per1, building2.getEnterProfileList().get(3).getPerson());
		assertEquals(4, building2.getPopulationCount());
		assertEquals(4, building2.getPotentialInfectedCount());

		building2.addProfile(per2, 35);
		assertEquals(35, building2.getEnterProfileList().get(3).getBodyTemperature());
		assertEquals(per2, building2.getEnterProfileList().get(3).getPerson());
		assertEquals(4, building2.getPopulationCount());
		assertEquals(3, building2.getPotentialInfectedCount());

	}

	@Test
	void testRemoveProfileNoFever() {

		Building building2 = new Building();

		building2.addProfile(per1, 36);
		building2.addProfile(per2, 38);
		building2.addProfile(per3, 35);
		building2.addProfile(per4, 42);
		assertEquals(4, building2.getPopulationCount());
		assertEquals(2, building2.getPotentialInfectedCount());

		building2.removeProfile(0);
		assertEquals(38, building2.getEnterProfileList().get(0).getBodyTemperature());
		assertEquals(per2, building2.getEnterProfileList().get(0).getPerson());
		assertEquals(35, building2.getEnterProfileList().get(1).getBodyTemperature());
		assertEquals(per3, building2.getEnterProfileList().get(1).getPerson());
		assertEquals(42, building2.getEnterProfileList().get(2).getBodyTemperature());
		assertEquals(per4, building2.getEnterProfileList().get(2).getPerson());
		assertEquals(3, building2.getPopulationCount());
		assertEquals(2, building2.getPotentialInfectedCount());

		building2.removeProfile(1);
		assertEquals(38, building2.getEnterProfileList().get(0).getBodyTemperature());
		assertEquals(per2, building2.getEnterProfileList().get(0).getPerson());
		assertEquals(42, building2.getEnterProfileList().get(1).getBodyTemperature());
		assertEquals(per4, building2.getEnterProfileList().get(1).getPerson());
		assertEquals(2, building2.getPopulationCount());
		assertEquals(2, building2.getPotentialInfectedCount());

	}

	@Test
	void testRemoveProfileWithFever() {
		Building building2 = new Building();

		building2.addProfile(per1, 36);
		building2.addProfile(per2, 38);
		building2.addProfile(per3, 35);
		building2.addProfile(per4, 42);
		assertEquals(4, building2.getPopulationCount());
		assertEquals(2, building2.getPotentialInfectedCount());

		building2.removeProfile(1);
		assertEquals(36, building2.getEnterProfileList().get(0).getBodyTemperature());
		assertEquals(per1, building2.getEnterProfileList().get(0).getPerson());
		assertEquals(35, building2.getEnterProfileList().get(1).getBodyTemperature());
		assertEquals(per3, building2.getEnterProfileList().get(1).getPerson());
		assertEquals(42, building2.getEnterProfileList().get(2).getBodyTemperature());
		assertEquals(per4, building2.getEnterProfileList().get(2).getPerson());
		assertEquals(3, building2.getPopulationCount());
		assertEquals(1, building2.getPotentialInfectedCount());

		building2.removeProfile(2);
		assertEquals(36, building2.getEnterProfileList().get(0).getBodyTemperature());
		assertEquals(per1, building2.getEnterProfileList().get(0).getPerson());
		assertEquals(35, building2.getEnterProfileList().get(1).getBodyTemperature());
		assertEquals(per3, building2.getEnterProfileList().get(1).getPerson());
		assertEquals(2, building2.getPopulationCount());
		assertEquals(0, building2.getPotentialInfectedCount());
	
	}
	
	
	@Test
	void testGetPopulationCount() {
		addAll();
		assertEquals(5, building.getPopulationCount());

	}

	@Test
	void testGetPotentialInfectedCount() {
		addAll();
		assertEquals(3, building.getPotentialInfectedCount());

	}

}
