package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAllPokemon(){
		return ResponseEntity.status(200).body(pDAO.findAll());
		//we didn't write this findAll() method!! IT COMES FROM JPAREPOSITORY which our custom interface extends
	}
	
	
	
}
