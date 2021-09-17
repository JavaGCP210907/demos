package com.revature;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create().start(8090);
		
		//HTTP Handlers below...
		
		//any GET requests to this default endpoint (/) will return this text
		//btw - throwing URLs into a browser sends a GET request. You can search localhost:8090/ and get this text
		app.get("/", ctx -> ctx.result("Hello Javalin! My Application recieved a GET request! how cool ;)"));
		
		//any POST requests sent to this default endpoint (/) will return this text
		//to accomplish a POST request, you'll have to send a POST in postman or have some front end functionality to do so
		app.post("/", ctx -> ctx.result("Hello Javalin! My Application recieved a POST request! how nice ;)"));
		
		//what's ctx? the Context Object! It provides a bunch of methods we need to handle HTTP requests/responses
		
		//This was a basic demo to show Javalin/HTTP Handlers... 
		//USUALLY, we'll see ctx functionality in Controller Classes-
			//We'll send requests off to Controller classes, to return/accept objects instead of just returning text
		
		//of course, Javalin can handle all other kinds of requests - PUT, PATCH, DELETE, etc.
		
	}
	
}
