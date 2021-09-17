package com.revature;

import com.revature.controllers.DinoController;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		//we need to communicate with the DinoController in order to send requests into our Java logic
		DinoController dc = new DinoController();
		
		//.create() instantiates a Javalin Object, and .start() starts the server, with a given port
		Javalin app = Javalin.create().start(8090);
		
		//We use the Javalin Handlers to send requests to the controllers, or catch errors/exceptions
		
		//error handler to catch 404s
		app.error(404, ctx -> ctx.result("You got a 404! Whatever you're looking for isn't here..."));
		
		
		//GET requests sent to /dinos => returns all dinos
		//this will send a GET request with endpoint /dinos to the getAllDinosHandler, which will get dinos from the DAO
		app.get("/dinos", dc.getAllDinosHandler);
		
		
		
		
		
	}
	
}
