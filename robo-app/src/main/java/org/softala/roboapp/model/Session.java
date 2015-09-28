package org.softala.roboapp.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Session")
public class Session {
	@Id
	private final int id;
	@Column(name="user_type")
	private final String user_type;
	@Column(name="created")
	private final Date created;
	@Column(name="answers_given")
	private final int answers_given;
	@Column(name="completed")
	private final int completed;
		
	public Session(int id, String user_type, Date created, int answers_given, int completed){
		this.id = id;
		this.user_type = user_type;
		this.created = created;
		this.answers_given = answers_given;
		this.completed = completed;
	}

	public int getId() {
		return id;
	}

	public String getUser_type() {
		return user_type;
	}

	public Date getCreated() {
		return created;
	}

	public int getAnswers_given() {
		return answers_given;
	}

	public int getCompleted() {
		return completed;
	}
}
