package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
	@AfterReturning(pointcut="execution(String fight(..))", returning = "returnedObject")
	public void logSuccessfulFight(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " returning " + returnedObject);
	}
	
	@AfterThrowing(pointcut="execution(String fight(..))", throwing = "thrownException")
	public void logFailedFight(JoinPoint jp, Exception thrownException) {
		log.warn(jp.getTarget() + " invoked " + jp.getSignature() + " throwing " + thrownException.getClass());
	}
	
}
