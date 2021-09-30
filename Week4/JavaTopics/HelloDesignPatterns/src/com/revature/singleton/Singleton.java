package com.revature.singleton;

//Using a singleton ensures that only one instance of a class can ever exist
//This makes it so that all objects of the Class will be exact the same

//Difference between singletons and normal classes:
//Normal classes use a Constructor
//Singletons use a getInstance() method, which calls a private constructor

public class Singleton {

	//instantiate a variable of the same type as the class
	private static Singleton singleton = null;
	
	//This variable will be used to demonstrate that all instances of this Class are the same
	public String singletonMessage;
	
	//static method the create a (SINGLE) instance of the Singleton Class
	public static Singleton getInstance() {
		
		if(singleton == null) { //if the singleton variable above is null...
			singleton = new Singleton();//instantiate a new one
		}
		
		return singleton; //return the new (or previously existing) Singleton object
		
	}
	
	//private constructor (so only the Singleton Class can see it)
	private Singleton() {
		super();
		singletonMessage = "I'm the only possible instance of this Class!";
	}
	
}
