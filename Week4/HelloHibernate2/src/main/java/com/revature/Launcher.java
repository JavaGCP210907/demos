package com.revature;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.daos.DirectorDao;
import com.revature.daos.MovieDao;
import com.revature.models.Director;
import com.revature.models.Movie;
import com.revature.utils.HibernateUtil;

public class Launcher {

//CHANGES MADE SINCE THE ORIGINAL HELLOHIBERNATE:
	//added a field in Director to reference Movie with a OneToMany relationship (for many-to-many functionality)
		//Thus changing boilerplate code for Director
	//created the DirectorDao
	//fixed the infinite loop by changing the Movie Class's toString
	//did some more experiments in the Launcher
	//hbm2ddl.auto changed to update
	
	//Ben will figure out how to hide database credentials in environment variables
	
	
	
	//we're going to use the main method to insert Movies into our DB
	public static void main(String[] args) {
		
		MovieDao mDao = new MovieDao();
		DirectorDao dDao = new DirectorDao();
		
		/*
		try(Session ses = HibernateUtil.getSession()){
			System.out.println("Hello you have a Connection to your DB with Hibernate!");
			HibernateUtil.closeSession(); //if you want to leave this connection test in, close the session within the try
		} catch (HibernateException e) {
			System.out.println("DB connection failed!!");
		}
		 */
		
		//creating some directors
		Director d1 = new Director("Stewart", "Hendler", 1978, null);
		Director d2 = new Director("Quentin", "Tarantino", 1963, null);
		Director d3 = new Director("David", "Lynch", 1946, null);
		//why null? The filmography field will get populated once we attach Movies to Directors
		
		//creating some movies
		Movie m1 = new Movie("Forward Unto Dawn", "Action/Sci-FI", d1);
		Movie m2 = new Movie("Pulp Fiction", "Drama", d2);
		Movie m3 = new Movie("Blue Velvet", "Mystery/Thriller", d3);
		
		//insert our new movies into the database
		mDao.insertMovie(m1);
		mDao.insertMovie(m2);
		mDao.insertMovie(m3);
		//mDao.insertMovie(m1);
		//mDao.insertMovie(m2);
		
		//retrieve our Movies from the DB
		List<Movie> allMovies = mDao.findAllMovies();
		
		for(Movie m : allMovies) {
			System.out.println(m);
		}
		
		
		Movie m4 = new Movie("Django Unchained", "Drama", d2);
		
		mDao.insertMovie(m4);
		
		List<Director> allDirectors = dDao.findAllDirectors();
		
		for(Director d : allDirectors) {
			System.out.println(d);
		}
		
//		//finding movie by id
//		System.out.println(mDao.findMovieById(1));
//		
//		//updating movie
//		m1.setTitle("OOGABOOGABOOGABOOGA");
//		
//		mDao.updateMovie2(m1);
//		
//		System.out.println(mDao.findMovieById(1));
		
	}

}
