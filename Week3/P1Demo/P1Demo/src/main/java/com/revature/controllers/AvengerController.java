package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Avenger;
import com.revature.services.AvengerService;

import io.javalin.http.Handler;

//The Controller layer sits between the Launcher (our Javalin Front Controller) and the Service layer
//This layer is where we'll parse our JSON into Java objects or vice versa
//We'll either be getting data from the service layer (which gets it from the DAO)...
//OR sending data to the service layer (which will validate it and send it to the DAO).
public class AvengerController {
	
	AvengerService as = new AvengerService(); 

	public Handler getAllAvengersHandler = (ctx) -> {
		
		if(ctx.req.getSession(false) != null) { //if a session exists...
		
		//we create an Array with Avenger data (using the service to talk to the dao)
		List<Avenger> allAvengers = as.getAllAvengers();
		
		//instantiate a Gson object to make JSON <-> POJO conversions (POJO - plain old java object)
		Gson gson = new Gson();
		
		String JSONAvengers = gson.toJson(allAvengers); //convert our Java object into a JSON String
		
		ctx.result(JSONAvengers); //return our Avengers
		
		ctx.status(200); //200 = OK (success)
		
		} else {
			ctx.status(403); //forbidden status code 
		}
		
	};


	
}
