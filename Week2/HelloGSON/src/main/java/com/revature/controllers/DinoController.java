package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.dao.DinoDAO;
import com.revature.models.Dinosaur;

import io.javalin.http.Handler;

//Reading path parameters is a controller specific duty
	//path parameters are the different values that can go into the URL of an HTTP Request
//Our launcher will send requests to our controller, which gets the data needed for responses from our DAO.
public class DinoController {

	DinoDAO dDao = new DinoDAO(); //because the controller layer needs to communicate with the DAO layer
	
	//Below we have HTTP Handlers (these tend to belong in the controller layer, unlike in HelloJavalin)
	//HTTP handlers HANDLE incoming HTTP Requests, and potentially send back an HTTP Response
	
	//what's ctx? The Context Object! Provides a bunch of methods that we need to handle HTTP requests
	public Handler getAllDinosHandler = (ctx) -> {
		
		//we create Array with the dino data that we get from the dao
		Dinosaur[] allDinos = dDao.getAllDinos();
		
		//but... we need this to be a JSON object! 
		//We need a Gson object to make JSON <-> Java object conversions
		Gson gson = new Gson();
		
		//convert our Java object (allDinos) into a JSON object using the .toJson() method
		String JSONDinos = gson.toJson(allDinos);
		
		//ctx.result() sends a response back to the client
		ctx.result(JSONDinos); //return our JSON String of Dinos
		
		//set the status code to reflect a successful request
		ctx.status(200); //200 = success
		
	};

	public Handler GetDinoByIdHandler = (ctx) -> {
		
		//take the given path parameter (id) and parse it into an int
		int id = Integer.parseInt(ctx.pathParam("id"));
		
		//get the requested dino using the appropriate dao method
		Dinosaur dino = dDao.getDinoById(id);
		
		//BEN WILL TURN THIS INTO A TRY CATCH FOR ARRAYINDEXOUTOFBOUNDEXCEPTION
		
		if(dino == null) { //if no dino is associated with the given id, do the following...
			
			ctx.result("Dino not found!"); //send back error message
			ctx.status(404); //set "not found" status code
			
		} else { //otherwise, turn the dino into Json, and send it back to the user with ctx.result()
			
			Gson gson = new Gson();
			
			String JSONDino = gson.toJson(dino); //dino object from line 46
			
			ctx.result(JSONDino);
			
			ctx.status(200);
			
		}	
	};

	public Handler createDinoHandler = (ctx) -> {
		
		String body = ctx.body(); //the "body" will contain JSON with the dino information. Turn it into a String
								  //"body" refers to the body of the HTTP request
		
		Gson gson = new Gson();
		
		Dinosaur dino = gson.fromJson(body, Dinosaur.class); //turn the above JSON String into a Java Dinosaur Object
		
		dDao.inputDino(dino); //send the newly created Dinosaur into the DAO
		
		ctx.status(201); //201 = "created"
		
	};
	
	
	
	//BEN WILL MAKE A DELETE DINO HANDLER
	
	
}
