package com.revature.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.models.Account;
import com.revature.models.User;

@Configuration //This is how we specify that a Class is a configuration class for beans
public class Config {
	
	//commented out because we won't configure/wire our beans this way... 
	//but you should know the syntax and that the Configuration Class is a way to do it
	
	
//	@Bean(name = "user")
//	public User getUser() {
//		
//		//return new User();
//		//this reutn^ won't cut it - we need to wire our beans through a constructor with the Account Bean
//		
//		return new User(getAccount()); //we need to make this constructor (autocomplete it via the error)
//	}
//	
//	@Bean(name = "account")
//	public Account getAccount() {
//		return new Account();
//	}
}
