package com.revature.models;

//This is an abstract class, that will also implement our Interface
//So now, this abstract class also has access to the field and methods in Walkable
public abstract class Person implements Walkable {

	public String name;
	public String phobia;
	
	
	
	//concrete method
	public void breathe() {
		System.out.println("hoo hah hoo hah");
	}
	
	
	//abstract method - must be declared abstract when in an abstract class
	public abstract String getScared(String words);
	
	
	//two constructors---------------------
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Person(String name, String phobia) {
		super();
		this.name = name;
		this.phobia = phobia;
	} 
	
	
	
}
