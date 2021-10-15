package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Pokemon;

//by extending JpaRepository, we get access to various DAO methods that we don't have to write
//JpaRepository takes 2 generics...
	//The first is the entity being persisted
	//The second is the data type of the primary key (as a wrapper class)
@Repository
public interface PokemonDAO extends JpaRepository<Pokemon, Integer>{

	//an Optional is an object that MAY have whatever the generic is, or it may be null. Avoids NullPointerExceptions
	public Optional<List<Pokemon>> findByName(String name); //for this method to work, the field name must be in camelCase
	
	//we had to define this method signature on our own... JpaRepository can't find by non-id fields
	//BUT Spring Data will create this method body for us, since we provided what it takes in and what it returns
		//It will find us a List of whatever pokemon fit our "name" argument
}
