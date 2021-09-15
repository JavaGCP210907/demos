package com.revature.dao;

import java.util.List;

import com.revature.models.Employee;

//Remember, Interfaces provide methods with no body (abstract methods) to be implemented in another class
//Great for organization, and making sure certain classes implement certain functionality
//Here, we'll lay out all of the behaviors (methods) that an EmployeeDao should have
public interface EmployeeDaoInterface {

	public List<Employee> getEmployees(); //returns a List of all employees (select *)
	
	public List<Employee> getEmployeesByRoleTitle(String title); //this will get employees with a certain role (select where)
	
	public void addEmployee(Employee employee); //this will add an employee to the database (insert)
	
	public void removeEmployee(int id); //this will remove employees using their id (delete)
	
}
