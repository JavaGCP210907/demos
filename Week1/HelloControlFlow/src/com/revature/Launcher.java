package com.revature;

import java.lang.Math; //we don't need to do this - the .lang package is implicitly imported
//but if it wasn't, this is how we would import the Math class to use it methods

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("=============================================(if/else if/else)");
		
		double randomNum = Math.random();
		//Math is a Class in the java.lang package - it has methods that let us do basic math stuff
		
		System.out.println("Today's random number is: " + randomNum);

		if(randomNum > .75) {
			System.out.println("randomNum is greater than .75!!!");
		} else if (randomNum > .50) {
			System.out.println("randomNum is less than .7500000001, and greater than .50");
		} else {
			System.out.println("randomNum is real smol");
		}
		
		System.out.println("============================================(while/do-while loop)");
		
		short smallNum = 2;
		
		while (smallNum < 500) {
			smallNum += 100;
			//we haven't seen += yet: It's basically shorthand for smallNum = smallNum + 5;
			//you can use this syntax with any arithmetic operator eg. smallNum /= 2;
			System.out.println("smallNum has increased to: " + smallNum);
		}
		
		System.out.println("While Loop has completed! Enjoy your new number");
		
		
		//now we'll use a do-while loop, which runs a block of code BEFORE checking the boolean
		do {
			smallNum -= 100;
			System.out.println("smallNum has decreased to " + smallNum);
		} while (smallNum > 10); 
		
		System.out.println("Do While Loop has completed! Enjoy your new number: " + smallNum);
		
		//after the while expression fails, the code within the "do" never runs again
		//so smallNum stays at 2 and doesn't decrement after the while expressions evaluates to false
		

		System.out.println("==============================================(For Loops)");
		
		int loopVictim = 0;
		
		//"for as long as this int, which starts at 0, is less than 10, increment it once per loop"
		for(int i = 0; i < 10; i++) { //it's typical practice for the int in a for loop to be called "i"... for iterator?
			loopVictim += 5;
			System.out.println("Our loop victim is now: " + loopVictim);
			System.out.println("Our loop variable/iterator is now: " + i);
			//notice "Our loop variable/iterator is now: 10" never prints, since the loop ends once i is not > 10
		}
		//The loop executed 10 (0-9) times. Once i = 10, the loop completes and doesn't execute it's code again
		
		
		//I'm gonna add a more interesting use of for loops and an if statement below with break/continue----------
		
		//This is an Array, which we'll talk more about. 
		char[] myName = {'B', 'E', ' ', 'N', 'A', 'A', 'A'};
		
		System.out.println(myName); //print the array as it, without processing
		
		//now let's use some control flow statements to print only the chars in the Array that we want (BEN)
		
		for(int i = 0; i < myName.length; i++) { //.length returns the length of the Array as an int. Very useful.
		
			if(myName[i] == ' ') {
				continue;
				//if the char at position i == ' ', skip the current iteration of the loop
			}
			
			if(myName[i] == 'A') {
				break;
				//if the char at position i == 'A', break (end) the loop.
			}
			
			System.out.println(myName[i]); //if none of the if statements run, the char as position i will print
			
		}
		
		System.out.println(myName); //note that the actual Array isn't affected by any of this! 
		//we're simply printing the values of the Array that we want, based on some control flow statements
	
		
	}

}
