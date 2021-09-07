package com.revature;

public class Launcher {

	//shortcut to auto-generate main method: type "main" and then ctrl + space
	public static void main(String[] args) {
		
		System.out.println("=================================================(Integer Primitives)");
		
		//These first 5 primitives we'll see are integers - whole numbers, no decimals.
		
		byte b = 1; //bytes are one byte in size, from -128 to 127 
		System.out.println(b); //we're printing the value of b
		
		short s = 300; //shorts are 2 bytes in size, from -32768 to 32767
		System.out.println(s);
		
		int i = 20000; //4 bytes in size, from -214783648 to 214783647
		System.out.println(i);
		
		long l = 9000000000000000000L; //8 bytes in size from very low to very high
		System.out.println(l);
		
		//chars will always be written in single quotes
		char c = 'a'; //2 bytes in size
		char c2 = 18;
		char c3 = '$';
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println(Character.MIN_VALUE); //a blank space
		System.out.println(Character.MAX_VALUE); //a ?
		
		
		System.out.println("==============================================(Floating Point Primitives)");
		
		//these next 2 primitives are floating point numbers - they can have decimals
		
		double d = 2.2; //8 bytes in size
		System.out.println(d);
		
		
		float f = 42.07f; //4 bytes in size 
		System.out.println(f);
		
		System.out.println("=================================================(Boolean)");
		
		//the last primitive type is boolean
		//this is the ONLY way to denote true/false in Java
		
		boolean bool = true;
		
		boolean bool2 = false;
		
		System.out.println(bool);
		System.out.println(bool2);
		
		System.out.println("===================================================(Arithmetic Operators)");
		
		//creating some variables to demonstrate the arithmetic operators
		int sum = 5 + 5; //10
		int difference = 20 - 10; //10
		int product = 5 * 2; //10
		int quotient = 100 / 10; //10
		int remainder = 30 % 20; //10
		
		//you can do mathematical operations within print statements, using numbers or variables
		System.out.println(5 + 5);
		System.out.println(sum + difference);
		System.out.println(product + quotient - remainder);
		System.out.println(sum + remainder * quotient / difference + sum % difference);
		
		//parenthesis will work like usual (PEMDAS)
		System.out.println((sum + difference) * 500);
		
		
		System.out.println("=======================================(Increment/Decrement)");
		
		//we have ++ to increase a number by 1, and -- to decrease a number by 1
		//very useful in loops, which we'll see later
		
		int funnyNumber = 24;
		System.out.println("funnyNumber is equal to: " + funnyNumber);
		
		funnyNumber++; //this will increase the value of our variable by 1
		System.out.println("but you know what's funnier than 24? " + funnyNumber);
		
		funnyNumber--; //this will decrease the value of our variable by 1
		System.out.println("25 is too funny... decrease it please: " + funnyNumber);
		
		//Does the position of the ++ or -- matter??? YES
	
		
		System.out.println("=====================================(Pre/Post Increment)");
		
		//a prefix increment/decrement will return the value of a variable AFTER incrementing
		//a suffix increment/decrement will return the value of a variable BEFORE incrementing
		
		int incrementTest = 20;
		
		System.out.println("incrementTest using prefix increment: " + ++incrementTest);
		
		incrementTest = 20; //resetting incrementTest back to 20
		
		System.out.println("incrementTest using suffix increment: " + incrementTest++);
		//incrementTest DOES still increment with a post increment, but it'll be after it's called
		
		System.out.println("proff that suffix incrementing will still increment: " + incrementTest++);
		
	}
	
}
