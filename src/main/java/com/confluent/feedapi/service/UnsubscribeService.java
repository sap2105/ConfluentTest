package com.confluent.feedapi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.annotation.Generated;

import com.confluent.feedapi.model.Feed;
import com.confluent.feedapi.model.Unsubscribe;

public class UnsubscribeService {

	public String addToUnsubscribe(int uid,int fid) {
		Unsubscribe uns=new Unsubscribe();
		try{  
			  Connection con=DbConnection.getDBconnection(); 
			  Statement stmt=con.createStatement();  
		      String query = " insert into unsubscribe (uid,fid)" + " values (?,?)";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setInt (1, uid);
		      preparedStmt.setInt(2,fid);
		      preparedStmt.execute();
			  con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return "Successfully Unsubscribed to Feed";
	}
	
	public String removeFromUnsubscribe(int uid,int fid) {
		try{  
			Connection con=DbConnection.getDBconnection();
			Statement stmt=con.createStatement();  
		    String query = "delete from unsubscribe where uid=? and fid=?";
		    PreparedStatement preparedStmt = con.prepareStatement(query);
		    preparedStmt.setInt (1, uid);
		    preparedStmt.setInt(2,fid);
		    preparedStmt.execute(); 
			}catch(Exception e){ System.out.println(e);
			}
		return "Successfully Subscribed to Feed";
	}
}
