package com.confluent.feedapi.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.confluent.feedapi.model.User;
import com.confluent.feedapi.service.UnsubscribeService;

@Path("/")
public class UnsubscribeResource {
	
	UnsubscribeService unservice= new UnsubscribeService();
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String addToUns(@PathParam("uid") int uid,@PathParam("feedid") int fid) {
		return unservice.addToUnsubscribe(uid, fid);
	}
	
	@GET
	@Path("cancel")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeFromUns(@PathParam("uid") int uid,@PathParam("feedid") int fid) {
		return unservice.removeFromUnsubscribe(uid, fid);
	}
}
