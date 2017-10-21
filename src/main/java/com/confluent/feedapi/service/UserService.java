package com.confluent.feedapi.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.confluent.feedapi.model.User;

public class UserService {

	//Get the entire list of all the Users;
	public List<User>getAllUsers(){
		List<User> userList= new ArrayList<>();
		try{  
			Connection con=DbConnection.getDBconnection();  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user");  
			while(rs.next())  {
				User u=new User(rs.getInt("uid"),rs.getString("uname"));
			    userList.add(u);
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return userList;
	}
	
	//Get a particular user details by passing the user-id;
	public User getUser(int id) {
		User user=new User();
		try{  
			Connection con=DbConnection.getDBconnection();  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user where uid="+ id);  
			while(rs.next())  {
				user=new User(rs.getInt("uid"),rs.getString("uname"));
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return user;
	}
	
	//Add a new user; We assume that all new users subscribe to all the feeds;
	public String addUser(String uname) {
		User user=new User();
		try{  
				Connection con=DbConnection.getDBconnection();  
				Statement stmt=con.createStatement();  
			    String query = " insert into user (uname)" + " values (?)";
			    PreparedStatement preparedStmt = con.prepareStatement(query);
			    preparedStmt.setString (1, uname);
			    preparedStmt.execute();
				con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return "New User Registered";
	}
}
