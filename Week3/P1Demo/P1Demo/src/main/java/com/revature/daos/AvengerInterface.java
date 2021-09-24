package com.revature.daos;

import java.util.List;

import com.revature.models.Avenger;

public interface AvengerInterface {

	public List<Avenger> getAllAvengers();
	
	public Avenger getAvengerById(int id);
	
	public boolean addAvenger(Avenger avenger);
	
	public boolean deleteAvenger(int id);
	
}
