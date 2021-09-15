package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeDao implements EmployeeDaoInterface {

	@Override
	public List<Employee> getEmployees() {
		
		//the first thing we do in DAO methods is open a Connection to our database
		try(Connection conn = ConnectionUtil.getConnection()) { //getConnection() comes from our ConnectionUtil Class
			
			//initilalize an empty ResultSet object. This will store the results we get from the DB
			ResultSet rs = null;
			
			//write out our SQL query, and store it in a String
			String sql = "select * from employees";
			
			//Put the SQL query into a Statement object (The Connection object has a method for this)
			Statement s = conn.createStatement();
			
			//Execute the query, putting the results into our ResultSet object
			//the Statement object has a method that takes String to execute as a SQL query
			rs = s.executeQuery(sql);
			
			//All the code above makes a call to our database... Now we need to store the data in a List
			
			//create an empty List to be filled with the data from the database
			List<Employee> employeeList = new ArrayList<>();
			
			while(rs.next()) { //while there are results in the result set...
				
				//Use the all args Constructor to create a new Employee object from each returned row...
				Employee e = new Employee(
						//we want to use rs.getXYZ for each column in the record
						rs.getInt("employee_id"),
						rs.getString("f_name"),
						rs.getString("l_name"),
						rs.getString("hire_date"),
						rs.getInt("role_id")
						);
				
				//and populate the ArrayList with each new Employee object
				employeeList.add(e); //e is the new Employee object we created above
			}
			
			//when there are no more results in the ResultSet the while loop will break...
			//return the populated List of Employees
			return employeeList;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong with your database!"); //generic console message
			e.printStackTrace(); //stack trace so we actually know what went wrong
		}
		
		return null; //we add this after the try/catch so Java won't yell.
					 //(Since there is no guarantee the try with resources block will run)
	}

	@Override
	public List<Employee> getEmployeesByRoleTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEmployee(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
