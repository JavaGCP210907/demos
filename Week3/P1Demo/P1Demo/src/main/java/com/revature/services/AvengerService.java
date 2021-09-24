package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDao;
import com.revature.models.Avenger;

//The Service layer sits between the controllers and the daos
//We never want the repository/dao layer to touch the web/presentation layer
//There are also times where we want to add more logic like input validation, and the service layer is a good place for it
public class AvengerService {

	//instantiate an AvengerDAO to use its method
	AvengerDao aDao = new AvengerDao();
	
	
	//create a method that gets the DAO data and sends it up to the controller
	//(this method will get called by the controller layer)
	public List<Avenger> getAllAvengers() {
		return aDao.getAllAvengers();
	}
	
	//all we're doing is calling the dao method in order to get a List of all the Avengers to send to the controller
	
}
