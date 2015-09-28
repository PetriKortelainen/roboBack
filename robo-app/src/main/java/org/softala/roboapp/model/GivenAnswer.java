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
	private final int id;
	@Column(name = "id_Session")
	private final int id_Session;
	@Column(name = "created")
	private final Date created;
	@Column(name = "question_text")
	private final String question_text;
	@Column(name = "answer_text")
	private final String answer_text;
	
	public GivenAnswer(int id, int id_Session, Date created, String question_text, String answer_text){
		
		this.id = id;		
		this.id_Session = id_Session;		
		this.created = created;		
		this.question_text = question_text;	
		this.answer_text = answer_text;
	}
	
	public int getId() {
		return id;
	}
	
	public int getid_Session() {
		return id_Session;
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
