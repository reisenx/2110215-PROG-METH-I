package logic;

import java.util.ArrayList;

public class Person {
	private String name;
	private int ID;

	public Person(String name, int ID) {
		setName(name);
		setID(ID);
	}
	public void setID(int ID) {
		this.ID = Math.max(1, ID);
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public int getID(){
		return ID;
	}
}

