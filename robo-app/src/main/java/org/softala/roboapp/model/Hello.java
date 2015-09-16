package org.softala.roboapp.model;

public class Hello {
	//json model yritelma{"id": 1, "content": "Hello, World!"}
	private final long id;
	private final String content;
	
	public Hello(long id, String content){
		this.id = id;
		this.content = content;
	}
	
	public long getId(){
		return id;
	}
	public String getContent(){
		return content;
	}
}
