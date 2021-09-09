package com.revature;

import com.revature.models.Associate;
import com.revature.models.Person;

public class Launcher {

	public static void main(String[] args) {
		
		//keyboard shortcut for imports: ctrl+shift+o
		
		Person daniel = new Associate("Clowns", "Daniel", "Java GCP");

		//concrete method from Person
		daniel.breathe();
		
		//Overridden method from Associate
		System.out.println(daniel.getScared("NOT THE CLOWNS, PLEASEEEEE D:"));
		
		//System.out.println(daniel.batch); //daniel is of type Person, so doesn't have access to the batch field
											//since batch is associate specific
		
		
		Associate freddie = new Associate("Bleeding", "Freddie", "Java GCP");
		
		freddie.move(500); //associate overrides this method from Walkable interface
		
		freddie.trip(); //concrete method from Walkable interface
		
	}

}
