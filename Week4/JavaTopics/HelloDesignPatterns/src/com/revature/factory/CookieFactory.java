package com.revature.factory;

//Factories are one of the cleanest ways to create objects in Java
//Imagine a scenario where there are multiple different types of the Object we can potentially make
//we can use factory, paired with an Interface (in this case, Cookie) to abstract away the decision-making code

public class CookieFactory {

	//use the getCookie method to get an objects of type Cookie
	public Cookie getCookie(String cookieType) {
		
		switch(cookieType) {
		
			case "NoBake" : {
				return new NoBake();
			}
			
			case "OatmealRaisin" : {
				return new OatmealRaisin();
			}
			
			case "PeanutButter" : {
				return new PeanutButter();
			}
			
			default : {
				System.out.println("no cookie found :("); //this will print if no cookie of the given String is found
				return null;
			}
		
		}
		
	}
	
	
	
}
