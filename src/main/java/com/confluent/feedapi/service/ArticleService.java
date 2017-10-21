package com.confluent.feedapi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.confluent.feedapi.model.Article;
import com.confluent.feedapi.model.Feed;

public class ArticleService {
	
	public List<Article> getAArticle(int uid, int fid){
		List<Article> articleList= new ArrayList<>();
		 try {
			 	Connection con=DbConnection.getDBconnection();  
			 	Statement stmt=con.createStatement();  
			 	ResultSet rs=stmt.executeQuery("select * from article where fid= "+ fid +" and fid not in (select fid from unsubscribe where uid= "+uid+")");
			 	while(rs.next()) {
			 		Article a=new Article(rs.getInt("aid"),rs.getInt("fid"),rs.getString("articledesc"));
			 		articleList.add(a);
			 	}
		 }catch (Exception e) {
				System.out.println(e);
		 }
		return articleList;
	}
	
	public String addArticle(int fid,String desc) {
		Article article=new Article();
		try{  
				Connection con=DbConnection.getDBconnection(); 
				Statement stmt=con.createStatement();  
		        String query = " insert into article (fid,articledesc)" + " values (?,?)";
		        PreparedStatement preparedStmt = con.prepareStatement(query);
		        preparedStmt.setInt (1, fid);
		        preparedStmt.setString (2, desc);
		        preparedStmt.execute();
		        con.close();  
			}catch(Exception e){ System.out.println(e);
			}
		return "New article added to Feed";
	}
	
	public List<Article>getAsetofArticle(int fromfid, int tofid,int uid){
		List<Article> articleList= new ArrayList<>();
		try{  
			Connection con=DbConnection.getDBconnection();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from article where fid between "+fromfid+" and "+tofid+" and fid not in (select fid from unsubscribe where uid= "+uid+")");
			if(rs.getMetaData().getColumnCount()>0) {
			while(rs.next())  {
				Article a=new Article(rs.getInt("aid"),rs.getInt("fid"),rs.getString("articledesc"));
			    articleList.add(a);
			}
			}
			else 
			{
				Article a=new Article(0,0, "Not Subscribed to any Feed");
				articleList.add(a);
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);
		}
		return articleList;
	}

}
