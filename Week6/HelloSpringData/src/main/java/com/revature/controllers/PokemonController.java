package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.PokemonDAO;
import com.revature.models.Pokemon;

@RestController
@RequestMapping(value="/pokemon")
public class PokemonController {

	private PokemonDAO pDAO;
	
	@Autowired
	public PokemonController(PokemonDAO pDAO) {
		super();
		this.pDAO = pDAO;
	}
	
	//MVC methods below (to handle HTTP requests)-------------------------------------------
	
	//These SHOULD probably call a service layer that's calling these DAO methods
		//so .body() would contain a call to the service method that gets the appropriate object from the DAO
	//but for the sake of time and demonstration, we're calling them from the controller layer
	
	
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAllPokemon(){
		return ResponseEntity.status(200).body(pDAO.findAll());
		//we didn't write this findAll() method!! IT COMES FROM JPAREPOSITORY which our custom interface extends
	}
	
	@PostMapping
	public ResponseEntity addPokemon(@RequestBody Pokemon p) {
		pDAO.save(p);
		return ResponseEntity.status(201).build();
		//we use .build() instead of .body() if we don't intent to send data back
	}
	
	//This method calls the custom DAO method we wrote----
	
	@GetMapping("/{name}") //the name given as a URL endpoint will be the parameter in this method, hence @PathVariable 
	public ResponseEntity<List<Pokemon>> findByName(@PathVariable String name) {
		
		//Remember - an Optional may or may not have the generic, or it may be null. Avoids NullPointerException
		Optional<List<Pokemon>> opt = pDAO.findByName(name);
		
		List<Pokemon> pokeList = null;
		
		if(opt.isPresent()) { //if the Optional has content....
			pokeList = opt.get(); //this is how you get contents out of an optional
		}
		
		return ResponseEntity.ok(pokeList);
		
	}
	
}
