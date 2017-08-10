package org.enterprise.controller;

import java.util.List;
import org.enterprise.dao.EnterpriseDao;
import org.enterprise.dao.impl.EnterpriseDaoImpl;
import org.enterprise.entities.Employee;

public class EmployeeController {

	public List< Employee > getEmployeeList() {
		List< Employee > employeeList = null;
		EnterpriseDao dao = new EnterpriseDaoImpl();
		employeeList = dao.getEmployeeList();
		return employeeList;
	}
	
	public void GenericsUse() {
		
	}
}
