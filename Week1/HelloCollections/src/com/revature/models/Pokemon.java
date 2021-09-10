package com.revature.models;

public class Pokemon {

	//private fields are only visible within the class... So how can we access them?
	//getter and setter methods! This is an example of ENCAPSULATION (an OOP pillar)
	private String name;
	private String type;

	public void fight() {
		System.out.println(this.name + " attacked!");
	} 
	
	
	//Some boilerplate code below---------------------------------------------------
	//What do I mean by boilerplate?
	//boilerplate code is code that gets repeated in multiple places with little to no variation.
	//In our case, our boilerplate code consists of Constructors, getters/setters, toString, and hashcode/equals
	
	//alt + shift + s to bring up boilerplate code menu
	
	public Pokemon() { //no args constructor
		super();
		// TODO Auto-generated constructor stub
	}

	//all args constructor
	public Pokemon(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	//getters and setters are the only way we can make private fields accessible to other classes
	//again, this is ENCAPSULATION
	
	//in order to ACCESS the Pokemon's name field for instance, you'd say:
		//pokemon.getName()      <-This would return the pokemon's name
	
	//in order to CHANGE the Pokemon's name field for instance, you'd say:
		//pokemon.setName("newName")      <-This would change the pokemon's name
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	//toString() returns a String representation of the Object when we attempt to print it.
	//This is how we get any object's fields as Strings, instead of a memory address
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}
	
	
}
