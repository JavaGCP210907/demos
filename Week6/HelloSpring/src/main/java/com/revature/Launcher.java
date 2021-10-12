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
		u.getAccount().setBalance(50000.55);
		u.getAccount().setType("Checking");
		
		System.out.println(u);
		
		System.out.println("=====================================================(Messing with Scopes)");
	
		//Recall bean scopes - Beans are singletons by default
		User u2 = (User)ac.getBean("user");
		
		//Thus, this new User object is the same User object as the previous one, and is assigned the same Account Bean. 
		System.out.println(u2);
		
		//If we made our User bean "prototype" this would return a new user 
			//See the commented annotation above the user class for this syntax
		
		System.out.println("=======================================(Trying to print beans in the container");
		
		//assign a String Array to the result of the getBeanDefinitionName() method
		String[] beanNames = ac.getBeanDefinitionNames();
		
		//then I print em out
		for (String bean : beanNames) {
			System.out.println(bean);
		}
		
	}
	
}
