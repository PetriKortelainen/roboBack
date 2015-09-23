package org.softala.roboapp.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GivenAnswer")
public class GivenAnswer {
	@Id
	@Column(name = "id")
	private final int id;
	@Column(name = "session_id")
	private final int session_id;
	@Column(name = "created")
	private final Date created;
	@Column(name = "question_text")
	private final String question_text;
	@Column(name = "answer_text")
	private final String answer_text;
	
	public GivenAnswer(int id, int session_id, Date created, String question_text, String answer_text){
		
		this.id = id;		
		this.session_id = session_id;		
		this.created = created;		
		this.question_text = question_text;	
		this.answer_text = answer_text;
	}
	
	public int getId() {
		return id;
	}
	
	public int getSession_id() {
		return session_id;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public String getQuestion_text() {
		return question_text;
	}
	
	public String getAnswer_text() {
		return answer_text;
	}
	
}
