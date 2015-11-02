package org.softala.roboapp.model;
// default package
// Generated Oct 26, 2015 8:47:24 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * GivenAnswer generated by hbm2java
 */
@Entity
@Table(name = "GivenAnswer")
public class GivenAnswer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4822563740350712729L;
	private GivenAnswerId id;
	private Session session;
	private AnswerOption answerOption;
	private Date created;

	public GivenAnswer() {
	}

	public GivenAnswer(GivenAnswerId id, Session session,
			AnswerOption answerOption) {
		this.id = id;
		this.session = session;
		this.answerOption = answerOption;
	}

	public GivenAnswer(GivenAnswerId id, Session session,
			AnswerOption answerOption, Date created) {
		this.id = id;
		this.session = session;
		this.answerOption = answerOption;
		this.created = created;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "sessionId", column = @Column(name = "session_id", nullable = false, length = 128)),
			@AttributeOverride(name = "answerOptionId", column = @Column(name = "answer_option_id", nullable = false)) })
	public GivenAnswerId getId() {
		return this.id;
	}

	public void setId(GivenAnswerId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "session_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "answer_option_id", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	public AnswerOption getAnswerOption() {
		return this.answerOption;
	}

	public void setAnswerOption(AnswerOption answerOption) {
		this.answerOption = answerOption;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
