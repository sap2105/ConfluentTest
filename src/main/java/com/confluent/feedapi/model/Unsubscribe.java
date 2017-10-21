package com.confluent.feedapi.model;

public class Unsubscribe {

	private int uid;
	private int fid;
	
	public Unsubscribe() {
		
	}
	
	public Unsubscribe(int uid, int fid) {
		this.fid=fid;
		this.uid=uid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}
	
	
}
