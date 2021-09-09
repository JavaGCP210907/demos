package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=============================================(Testing String Equality)");
		
		String s1 = "Hi Java";
		String s2 = "Hi Java"; //since s2 is the same as s1, they will refer to the same object in memory
		String s3 = "hi java"; 
		String s4 = new String("Hi Java"); 
		
		System.out.println(s1 == s2); //true
		System.out.println(s1 == s3); //false
		System.out.println(s1 == s4); //false
		//since we use "new", s4 will be a new object in memory - it's not a String literal
		
		System.out.println(s1.equals(s4)); //true, the value of the characters are the same
		
		//See why we tend to use .equals with Strings and == with primitives?
		//We usually want to compare the VALUE of the variable, not the memory locations
			//(primitives aren't objects so they aren't stored in the heap... so == will compare just the values then)
		
		System.out.println("=============================================(Testing String Methods)");
		
		//Remember, Strings ARE NOT primitives. We assign String objects to reference variables...
		//The Strings we're working with are objects/instantiations of the String Class
		
		String pangram = "Sphinx of Black Quartz Judge my Vow";
		
		//hopefully these two methods are self explanatory
		System.out.println(pangram.toLowerCase());
		System.out.println(pangram.toUpperCase());
		
		//length() returns the length of the String, similar to .length in Arrays
		System.out.println("The pangram is " + pangram.length() + " characters long");
		
		//charAt() returns the character at a given index
		System.out.println(pangram.charAt(0)); //first character
		System.out.println(pangram.charAt(pangram.length() - 1)); //last character
		//System.out.println(pangram.charAt(pangram.length()));
		//why doesn't this^ work? Because of ZERO INDEXING! the indeces go from 0-34, not 1-36
			//so there is NO char at index 36. You'll get an IndexOutOfBoundsException
		
		//using charAt in a for loop
		for(int i = 0; i < pangram.length(); i++) {
			System.out.println(pangram.charAt(i)); //this will print out each character of pangram on a new line
		}
		
		//substring() returns a String that's found within the given String\
		System.out.println(pangram.substring(5, 25)); //this will print characters 2-25 of our pangram
		
		//one more method - split() will create an Array via specified delimiters
		String[] words = pangram.split(" "); //an empty space is the delimiter we want to split on
		
		System.out.println(words); //this simply prints out a memory address... Arrays are objects :(
		
		//we can easily print the values of this Array using an ENHANCED FOR LOOP... WOAH!!
		for(String word : words) { //"for every String in the words Array, do {this}"
			System.out.println(word);
		}
		//enhanced for loops are a super convenient way to iterate through things
		
		//some String theory lol---------------------------------
		
		//Note that using the above methods WON'T actually change the original pangram String
		//we've been using methods to print manipulations of it, but they aren't stored as new objects
		//See StringBuilder below for mutable String-like behavior
		
		//you COULD always assign a new String variable to these manipulations:
		String s5 = s1 + s2.length() + s3.toUpperCase() + pangram.charAt(5);
		System.out.println(s5);
		
		System.out.println("=============================================(StringBuilder)");
		
		
		
		
		System.out.println("=============================================(Scanner)");
		
		
	}
	
}
