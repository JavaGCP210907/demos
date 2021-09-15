package com.revature.models;

import java.util.Scanner;

//This Menu Class will have a method that displays a menu to the user that they can interact with
//Through this menu, the user can give inputs that will interact with the database
public class Menu {

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
				//nothing here yet!!!
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
