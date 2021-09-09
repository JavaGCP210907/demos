package com.revature;

import com.revature.models.Buggy;
import com.revature.models.Car; //import the Car class, so that we can access its fields and methods

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("===========================(Using our Constructors)");
		
		Car myCar = new Car(4, 2); //instantiating (creating) a Car object, giving it two arguments (tires and doors)
		//Is this a reference variable or a primitive? Reference variable!! Because it's referencing an object
		
		//Let's print out some of the Car's variables
		System.out.println(myCar.tires); //this value was given by the user in the constructor above
		System.out.println(myCar.color); //this wasn't given by the user, but the constructor still assigns a value
		System.out.println(myCar); //this will print the memory address
		
		System.out.println("My Car is " + myCar.color + " and has a mileage of " + myCar.mileage);
		
		
		//instantiate a Car object, using the all args constructor
		Car youCar = new Car(4, 4, 90000000, "gold");
		//remember, our all args constructor actually calls another constructor (constructor chaining using "this")
		
		
		System.out.println("================================(Using the methods)");
		
		Buggy myBuggy = new Buggy();
		
		System.out.println(myCar.drive(200)); //the drive() method of car executes
		System.out.println(myBuggy.drive(500)); //the OVERRIDDEN drive() method of buggy executes
		
		myBuggy.punchSomeone(); //the buggy-specific method. Rememeber, it doesn't return a String, it just has a print  
		
		//myCar.punchSomeone(); //remember - punchSomeone() only belongs to the Buggy Class... Car doesn't have that
		
		//note, drive() and punchSomeone() both print stuff to the console, 
		//but drive() returns a String, and punchSomeone() simply uses a print statement. 
		
		System.out.println("========================================(Casting)");
		
		//talking about upcasting-----------------------------------------
		
		//a subclass (Buggy) gets assigned to a superclass (Car)
		
		Car coolBuggy = new Buggy(); //assigning a Buggy object to a Car variable
		
		//this is legal because a Buggy will always be a Car
		
		System.out.println(coolBuggy.drive(345534)); //coolBuggy is of type car, 
													 //BUT the Buggy-specific version of drive() gets used
		
		//System.out.println(coolBuggy.punchSomeone()); //coolBuggy is of type Car... so the punchSomeone() doesn't exist
		
		//talking about downcasting-----------------------------------------
		
		//Buggy bug = (Buggy) new Car();
		//This will compile, but it will throw an exception at runtime - 
		//It's illegal because not all Cars are necessarily Buggies, Java doesn't know how to make that distinction
		
		//These are 2 examples of legal downcasting (remember, has to be done explicitly)
		
		Car newBuggy = new Buggy(); //parent type reference variable, assigned to child type object
		
		((Buggy)newBuggy).punchCounter = 7; //myBuggy is a Car type variable, 
											//so punchCounter wouldn't be visible without casting
		
		Buggy newerBuggy = (Buggy)newBuggy; //also a somewhat valid reason to use downcasting  
		
		
		
	}

}
