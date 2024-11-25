package Object;

public class Employee {
	  int employeeId;
	  String firstName, lastName;
	  
	  public boolean equals(Object o){
		if(this == o)				 return true;
	    if(o == null)                return false;
	    if(o.getClass() != this.getClass()) return false;

	    Employee other = (Employee) o;
	    if(this.employeeId != other.employeeId)      return false;
	    if(! this.firstName.equals(other.firstName)) return false;
	    if(! this.lastName.equals(other.lastName))   return false;

	    return true;
	  }
}
