package com.revature;

import com.revature.factory.Cookie;
import com.revature.factory.CookieFactory;
import com.revature.singleton.Singleton;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("==============================(Singletons)");

		//creating 3 different instances of our Singleton Class
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();
		Singleton z = Singleton.getInstance();
		
		//printing the singletonMessage field
		System.out.println("x: " + x.singletonMessage);
		System.out.println("y: " + y.singletonMessage);
		System.out.println("z: " + z.singletonMessage);
		
		//change the variable of instance X
		x.singletonMessage = (x.singletonMessage).toUpperCase();
		
		//printing the singletonMessage of each instance after changing X
		System.out.println("x: " + x.singletonMessage);
		System.out.println("y: " + y.singletonMessage);
		System.out.println("z: " + z.singletonMessage);
		
		//we see that changing one instance affects all the others!
		
		//what's the point?
		
		//This allows a global point of access to the Class
		//Every instance of Singleton will refer to the exact same object. 
		//This allows for behavioral consistency!
		
		//We won't usually create singletons... Java has a bunch of built in singletons though
		
		//note that the hashcodes are even the same
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		System.out.println("==============================(Factories)");
		
		//Instantiate a CookieFactory to use its getCookie method
		CookieFactory cf = new CookieFactory();
		
		//use the getCookie method of the CookieFactory to get new Objects of type Cookie
		Cookie cookie1 = cf.getCookie("NoBake");
		Cookie cookie2 = cf.getCookie("OatmealRaisin");
		Cookie cookie3 = cf.getCookie("PeanutButter");
		
		//use the method in each new Cookie object, notice how they're all of their respective Cookie types
		cookie1.getBaked();
		cookie2.getBaked();
		cookie3.getBaked();
		
		//Thanks to the power of abstraction (Factory Design Pattern) Making Cookie objects is way cleaner!
		
	}

}
