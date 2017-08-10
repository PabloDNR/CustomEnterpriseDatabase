package org.enterprise.dao;

import java.util.List;

import org.enterprise.entities.Employee;

public interface EnterpriseDao {

	// public int insert(User user);

	public List< Employee > getEmployeeList();
}
