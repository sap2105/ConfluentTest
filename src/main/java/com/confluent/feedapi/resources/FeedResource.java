package com.confluent.feedapi.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.confluent.feedapi.model.Feed;
import com.confluent.feedapi.service.FeedService;

	
@Path("{parameter: feeds|/}")
public class FeedResource {

	FeedService feedservice= new FeedService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Feed> getFeed(@PathParam("uid") int uid) {
		return feedservice.getAllFeeds(uid);
	}
	
	@GET
	@Path("{feedid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Feed getAfeed(@PathParam("feedid") int feedid) {
		return feedservice.getFeed(feedid);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addFeed(String topic) {
		return feedservice.addFeed(topic);
	}
	
	
}
