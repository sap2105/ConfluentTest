package com.confluent.feedapi.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.confluent.feedapi.model.Article;
import com.confluent.feedapi.model.Feed;
import com.confluent.feedapi.service.ArticleService;

@Path("/")
public class ArticleResource {

	ArticleService articleservice=new ArticleService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Article> getAArt(@PathParam("uid") int uid,@PathParam("feedid") int feedid) {
		return articleservice.getAArticle(uid,feedid);
	}
	
	@Path("{fromfid}/{tofid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Article> getAsetArt(@PathParam("fromfid") int fromfid,
			@PathParam("tofid") int tofid,@PathParam("uid") int uid) {
		return articleservice.getAsetofArticle(fromfid, tofid, uid);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addArt(@PathParam("feedid") int fid,String desc) {
		return articleservice.addArticle(fid, desc);
	}
}
