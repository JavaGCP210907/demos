package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.EmployeeDao;
import com.revature.dao.RoleDao;

//This Menu Class will have a method that displays a menu to the user that they can interact with
//Through this menu, the user can give inputs that will interact with the database
public class Menu {

	EmployeeDao eDao = new EmployeeDao(); //so we can use the EmployeeDao methods
	RoleDao rDao = new RoleDao(); //so we can use the RoleDao methods
	
	//All of the manu display options and control flow are contained within this method
	public void displayMenu() {
		
		boolean displayMenu = true; //we're going to use this to toggle whether the menu continues after user input
		Scanner scan = new Scanner(System.in); //Scanner object to parse user input
		
		//pretty greeting :)
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("Welcome to the Krusty Krab Employee Management System!");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		
		
		//display the menu as long as the displayMenu boolean is true
		while(displayMenu) {
			
			System.out.println("-----------------");
			System.out.println("CHOOSE AN OPTION:");
			System.out.println("-----------------");
			
			//menu options
			System.out.println("hi -> get greeted");
			System.out.println("employees -> show all employees");
			System.out.println("employeesByID -> get employees with a certain role");
			System.out.println("employeesByTitle -> get employees of a certain title");
			System.out.println("addEmployee -> add a new employee");
			System.out.println("deleteEmployee -> delete an employee");
			System.out.println("updateSalary -> update the salary of a role");
			System.out.println("exit -> exit application");
			
			//parse user input after they choose a menu option, and put it in a String variable
			String input = scan.nextLine();
			
			//switch statement that takes the input and delivers the appropriate response
			//you may have a hard time reading all this functionality
			//I suggest you look at our dao layer interfaces to see everything the CLI is able to do
			switch(input) {
			
			case "hi": {
				System.out.println("hey man what's up");
				break; //we need a break in each case, or else all the other cases will still run
			}
			
			case "employees": {
				
				//get the List of employees from the DAO layer
				List<Employee> employees = eDao.getEmployees();
				
				//enhanced for loop to print out the Employees one by one
				for(Employee emp : employees) {
					System.out.println(emp);
				}
				
				break;
			}
			
			case "employeesByID": {
				
				System.out.println("What employee id would you like to search for?");
				
				int idInput = scan.nextInt(); //get user's input for id
				scan.nextLine(); //we still need nextLine so that we can move to the next line for more input
				
				//what if the user inputs a String? program crashes
				//up to you to polish your project a bit and add some foolproofing mechanisms
				
				List<Employee> employees = eDao.getEmployeeById(idInput);
				
				for(Employee emp : employees) {
					System.out.println(emp);
				}
				
				break;
			}
			
				case "employeebytitle": {
				
				System.out.println("Enter Employee Role to Search: (Case Sensitive! e.g. \"Fry Cook\")");
				String roleInput = scan.nextLine(); //get user's input for Role to search by
				
				List<Employee> employees = eDao.getEmployeesByRoleTitle(roleInput); //get the List of Employees from the dao
				
				for(Employee e : employees)
				{
					System.out.println(e); //print them out one by one via the enhanced for loop
				}
				break;				
				
			}
			
			case "addEmployee": {
				
				System.out.println("Enter Employee First Name");
				String fName = scan.nextLine();
				
				System.out.println("Enter Employee Last Name");
				String lName = scan.nextLine();
				
				//Not the best design... the user doesn't techinally know the role ids...
				//You could have a getAllRoles method in the RoleDao to display before this
				//OR you could display the different roles in another print statement like I did
				System.out.println("Enter Employee Role Id");
				System.out.println("Manager = 1 | Fry Cook = 2 | Cashier = 3 | Marketing = 4 | Nepotism = 5");
				
				int roleId = scan.nextInt(); 
				scan.nextLine();
				
				//create a new Employee based on these inputs
				Employee emp = new Employee(fName, lName, "xxx", roleId);
				///why xxx for hire_date??? We input the current date in the DAO. the "xxx" will go unused.
				
				eDao.addEmployee(emp);
				
				break;
			}
			
			case "deleteEmployee": {
				
				System.out.println("Enter the id of the Employee to delete");
				
				int id = scan.nextInt();
				scan.nextLine();
				
				eDao.removeEmployee(id);
				
				break;
			}
			
			case "updateSalary": {
				
				System.out.println("Enter Role Title to change");
				String titleInput = scan.nextLine();
				
				System.out.println("Enter a new Salary for this Role");
				int salaryInput = scan.nextInt();
				scan.nextLine();
				
				rDao.updateSalary(titleInput, salaryInput);
				break;
			}
			
			case "exit": {
				displayMenu = false; //this is how we break out of the while loop, ending the menu display
				System.out.println("see ya! come again soon.");
				break;
			}
			
			//this default block will catch anything that doesn't match a menu option
			default: {
				System.out.println("What did you say?? try again buddy.");
				break;
			}
			
			} //switch statement ends here
			
		} //while loop ends here
		
		System.out.println("Thank you for using the Krusty Krab EMS");
		scan.close(); //closes the Scanner, good for memory saving (imagine we have 50000000 open Scanner objects)
		
	}
	
}
