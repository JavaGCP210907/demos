package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "movies") //This isn't a necessary annotation, but without it, Hibernate would call the table "Movie"
public class Movie {

	@Id //This makes this field the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //This will make our PK serial
	@Column(name = "movie_id")
	private int id;
	
	@Column(name = "movie_title", nullable = false) //we set a not null constraint here - movies need titles!
	private String title;
	
	@Column(name = "movie_genre")
	private String genre;
	
	private Director director;
	
}
