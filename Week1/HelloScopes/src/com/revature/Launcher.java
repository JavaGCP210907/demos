package com.revature;

public class Launcher {

	//This is a class scoped primitive variable (note the "static")
	//we will immediately assign the value 5 at declaration. (In other words we INITIALIZE the variable)
	static int i = 5;
	
	//THIS class scoped primitive is not given a value at declaration. (In other words, it's UNINITIALIZED)
	static int i2;
	
	//This is a class scoped reference variable. 
	//(called a reference variable because it REFERS to an object)
	//For uninitialized reference variables, the default value is "null"
	static Launcher launcher;
	//Launcher is the data type, launcher is the variable name we gave it
	
	//This is an instance/object scoped variable - note no "static" keyword
	//this will belong to instances of the Launcher class, not the Launcher class itself
	double dub = 5.7;
	
	public static void main(String[] args) {
		
		System.out.println("================================(Class Scoped Variables)");
		
		System.out.println(i); //this will print 5...

		System.out.println(i2); //this will print? 0. fun fact an uninitialized int = 0 

		//System.out.println(dub); //a static method can not see an instance scoped variable
		
		//Remember, static indicates that something belongs to the class
		//Thus, instance variables, which belong to INSTANCES of the class aren't visible within statics
		
		System.out.println("==================================(Messing with our two variable scopes)");
		
		//initializing the previously uninitialized primitive variable
		i2 = -98;
		
		//initializing the previously uninitialized reference variable
		launcher = new Launcher(); 
		
		System.out.println(i); //this primitive variable hasn't been changed
		System.out.println(i2); //this primitive variable HAS been changed
		System.out.println(launcher); //reference variables store the location of an object in memory (memory address)
		
		//The (static) launcher variable is an object of the Launcher Class
		//So it can access the instance scoped variable dub!!
		System.out.println(launcher.dub);
		//Calling static objects with non-static variables is a way to access non-static variables in static methods
		
		System.out.println("=================================(Messing with a new Launcher object)");
		
		//initialize a new Launcher object
		Launcher launcher2 = new Launcher();
		//launcher and launcher2 are the same data type (Launcher), but they are two different objects
		
		launcher2.dub = 1234; //give launcher2 a new value for the dub variable
		
		//because dub is instance scoped, we can change the value of dub in launcher2, without changing it in launcher
		System.out.println(launcher.dub); //5.7
		System.out.println(launcher2.dub); //1234.0
		
		i2 = 234324; //changing the value of the class scoped variable i2
		
		//launcher.i2 = 234324; //this will STILL change the value for every object. considered "worse practice"
		
		//because i2 is a class scoped variable, each object has the same value for it
		System.out.println(launcher.i2); //234324
		System.out.println(launcher2.i2); //234324
		
		//you'll get warnings here - "should be access in a static way" aka without calling it from the object
		//that's because they're static variables. It's redundant to call them from an object, 
			//since it'll always be the same value
		
		System.out.println("=======================================(Method/Block Scopes)");
		
		//call the "example" method below, giving it a true value
		//the main method runs automatically when you run your application (that's the point of it)
			//but any other method must be explicitly called in order to execute
		example(true); 
		
		//if the example method was non static, we could still call it with launcher.example or launcher2.example
		
	} //end of the main method---------------------------
	
	//Remember, a method defines some behavior of a class
	public static void example(boolean b) {
		
		float f = 25.0f; //example of a method scoped variable
		
		System.out.println("method scoped variable: " + f);
		
		//if the inputed method parameter (boolean b) is true, do the following block of code
		if(b) {
			char c = 'c'; //example of a block scoped variable
			System.out.println("block scoped variable: " + c);
			System.out.println("method scoped variable again: " + f); 
			//method-scoped f is still visible within the if statement, because the if statement is inside the method
			
		}
		

		
	}
	
}
