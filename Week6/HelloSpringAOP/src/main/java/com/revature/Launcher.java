package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

public class Launcher {

	public static void main(String[] args) {
		
		//Instantiate an ApplicationContext so we can use our beans
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		//Instantiate an AvengerDAo object by getting the Bean for it
		//Notice we specify AvengerDAO.class, which is apparently better practice than casting. 
		AvengerDAO aDAO = ac.getBean(AvengerDAO.class);
		
		//Make a new Avenger object using the DAO method to get by ID
		Avenger a = aDAO.getById(4);
		
		System.out.println(a);

		//Make a new Avenger object by getting the Bean, and filling it with values
		Avenger a2 = ac.getBean(Avenger.class);
		
		a2.setAveId(6);
		a2.setAveName("BeanGuy");
		a2.setFirstName("Ben");
		a2.setLastName("Petruzziello");
		a2.setPower("Indifference");
		a2.setPowerLevel(22222222);
		
		System.out.println(a2);
		
		System.out.println("=========================================================================");
		
		//using the fight() method, once to return successfully, and once to thrown an exception
		System.out.println(aDAO.fight(a2, "It do not matter", 300));
		
		try{
			System.out.println(aDAO.fight(a2, "I'll do it later", 2));
		} catch (ArithmeticException e) {
			System.out.println("Caught an exception heheh");
		}
		
	}

}
