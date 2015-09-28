package org.softala.roboapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {
	@Id
	private final String id;
	@Column(name = "text")
	private final String text;
	@Column(name = "enabled")
	private final boolean enabled;
	@Column(name = "answer_type")
	private final String answer_type;
	
	public Question(String id, String text, boolean enabled, String answer_type){
		this.id= id;
		this.text = text;
		this.enabled = enabled;
		this.answer_type = answer_type;
	}
	
	
	public String getId() {
		return id;
	}
	
	
	public String getText() {
		return text;
	}
	
	
	public boolean isEnabled() {
		return enabled;
	}
	
	
	public String getAnswer_type() {
		return answer_type;
	}
	
}
