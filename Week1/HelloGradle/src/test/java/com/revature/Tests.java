package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import vs import static? In this case, we need to import the static members of the Assertions class
//our assert methods won't be visible without the "static"

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Tests {

	public static Calculator c;
	
	//make a couple variables to use in our tests
	public int i = 3;
	public int j = 15;
	public int k = 0;
	public int result; //this one is uninitialized for now
	
	
	@BeforeAll //used for things you want to happen BEFORE the test class does ANYTHING
	public static void createCalc() {
		c = new Calculator();
		System.out.println("In the @BeforeAll method");
	}
	
	@AfterAll //used for things you want to happen AFTER the test class does ANYTHING
	public static void clearCalc() {
		c = null;
		System.out.println("In the @AfterAll method");
	}
	
	
	
	//Now let's actually write some unit tests--------------------------
	
	@Test //We need the @Test annotation for the method to be recognized as a test
	public void testAdd() {
		System.out.println("TESTING ADD METHOD");
		result = c.add(i, j); //we're assigning the result of the .add() method to the "result" variable
		assertTrue(result == 18); //assertTrue() makes a test pass if the expression resolves to true
		//if our result variable is equivalent to 18, our test passes because the add() method is working as expected
	}
	
	@Test
	public void testSubtract() {
		System.out.println("TESTING SUBTRACT METHOD");
		result = c.subtract(i, j);
		assertEquals(-12, result); //takes two parameters, and checks their equality
	}
	
	@Test
	public void testDivideByZero() {
		System.out.println("Going to try to throw an exception...");
		assertThrows(ArithmeticException.class, () -> c.divide(i, k));
		//"assert that dividing by zero throws an arithmetic exception"
	}
	
}
