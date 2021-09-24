package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class Launcher {

	public static void main(String[] args) {
		
		//testing whether our connection works...
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("hey there. old friend. you've connected to your database!");
		} catch (SQLException e) {
			System.out.println("hello old friend. your connection failed");
			e.printStackTrace();
		}
		
		
		
	}

}
