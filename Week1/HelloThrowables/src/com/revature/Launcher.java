package com.revature;

import com.revature.throwables.MyCheckedException;
import com.revature.throwables.MyUncheckedException;

public class Launcher {

	public static void main(String[] args) {
		
		//The compiler will let you call these methods straight up...
		//but it'll just end up crashing your program one the exceptions are thrown.
		
		//throwChecked(); //this would need "throws" in the main method signature in order to compile
		//throwUnchecked(); //compiler is not checking for unchecked exceptions... don't need "throws"!
		
		System.out.println("================================================(Try/Catch)");
		
		
		try { //try will TRY a block of code that may or may not throw and exception
			System.out.println("try block starting...");
			throwChecked();
		} catch (MyUncheckedException e) {
			System.out.println("I won't run - I can only catch Unchecked Exceptions");
		} catch (MyCheckedException e) {
			System.out.println("Hello from the catch block!");
			e.printStackTrace(); //this is a very popular way to print out the error message
		} catch (Exception e) {
			System.out.println("I could've caught any exception...");
		} finally {
			System.out.println("Hello from the finally block... I will ALWAYS run");
		}
		
		//It's best practice to write your catch block from most specific to least specific
		//Very common to see the final catch block catch just a generic Exception
		//Also, if you put the most generic Exception up top, you may get "unreachable code" errors
		
		//Here are two miscellaneous exceptions we see somewhat often-----------
		
		System.out.println("=====================================(misc. built-in exceptions)");
		
		//these are both unchecked exceptions btw...
		
		try {
			System.out.println("I'm going to to try dividing by zero");
			int i = 5/0;
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException caught!!! you really shouldn't be doing that :'(");
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("I'm going to try accessing an index that's out of bounds");
			int[] nums = {1, 2};
			System.out.println(nums[2]); //this will throw an exception... we only have up to index 0 and 1
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("That index doesn't exist dumdum");
			e.printStackTrace();
		}

		//exceptions are getting caught, and we get error messages because of e.printstacktrace
		//but because try/catch blocks HANDLE exceptions, our application does not crash.
		
	}

	
	//creating some methods that throw our custom Exceptions-------------
	
	public static void throwChecked() throws MyCheckedException { //checked exceptions NEED throws declarations 
		System.out.println("I'm about to throw a checked exception!!");
		throw new MyCheckedException(); //this will throw our checked exception
		//note the new keyword - this is actually creating an object!
	}
	
	public static void throwUnchecked() throws MyUncheckedException { //compiler doesn't spot unchecked exceptions
																	  //the throws isn't necessary in order to compile
																	  //but still needed at runtime
		System.out.println("I'm about to throw a unchecked exception!!");
		throw new MyUncheckedException();
	}
	
}
