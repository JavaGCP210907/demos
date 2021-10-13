package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.Avenger;

//This Class is where we will handle all of our logging functionality (a cross cutting concern)
//SO much cleaner to put this all in one specific place instead of of all over the application
@Component
@Aspect
public class LoggingAspect {

	//Instantiate a Logger object
	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	@Before("within(com.revature.models.*)") //this advice will run BEFORE and method in any class in the models package
	public void logModelMethods(JoinPoint jp) { //a joinpoint is somewhere an advice COULD be injected. in this case models
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
		//getTarget() returns the object getting called
		//getSignature() gets the method signature
	}
	
	//A pointcut is where advice WILL be injected. In this case, any method called fight() that returns a String
	//The returning attribute is simply giving us access to the returned object from the method (A String in this case)
	//fight(..) means "a method called fight that takes any number of parameters"
	@AfterReturning(pointcut="execution(String fight(..))", returning = "returnedObject")
	public void logSuccessfulFight(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	@AfterThrowing(pointcut="execution(String fight(..))", throwing = "thrownException")
	public void logFailedFight(JoinPoint jp, Exception thrownException) {
		log.warn(jp.getTarget() + " invoked " + jp.getSignature() + " throwing " + thrownException.getClass());
	}
	
	
	//@Around is the most complicated, yet most powerful annotation in AOP
	//with @Around, we don't have to specify pointcut in our parameter
	//Remember - ProceedingJoinPoint is the type of JoinPoint we use with @Around
	@Around("execution(String fight(..))")
	public String logException(ProceedingJoinPoint pjp) throws Throwable {
		Avenger a = (Avenger)pjp.getArgs()[0]; //get the Avenger object from the arguments provided in the fight method
		//why do we have to cast when using pjp.getArgs?
		//it's getting a certain argument from the fight() method... 
			//but can't predict the data type it will be, even though it's defined in the fight() method already
		
		log.info(a.getAveName() + " is about to fight!!");
		double distance = (double)pjp.getArgs()[2]; //get the distance value from the fight method
		
		if(distance < 6) {
			log.warn(a.getAveName() + " I can't let you get close. I'm gonna throw an exception");
			return "Looks like an exception was thrown...";
		} else {
			String s = (String)pjp.proceed(); //This will actually let the fight() method run
			log.info("The fight has concluded");
			return s;
		}
		
	}
	
	
}
