package logic;

import java.util.ArrayList;

public class EnterProfile {
	private Person person;
	int bodyTemperature;

	public EnterProfile(Person person, int bodytemperature) {
		setPerson(person);
		setBodyTemperature(bodytemperature);
	}

	public boolean hasFever() {
		return getBodyTemperature() >= 37;
	}
	public void setBodyTemperature(int bodyTemperature) {
		bodyTemperature=Math.min(42,bodyTemperature);//not more than 42
		bodyTemperature=Math.max(35,bodyTemperature);//not less than 35
		this.bodyTemperature =bodyTemperature;
	}


	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getBodyTemperature() {
		return bodyTemperature;
	}




}