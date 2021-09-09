package com.revature.throwables;

//Unchecked Exceptions aka Runtime Exceptions must extend RuntimeException
@SuppressWarnings("serial") //unneccsary to add, unless you hate yellow warning squiggles
public class MyUncheckedException extends RuntimeException {

	//constructor for MyUncheckedException, 
	//it'll be exactly same as in Throwable, hence super(); 
	public MyUncheckedException() {
		super();
	}
	
	//another constructor for MyUncheckedException, 
	//it'll accept a message to display. There's one like this in Throwable as well, hence super(message);
	public MyUncheckedException(String message) {
		super(message);
	}
	
}
