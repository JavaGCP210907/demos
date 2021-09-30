package com.revature.factory;

//All objects that implement Cookie will have access to its method
//We'll use a CookieFactory class to write logic that creates objects of type Cookie

public interface Cookie {

	//all implementing Classes will have their own version of this method (overriding)
	public void getBaked();
	
}
