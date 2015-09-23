package org.softala.roboapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AnswerOption")
public class AnswerOption {
	@Id
	@Column(name = "id")
	private final String id;
	@Column(name = "id_Question")
	private final String id_Question;
	@Column(name = "text")
	private final String text;
	@Column(name = "order_index")
	private final String order_index;
	@Column(name = "id_next_question")
	private final String id_next_question;
	@Column(name = "enabled")
	private final boolean enabled;
	@Column(name = "sets_user_type")
	private final boolean sets_user_type;
	
	public AnswerOption(String id, String id_Question, String text, String order_index, String id_next_question, boolean enabled, boolean sets_user_type){
		this.id = id;
		this.id_Question = id_Question;
		this.text = text;
		this.order_index = order_index;
		this.id_next_question = id_next_question;
		this.enabled = enabled;
		this.sets_user_type = sets_user_type;
		
	}
	
	public String getId() {
		return id;
	}	
	
	public String getId_Question() {
		return id_Question;
	}
	
	public String getText() {
		return text;
	}
	
	public String getOrder_index() {
		return order_index;
	}
	
	public String getId_next_question() {
		return id_next_question;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public boolean isSets_user_type() {
		return sets_user_type;
	}
}
