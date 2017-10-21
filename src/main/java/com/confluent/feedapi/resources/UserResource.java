package com.confluent.feedapi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.confluent.feedapi.model.User;
import com.confluent.feedapi.service.UserService;

@Path("user")
public class UserResource {
	
	UserService userservice= new UserService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser() {
		return userservice.getAllUsers();
	}
	
	@GET
	@Path("{uid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getAuser(@PathParam("uid") int uid) {
		return userservice.getUser(uid);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(String uname) {
		return userservice.addUser(uname);
	}
	
	@Path("{uid}/feeds")
	public FeedResource getFeedResource() {
		return new FeedResource();
	}
		
	@Path("{uid}/feeds/{feedid}/article")
	public ArticleResource getArticleResource() {
		return new ArticleResource();
	}
	
	@Path("{uid}/feeds/{feedid}/unsubscribe")
	public UnsubscribeResource getUnsubscribeResource() {
		return new UnsubscribeResource();
	}

}
