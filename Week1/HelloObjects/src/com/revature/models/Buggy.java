package com.revature.models;

//Buggy extends Car! So what? First of all, Inheritance (An OOP Pillars)
//This means that the Buggy Class inherits all of the variables and methods of the Car class
//BUT, it can also have its own variables and methods unique to the Buggy Class
//Buggy is therefore a child class of Car. (Child/Parents relationship) (Subclass/Superclass relationship)
public class Buggy extends Car {

	//Buggy has all the fields of the Car class (tires, color, etc.)
	//But let's declare one more variable that's unique to the buggy class
	public int punchCounter;
	
	//Let's make a method that's unique to the Buggy class
	public void punchSomeone() {
		System.out.println("PONCH");
	}


	//This is an example of METHOD OVERRIDING - note the @Override annotation
	
	//Without Overriding, the Buggy class would have the same drive() method as the Car class...
	//But here, we declare the same method signature, with a different implementation (aka method body)
	@Override
	public String drive(int speed) {
		return "You are going " + speed + " miles per hour IN YOUR BUGGY";
	}
	
	
	
	//let's make a no-args and all-args constructor-----------------------------
	
	//click the source tab and choose constructors OR alt + shift + s
	
	
	//no args constructor (generate from superclass option)
	public Buggy() {
		super();
	}

	//all args constructor (generate from fields) (there will be a dropdown where you can choose from superclasses too)
	public Buggy(int punchCounter, int tires) {
		super(); //note that because we call super, we have access to all args in Car
		this.punchCounter = punchCounter;
	}
	
	
}
