package disease;

import util.*;

import java.util.ArrayList;


public class Hospital {
	private ArrayList<Patient> patients;


	public Hospital() {
		patients = new ArrayList<Patient>();
	}
	public void admit(String firstname, String lastname,
					  String id, String disease, boolean isVacinated) {//Stupid method manually create disease
        switch (disease) {
            case "Delta" -> {
                Disease newDisease = new Delta();
                Patient patient = new Patient(firstname, lastname, id, newDisease, isVacinated);
                patients.add(patient);
            }
            case "Covid19" -> {
                Disease newDisease = new Covid19();
                Patient patient = new Patient(firstname, lastname, id, newDisease, isVacinated);
                patients.add(patient);
            }
            case "Hypopnea" -> {
                Disease newDisease = new Hypopnea();
                Patient patient = new Patient(firstname, lastname, id, newDisease, isVacinated);
                patients.add(patient);
            }
        }




	}
	public ArrayList<Patient> getCovidPatients (SevereLevel s){
		ArrayList<Patient> getCovidPatients = new ArrayList<Patient>();
		for (Patient patient:patients){
			if(patient.getServeLevel().equals(s)&&patient.getDisease() instanceof Covid19){//Delta and Covid 19 both are class of Covid 19)
				getCovidPatients.add(patient);
			}
		}
		return getCovidPatients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}
	public ArrayList<Patient> getPatients() {
		return patients;
	}
}
