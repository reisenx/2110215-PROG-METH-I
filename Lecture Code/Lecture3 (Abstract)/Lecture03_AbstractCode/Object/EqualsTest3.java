package Object;

import java.util.HashSet;
import java.util.Set;

public class EqualsTest3 {
    public static void main(String[] args) {
    	Employee3 e1 = new Employee3();
        Employee3 e2 = new Employee3();
 
        e1.setId(100);
        e2.setId(100);
 
        System.out.println(e1.equals(e2));
        
        Set<Employee3> employees = new HashSet<Employee3>();
        employees.add(e1);
        employees.add(e2);
         
        System.out.println(employees);  //Prints two objects
    }
}
