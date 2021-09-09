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
		
		
		
		System.out.println("=============================================(StringBuilder)");
		
		
		
		
		System.out.println("=============================================(Scanner)");
		
		
	}
	
}
