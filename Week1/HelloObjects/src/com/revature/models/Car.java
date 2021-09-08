package com.revature.models;

//This is a class meant to model a Car - you can think of it like a template for all Car object
//It defines all the variables (fields/attributes) and methods (behaviors) I want a Car object to have

public class Car {

	//Declaring some car variables-----------------------
	public int tires;
	public int doors;
	public int mileage;
	public String color;
	
	
	//Let's also give the Car Class a method------------------------
	
	//This method will return a String. We do so with the "return" keyword
	public String drive(int speed) {
		return "You are driving " + speed + " miles per hour"; //String concatenation!! Linking these Strings and variable
		//note that this isn't a System.out.println!!
		//we'll see how return types work when we call this method in our Launcher
	}
	
	
	//Some constructors below---------------------------------
	
	//Remember, constructors are special methods that let us initialize an object
	//In other words, they give values to the object's variables
	
	//No-args constructor
	//If you create a Car object without arguments, this no args constructor will be called
	//In this constructor, we provide default values to the Car object's fields
	public Car() { //no parameters in the parenthesis... hence no-args
		super(); //this isn't necessary, super() will be called implicitly
		this.tires = 4;
		this.doors = 4;
		this.mileage = 76000;
		this.color = "white";
	}
	
	//Constructor with some (not all) arguments
	public Car(int tires, int doors) {
		super();
		this.tires = tires;
		this.doors = doors;
		this.mileage = 76000;
		this.color = "white";
		System.out.println("Hello from the some-args constructor");
	}
	
	//All args Constructor
	public Car(int tires, int doors, int mileage, String color) {
		//this is constructor chaining - we're going to call the some-args constructor above
		this(tires, doors); //this is calling the constructor directly above, instead of super()
		//then these variables are assigned as usual
		this.mileage = mileage;
		this.color = color;
	}
	
	//NOTE!! These 3 constructors all have the same, but different parameters
	//This is METHOD OVERLOADING
	
}
