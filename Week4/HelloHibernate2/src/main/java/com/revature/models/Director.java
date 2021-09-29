package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "director_id")
	private int id;
	
	//going to leave the rest of the fiels unannotated for Hibernate to handle itself
	private String firstName;
	private String lastName;
	private int yearBorn;

	@OneToMany(mappedBy="director", fetch=FetchType.EAGER)
	private List<Movie> filmography;
	//what's mappedBy? It's the field in the Movie class that references the Director Class 
	//This is how we can achieve ManyToMany functionality without using @ManyToMany
	
	//boilerplate code below----------------------------------
	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Director(int id, String firstName, String lastName, int yearBorn, List<Movie> filmography) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
		this.filmography = filmography;
	}
	
	public Director(String firstName, String lastName, int yearBorn, List<Movie> filmography) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearBorn = yearBorn;
		this.filmography = filmography;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", yearBorn=" + yearBorn
				+ ", filmography=" + filmography + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filmography == null) ? 0 : filmography.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + yearBorn;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Director other = (Director) obj;
		if (filmography == null) {
			if (other.filmography != null)
				return false;
		} else if (!filmography.equals(other.filmography))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (yearBorn != other.yearBorn)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(int yearBorn) {
		this.yearBorn = yearBorn;
	}

	public List<Movie> getFilmography() {
		return filmography;
	}

	public void setFilmography(List<Movie> filmography) {
		this.filmography = filmography;
	}

	
	
	
}
