package util;

import disease.Disease;

public class Patient {
	private String firstname;
	private String lastname;
	private String id;
	private Disease disease;
	private boolean vaccinated;
	
	public Patient(String firstname, String lastname, String id,Disease disease,boolean isVacinate) {
		super();
		setDisease(disease);
		setFirstname(firstname);
		setId(id);
		setLastname(lastname);
		setVaccinated(isVacinate);
	}

	
	public boolean isVaccinated() {
		return vaccinated;
	}


	public void setVaccinated(boolean vac) {
		this.vaccinated = vac;
	}


	public SevereLevel getServeLevel() {
		return disease.getSevereLevel(vaccinated);
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	
	public Disease getDisease() {
		return disease;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Patient [" + firstname + " " + lastname + " ID " + id + " disease " + disease
				+ " severe level " + getServeLevel() + "]";
	}
	
	
}
