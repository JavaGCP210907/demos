package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AvengerController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		AvengerController ac = new AvengerController(); //to get access to the HTTP Handlers in the controller layer
		
		//testing whether our connection works...
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("hey there. old friend. you've connected to your database!");
		} catch (SQLException e) {
			System.out.println("hello old friend. your connection failed");
			e.printStackTrace();
		}
		
		
		//.create() instantiates a Javalin object, and .start() starts the server (you can use any free port)
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(8090);
		
		//We use javalin to expose API endpoints, which HTTP can send Requests to, in order to get a Response 
		
		//GET all avengers
		//GET /avengers => return all Avengers
		app.get("/avengers", ac.getAllAvengersHandler);
		
		//GET avenger by id
		
		
		//insert avenger into the Database (POST)
		
		
		//delete an avenger (DELETE)
		
		
	}

}
