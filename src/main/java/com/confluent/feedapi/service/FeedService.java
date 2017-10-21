package com.confluent.feedapi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.confluent.feedapi.model.Feed;
import com.confluent.feedapi.model.User;

public class FeedService {

	public List<Feed>getAllFeeds(){
		List<Feed> feedList= new ArrayList<>();
		try{  
			Connection con=DbConnection.getDBconnection(); 
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from feeds");  
			while(rs.next())  {
				Feed f=new Feed(rs.getInt("feedid"),rs.getString("topic"));
			    feedList.add(f);
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return feedList;
	}
	
	public List<Feed>getAllFeeds(int uid){
		List<Feed> feedList= new ArrayList<>();
		try{  
			Connection con=DbConnection.getDBconnection();  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from feeds where feedid not in ( select fid from unsubscribe where uid= "+uid+")");  
			while(rs.next())  {
				Feed f=new Feed(rs.getInt("feedid"),rs.getString("topic"));
			    feedList.add(f);
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return feedList;
	}
	
	//Get a particular user details by passing the user-id;
	public Feed getFeed(int feedid) {
		Feed feed=new Feed();
		try{  
			Connection con=DbConnection.getDBconnection();  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from feeds where feedid="+ feedid);  
			while(rs.next())  {
				feed=new Feed(rs.getInt("feedid"),rs.getString("topic"));
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return feed;
	}
	
	public String addFeed(String topic) {
		Feed feed=new Feed();
		try{  
			Connection con=DbConnection.getDBconnection(); 
			Statement stmt=con.createStatement();  
		    String query = " insert into feeds (topic)" + " values (?)";     
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setString (1, topic);
		    preparedStmt.execute();
			con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return "New Topic Registered in Feeds";
	}
}
