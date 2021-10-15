package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Pokemon;

//by extending JpaRepository, we get access to various DAO methods that we don't have to write
//JpaRepository takes 2 generics...
	//The first is the entity being persisted
	//The second is the data type of the primary key (as a wrapper class)
@Repository
public interface PokemonDAO extends JpaRepository<Pokemon, Integer>{

	
	
}
