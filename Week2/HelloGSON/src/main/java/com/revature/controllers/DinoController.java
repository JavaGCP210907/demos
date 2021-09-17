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
		
		//this try/catch isn't fully necessary, but it's a nice exception handling touch...
		
		try { //try to turn the dino into JSON, and send it back to the user with ctx.result()
			
			//get the requested dino using the appropriate dao method
			Dinosaur dino = dDao.getDinoById(id);
			
			Gson gson = new Gson();
			
			String JSONDino = gson.toJson(dino); //dino object from line 46
			
			ctx.result(JSONDino);
			
			ctx.status(200);

			
		} catch(ArrayIndexOutOfBoundsException e) { //otherwise, 
			
			ctx.result("Dino ID not found!"); //send back error message
			ctx.status(400); //set "bad request" status code
			//note that you can set the status code to whatever you want... this could be a 404/401/403 and function the same
			
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
	
	
	public Handler deleteDinoByIdHandler = (ctx) -> {
		
		int id = Integer.parseInt(ctx.pathParam("id")); //take the given path param (id) and parse it into an int
		
		Dinosaur[] newArr = dDao.deleteDinoById(id);	
        	
		//the below code is optional for delete functionality... can you tell what it does?
		
		//it sends back the new array of dinos (minus the deleted one) back to the client.
		
        Gson gson = new Gson();
        
        String JSONDinoArr = gson.toJson(newArr);
        
        ctx.result(JSONDinoArr);
        
        ctx.status(200);
		
	};
	
	
}
