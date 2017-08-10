package org.enterprise.main;

import java.util.ArrayList;
import java.util.List;

import org.enterprise.controller.EmployeeController;
import org.enterprise.entities.Employee;

public class EnterpriseMain {

	public static void main( String[] args ) {
		EmployeeController employee = new EmployeeController();
		List< Employee > employeeList = new ArrayList< Employee >();
		employeeList = employee.getEmployeeList();
		if ( employeeList != null ) {
			if ( employeeList.isEmpty() ) {
				System.out.println( "No employee data found!" );
			} else {
				int i = 0;
				for ( Employee e : employeeList ) {
					System.out.println( i + ". " + e.toString() );
					i ++;
				}
			}
		}
	}
}
