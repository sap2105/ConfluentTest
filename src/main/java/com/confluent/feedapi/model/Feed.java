package com.confluent.feedapi.model;

public class Feed {
	private int feedid;
	private String topic;
	
	public Feed() {
		
	}
	
	public Feed(int feedid, String topic) {
		this.feedid=feedid;
		this.topic=topic;
	}
	
	public int getFeedid() {
		return feedid;
	}
	public void setFeedid(int feedid) {
		this.feedid = feedid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	

}
