package Object;

public class Employee2 {
	private int id;
	private String firstname;
	private String lastName;
	private String department;
	
	public boolean equals(Object o) {
	    if(o == null)
	    {
	        return false;
	    }
	    if (o == this)
	    {
	        return true;
	    }
	    if (getClass() != o.getClass())
	    {
	        return false;
	    }
	     
	    Employee2 e = (Employee2) o;
	    return (this.getId() == e.getId());
	}

	// Setters and Getters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
