package com.confluent.feedapi.model;

public class Article {
	private int aid;
	private int fid;
	private String articledesc;
	
	public Article() {
		
	}
	
	public Article(int aid, int fid, String desc) {
		this.aid=aid;
		this.fid=fid;
		this.articledesc=desc;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getArticledesc() {
		return articledesc;
	}
	public void setArticledesc(String articledesc) {
		this.articledesc = articledesc;
	}
	
	

}
