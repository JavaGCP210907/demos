package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Avenger;
import com.revature.utils.ConnectionUtil;

public class AvengerDao implements AvengerInterface {

	@Override
	public List<Avenger> getAllAvengers() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM avengers"; //write out out SQL query
			
			Statement s = conn.createStatement(); //create a Statement object to execute our query
			
			ResultSet rs = s.executeQuery(sql); //put the results of the query into a ResultSet (execute the query into it)
			
			List<Avenger> avengerList = new ArrayList<>(); //empty ArrayList of Avengers
			
			//populate the ArrayList
			while(rs.next()) { //while there are still objects in the resultset
				
				//make a new Avenger object for each row
				Avenger a = new Avenger (
					rs.getInt("av_id"),
					rs.getString("av_name"),
					rs.getString("av_power"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("power_level"),
					null //there is no JDBC method for getHome() right? We'll add it below... JDBC can be clunky	
				);
				
				//if the Avenger DOES have a home...
				if(rs.getString("home_fk") != null) {
					
					//use the setHome method of Avenger to set it equal to the appropriate Home object
					//We need to use a DAO method to get a Home by its name... 
					
				}
				
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("Get all avengers failed :(");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	//leaving these unimplemented (to focus more on frontend-backend communication)
	//you can always look at P0demo for similar implementations of this 
	
	@Override
	public Avenger getAvengerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAvenger(Avenger avenger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAvenger(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
