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
	
}
