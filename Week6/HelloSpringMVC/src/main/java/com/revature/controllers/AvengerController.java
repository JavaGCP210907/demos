package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.daos.AvengerDAO;
import com.revature.models.Avenger;

@Controller //This stereotype annotation is for Controller Class beans, but in MVC it adds all the MVC functionality too
@RequestMapping(value="/avenger") //all requests ending in /avenger will come to this Controller
@CrossOrigin //This will act as a CORS filter, allowing requests from any origin
public class AvengerController {

	private AvengerDAO aDAO;
	
	@Autowired //we want a constructor with only the AvengerDAO so we can use constructor injection and use its methods
	public AvengerController(AvengerDAO dao) {
		super();
		this.aDAO = dao;
	}
	
	//now let's declare some methods to handle HTTP Requests------------------------
	
	
	//get all avengers
	@RequestMapping(method=RequestMethod.GET) //Ensures any GET request to /avenger (which is specified above) goes here
	@ResponseBody //this makes sure that any data sent back in the body is in JSON format
	public List<Avenger> assemble(){
		return Arrays.asList(aDAO.getAll());
	}
		
	//get avenger by id
	@GetMapping("/{id}") //GetMapping will specify that GET requests with the /avenger url go here
	//But here, we've added a path parameter. so if a GET request is sent to /avenger/(number), this method will take it
		//@PathVariable will allow you to get the path variable sent in with the URL (id in this case)
	//Spring has an object called ResponseEntity that lets us set things like the status code and body of our response 
	public ResponseEntity<Avenger> getOneAvenger(@PathVariable("id") int id){
		Avenger a = aDAO.getById(id);
		
		if(a == null) { //if getById fails...
			//send back an empty body with a "no content" (204) status code
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(a);
		} 
		
		//If the "if" doesn't run, send back the Avenger in the body of the response and an OK (200) status code
		return ResponseEntity.ok(a); // <-This is the shorthand for: return ResponseEntity.status(HttpStatus.OK).body(a);
	}
	
	//update avenger
	@PutMapping //any HTTP PUT request ending in /avenger will go here
			//@RequestBody converts JSON from the request into an object we specify. Like @ResponseBody, but for requests
	public ResponseEntity<Avenger> updateAvenger(@RequestBody Avenger a){
		
		if(a == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(a); 
		}
		
		a = aDAO.update(a); //take the incoming avenger object, and send it to the DAO
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
		
	}
	
	
}
