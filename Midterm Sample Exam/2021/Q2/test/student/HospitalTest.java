package test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import disease.Hospital;
import util.Patient;
import util.SevereLevel;

public class HospitalTest {

	Hospital hospital;

	@BeforeEach
	public void setup() {
		hospital = new Hospital();
		hospital.admit("Haman", "Kann", "01111", "Hypopnea", true);
		hospital.admit("Char", "Aznable", "022222", "Covid19", false);
		hospital.admit("Amuro", "Rei", "033333", "Covid19", true);
		hospital.admit("Shiro", "Amada", "044444", "Delta", false);
		hospital.admit("Sayla", "Mass", "077777", "Hypopnea", false);
		hospital.admit("Domon", "Kashu", "055555", "Delta", true);
	}

	@Test
	public void testGetCovidPatientsSevereIllness() {
		ArrayList<Patient> cv = hospital.getCovidPatients(SevereLevel.SevereIllness);
		assertEquals(2, cv.size());
		Patient e0 = cv.get(0);
		assertEquals("Char", e0.getFirstname());
		assertEquals("Aznable", e0.getLastname());
		assertEquals("022222", e0.getId());
		assertEquals("Covid19", e0.getDisease().toString());
		assertEquals(false, e0.isVaccinated());

		Patient e1 = cv.get(1);
		assertEquals("Shiro", e1.getFirstname());
		assertEquals("Amada", e1.getLastname());
		assertEquals("044444", e1.getId());
		assertEquals("Delta", e1.getDisease().toString());
		assertEquals(false, e1.isVaccinated());

	}

	@Test
	public void testGetCovidPatientsMildOrLess() {
		ArrayList<Patient> cv = hospital.getCovidPatients(SevereLevel.MildOrLess);
		assertEquals(1, cv.size());
		Patient e0 = cv.get(0);
		assertEquals("Domon", e0.getFirstname());
		assertEquals("Kashu", e0.getLastname());
		assertEquals("055555", e0.getId());
		assertEquals("Delta", e0.getDisease().toString());
		assertEquals(true, e0.isVaccinated());

	}

	@Test
	public void testGetCovidPatientsLess() {
		ArrayList<Patient> cv = hospital.getCovidPatients(SevereLevel.Less);
		assertEquals(1, cv.size());
		Patient e0 = cv.get(0);
		assertEquals("Amuro", e0.getFirstname());
		assertEquals("Rei", e0.getLastname());
		assertEquals("033333", e0.getId());
		assertEquals("Covid19", e0.getDisease().toString());
		assertEquals(true, e0.isVaccinated());

	}

	@Test
	public void testAdmit() {
		ArrayList<Patient> patients = hospital.getPatients();
		assertEquals(6, patients.size());

		Patient e0 = patients.get(0);
		assertEquals("Haman", e0.getFirstname());
		assertEquals("Kann", e0.getLastname());
		assertEquals("01111", e0.getId());
		assertEquals("Hypopnea", e0.getDisease().toString());
		assertEquals(true, e0.isVaccinated());

		Patient e1 = patients.get(1);
		assertEquals("Char", e1.getFirstname());
		assertEquals("Aznable", e1.getLastname());
		assertEquals("022222", e1.getId());
		assertEquals("Covid19", e1.getDisease().toString());
		assertEquals(false, e1.isVaccinated());

		// hospital.admit("Amuro", "Rei", "033333", "Covid19", true);
		Patient e2 = patients.get(2);
		assertEquals("Amuro", e2.getFirstname());
		assertEquals("Rei", e2.getLastname());
		assertEquals("033333", e2.getId());
		assertEquals("Covid19", e2.getDisease().toString());
		assertEquals(true, e2.isVaccinated());

		// hospital.admit("Shiro", "Amada", "044444", "Delta", false);
		Patient e3 = patients.get(3);
		assertEquals("Shiro", e3.getFirstname());
		assertEquals("Amada", e3.getLastname());
		assertEquals("044444", e3.getId());
		assertEquals("Delta", e3.getDisease().toString());
		assertEquals(false, e3.isVaccinated());

		// hospital.admit("Sayla", "Mass", "077777", "Hypopnea", false);
		Patient e4 = patients.get(4);
		assertEquals("Sayla", e4.getFirstname());
		assertEquals("Mass", e4.getLastname());
		assertEquals("077777", e4.getId());
		assertEquals("Hypopnea", e4.getDisease().toString());
		assertEquals(false, e4.isVaccinated());

		// hospital.admit("Domon", "Kashu", "055555", "Delta", true);
		Patient e5 = patients.get(5);
		assertEquals("Domon", e5.getFirstname());
		assertEquals("Kashu", e5.getLastname());
		assertEquals("055555", e5.getId());
		assertEquals("Delta", e5.getDisease().toString());
		assertEquals(true, e5.isVaccinated());

	}

}
