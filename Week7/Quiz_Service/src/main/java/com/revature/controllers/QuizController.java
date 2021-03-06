package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Flashcard;
import com.revature.models.Quiz;
import com.revature.repositories.QuizRepository;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizRepository quizDao;
	
	//Remember, RestTemplate is used in Spring MVC to recieve JSON from an external RESTful API.
	//In this way, our microservices can communicate with each other!\
	@Bean //@Bean is NOT a stereotype annotation... It specifes that this is a method that returns a bean.
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	//Now we have a RestTemplate^^^ object that we can use to send HTTP requests
	
	@GetMapping
	public ResponseEntity<List<Quiz>> findAll() {
		List<Quiz> all = quizDao.findAll();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> findById(@PathVariable("id") int id) {
		Optional<Quiz> optional = quizDao.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Quiz> insert(@RequestBody Quiz quiz) {
		int id = quiz.getId();
		
		if(id != 0) {
			return ResponseEntity.badRequest().build();
		}
		
		quizDao.save(quiz);
		return ResponseEntity.status(201).body(quiz);
	}
	
	@GetMapping("/cards")
	public ResponseEntity<List<Flashcard>> getCards() {
		
		//getForObject() will send a GET request to a specified URL, for a specified object type.
		//So here, we're sending a GET request to the Flashcard_Service, which will get all our flashcards.
		List<Flashcard> all = this.restTemplate.getForObject("http://localhost:8082/flashcard", List.class);
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
}
