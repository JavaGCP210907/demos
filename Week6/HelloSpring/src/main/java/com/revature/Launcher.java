package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.configs.Config;
import com.revature.models.User;

public class Launcher {

	public static void main(String[] args) {
		
		//create an ApplicationContext type Spring Container 
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		//Now that we have a Spring Container ^^^ storing User and Accounts beans, we can make some!
		
		//A cast is required because the ApplicationContext can't guess what kind of object will be returned.
		User u = (User)ac.getBean("user");
		
		//Let's take a look at what our User Bean looks like
		System.out.println(u);
		//We got a User object that we created using getBean!
		//BUT... nowhere did I create Account object to attach to it
			//This is the power of autowiring
		
		//Now we can give our Bean some values
		u.setId(1);
		u.setName("CoolUser");
		u.getAccount().setBalance(500000000.55);
		u.getAccount().setType("Checking");
		
		System.out.println(u);
		
		System.out.println("=========================================================");
		
	}
	
}
