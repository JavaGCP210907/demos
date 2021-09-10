package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.revature.models.Pokemon;

//Collections are like Arrays in that they are objects that hold things
//But they only hold references to other objects (no primitives!) and do more than Arrays can

//Unlike Arrays, Collections can change size DYNAMICALLY
//There are many flavors of Collections, and we'll touch on some below

public class Launcher {

	public static void main(String[] args) {
		
		
		//Pokemon bidoof = new Pokemon("bidoof", "normal");

		System.out.println("=============================================(Lists)");
		
		//ArrayList is a very common implementation of the List Interface
		List<Pokemon> myPokemon = new ArrayList<>(); //empty ArrayList
		
		//.add method can add elements to your Collection
		myPokemon.add(new Pokemon("bidoof", "normal"));
		myPokemon.add(new Pokemon("mudkip", "water"));
		myPokemon.add(new Pokemon("brionne", "water"));
		myPokemon.add(new Pokemon("charmander", "fire"));
		myPokemon.add(new Pokemon("charmander", "fire")); //Lists can have duplicates.
		myPokemon.add(new Pokemon("pikachu", "electric"));
		
		//you don't have to instantiate an object in the .add() method... you can give it an existing object
		
		Pokemon alakazam = new Pokemon("alakazam", "psychic");
		
		myPokemon.add(alakazam);
		
		//we can print out the contents of our ArrayList like this...
		System.out.println(myPokemon);
		
		//OR... we can use an ENHANCED FOR LOOP to iterate over the data structure
		for(Pokemon p : myPokemon) {
			System.out.println(p.getName() + " is " + p.getType() + " type");
			//using the getters and setters to access the private fields
		}
		
		//explore some other methods we can use to manipulate Lists-------------
		
		//we can also use .add() to add elements at a specific index
		myPokemon.add(4, new Pokemon("tyranitar", "rock/dark"));
		
		//.get(index) is how we get a certain element in a list
		System.out.println("The Pokemon at index 4 is: " + myPokemon.get(4));
		//NOTE: because of zero-index, tyranitar is at index 4, but it's technically 5th in the ArrayList
		
		//.size() is analogous to .length for Arrays... returns an int of the size of the Collection
		System.out.println("The size of my party is: " + myPokemon.size());
		
		//.contains() checks if the List contains a certain object
		System.out.println(myPokemon.contains(alakazam)); //returns true
		
		//using a lambda to make our Pokemon "fight" 
		//forEach() will loop through our collection and perform a given action FOR EACH element
		myPokemon.forEach(pokemon -> pokemon.fight());
		
		
		
		System.out.println("=============================================(Sets)");
		
		Set<Pokemon> myPokemonSet = new HashSet<>();
		
		myPokemonSet.add(new Pokemon("dewgong", "water/ice"));
		myPokemonSet.add(new Pokemon("seaking", "water"));
		myPokemonSet.add(new Pokemon("zigzagoon", "normal"));
		
		Pokemon magikarp = new Pokemon("magikarp", "water"); //instantiating a magikarp object to demonstrate duplicates
		
		myPokemonSet.add(magikarp);
		myPokemonSet.add(magikarp); //sets can't have duplicates... but Java will let you try
		
		//enhanced for loop, note the order (or lack thereof) :o
		for(Pokemon p : myPokemonSet) {
			System.out.println(p);
		}
				
		System.out.println("=============================================(Maps)");
		
		//New Map, in order to map trainers to Pokemon
		Map<String, Pokemon> trainers = new TreeMap<>();
		
		//put some key/value pairs into out map with .put()
		trainers.put("Freddie", new Pokemon("mudkip", "water"));
		trainers.put("Peter", new Pokemon("porygon", "normal"));
		trainers.put("Evan", new Pokemon("mudkip", "water"));
		
		//Just to see what it looks like to print out a map
		System.out.println(trainers);
		//TreeMaps niche, is that they have sorted keys... In this case, Strings are sorted alphabetically
		
		
		//New Map with ints as keys... rememeber Collections (and Maps) only work with objects
		//we can't use int here... we need to use a WRAPPER CLASS... Integer in this case
		//a wrapper class is an Object representation of a primitive
		Map<Integer, Pokemon> pokemonIds = new TreeMap<>();
		
		pokemonIds.put(1, new Pokemon("gengar", "poison/ghost"));
		pokemonIds.put(2, new Pokemon("poliwag", "water"));
		pokemonIds.put(3, new Pokemon("eevee", "normal"));
				
		System.out.println(pokemonIds);
		//again, notice the keys are sorted... this time by increasing numerical value
		
	}

}
