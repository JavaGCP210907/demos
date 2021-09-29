package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Director;
import com.revature.utils.HibernateUtil;

public class DirectorDao {

	public List<Director> findAllDirectors(){
		
		Session ses = HibernateUtil.getSession();
		
		List<Director> directorList = ses.createQuery("FROM Director").list();
		//We're using HQL, so we refer to the Director Class instead of the directors table
		
		HibernateUtil.closeSession();
		
		return directorList;
	}
	
}
