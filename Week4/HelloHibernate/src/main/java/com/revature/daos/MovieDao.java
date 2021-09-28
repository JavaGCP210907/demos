package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Movie;
import com.revature.utils.HibernateUtil;

public class MovieDao {

	//Hibernate DAO Classes incorporate the session object methods to create/manipulate DB data
	//read up on the session methods in the notes to understand what's doing what here
	
	public void insertMovie(Movie movie) {
		
		//open a Session object to establish a DB connection
		Session ses = HibernateUtil.getSession(); //similar to opening a Connection with JDBC
		
		ses.save(movie); 
		
		HibernateUtil.closeSession();
		
		//This is the ENTIRE insert method - much cleaner than JDBC :)
		//no try/catch? well, we aren't really writing any SQL that could go wrong. Simply using sessions methods
		
	}
	
	public List<Movie> findAllMovies(){
		
		Session ses = HibernateUtil.getSession();
		
		//Using HQL! Hibernate Query Language. It references Java Classes, not DB entities
		List<Movie> movieList = ses.createQuery("FROM Movie").list();
		
		HibernateUtil.closeSession();
		
		return movieList;
	
	}
	
	
	public Movie findMovieById(int id){
		
		Session ses = HibernateUtil.getSession();
		
		Movie movie = ses.get(Movie.class, id);
		
		HibernateUtil.closeSession();
		
		return movie;
		
	}
	
	
	public Movie updateMovie(Movie movie) {
		
		Session ses = HibernateUtil.getSession();
		
		return (Movie)ses.merge(movie);
		//update would throw an exception is the movie object already existed
		//hence why I say merge is less error prone
		
		
		
	}
	
	
	
}
