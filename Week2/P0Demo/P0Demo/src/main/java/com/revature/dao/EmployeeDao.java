package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
			//*****IF YOU HAVE CAPITAL LETTERS IN YOUR SCHEMA, you'll likely have to write your statement like this:
			//String sql = "select * from \"Krusty_Krab"\.employees";
			
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

	//Bit more complicated query - first time we're using PARAMETERS
	@Override
	public List<Employee> getEmployeeById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from employees where employee_id = ?";
			
			//when we need parameters we need to use a PREPARED Statement, as opposed to a Statement (seen above)
			PreparedStatement ps = conn.prepareStatement(sql); //prepareStatment() as opposed to createStatment()
			
			//insert the methods argument (int id) as the first (and only) variable in our SQL query
			ps.setInt(1, id); //the 1 here is referring to the first parameter (?) found in our SQL String
			
			rs = ps.executeQuery();
			
			//create an empty List to be filled with the data from the database
			List<Employee> employeeList = new ArrayList<>();
			
	//we technically don't need this while loop since we're only getting one result back... see if you can refactor :)
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
			System.out.println("Something went wrong with your database!"); 
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public void addEmployee(Employee employee) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//This is my quick/dirty solution to get the current date in appropriate format 
			//Surely there's a more elegant solution... feel free to find one (or just don't use dates in your P0)
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //this will format my dates to be SQL acceptable 
			Date date = new Date(); //from java.util - we will convert it into a java.sql Date 
			String currentDate = dateFormat.format(date); //this will format our date based on the format we gave above
			
			//the rest should proceed as normal
			
			//you can line break a sql statement in Java by concatenation (not the +)
			String sql = "insert into employees (f_name, l_name, hire_date, role_id)" +
						 "values (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, employee.getF_name());
			ps.setString(2, employee.getL_name());
			ps.setDate(3, java.sql.Date.valueOf(currentDate));
			ps.setInt(4, employee.getRole_id());
			
			ps.executeUpdate(); //for anything that is NOT a SELECT statement, we use executeUpdate();
			
			//send confirmation to the console if successful
			System.out.println("Employee " + employee.getF_name() + " created. Welcome aboard!");
			
		} catch (SQLException e) {
			System.out.println("add employee failed :(");
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeEmployee(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "delete from employees where employee_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("Get outta here employee number: " + id);
			
		} catch (SQLException e) {
			System.out.println("you can't fire me I QUIT");
			e.printStackTrace();
		}
		
	}
	
	
	//Bit more complicated query, uses a join - will implement after hours
	@Override
	public List<Employee> getEmployeesByRoleTitle(String title) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "select * from employees inner join roles "
					     + "on employees.role_id = roles.role_id where roles.role_title = ?";
			//we need to join employees to roles in order to access the role_title column and return employees
			//since I want to get employees based on something found in the roles table, we need a join 
			
			//REST TO BE ADDED--------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
