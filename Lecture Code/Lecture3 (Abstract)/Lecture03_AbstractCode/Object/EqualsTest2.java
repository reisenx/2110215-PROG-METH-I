package Object;

import java.util.HashSet;
import java.util.Set;

public class EqualsTest2 {
    public static void main(String[] args) {
        Employee2 e1 = new Employee2();
        Employee2 e2 = new Employee2();
 
        e1.setId(100);
        e2.setId(100);
 
        System.out.println(e1.equals(e2));
        
        Set<Employee2> employees = new HashSet<Employee2>();
        employees.add(e1);
        employees.add(e2);
         
        System.out.println(employees);  //Prints two objects
    }
}
