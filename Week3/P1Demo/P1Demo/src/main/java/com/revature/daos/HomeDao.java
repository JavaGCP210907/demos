package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class HomeDao implements HomeInterface {

	@Override
	public Home getHomeByName(String name) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM homes where home_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql); //put our SQL string into a PreparedStatement
			
			ps.setString(1, name); //fill in the parameter
			
			ResultSet rs = ps.executeQuery(); //execute our PrepStat into a ResultSet
			
			//we won't need a while loop, we're only expecting one result
			if(rs.next()) {
				
				//Using the Home setters instead of the constructor. 
				//Does the same thing, just wanna show you a different way
				
				Home h = new Home(); //empty home object
				
				//using setters to populate the empty Home object
				h.setHome_name(rs.getString("home_name"));
				h.setHome_address(rs.getString("home_address"));
				h.setHome_city(rs.getString("home_city"));
				h.setHome_state(rs.getString("home_state"));
				h.setHome_zip(rs.getString("home_zip"));
				
				return h; //return the home object
				
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("get home by name failed :*");
			e.printStackTrace();
		}
		
		return null;
	}

}
