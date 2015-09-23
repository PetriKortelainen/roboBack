package org.softala.roboapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="hello")
public class Hello {
	//json model yritelma{"id": 1, "content": "Hello, World!"}
	@Id
	private final long id;
	
	@Column(name="content")
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
