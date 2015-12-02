package org.softala.roboapp.model;
// default package
// Generated Oct 26, 2015 8:47:24 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Tuomas Törmä, Petri Kortelainen, Harri Stranden
 * 
 * Session generated by hbm2java
 * 
 * Entity mapped to the session table in the database
 */
@Entity
@Table(name = "Session")
public class Session implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1442354598161023444L;
	private String sessionId;
	private Date created;
	private Set<GivenAnswer> givenAnswers = new HashSet<GivenAnswer>();

	public Session() {
	}

	public Session(String sessionId) {
		this.sessionId = sessionId;
	}

	public Session(String sessionId, Date created, Set<GivenAnswer> givenAnswers) {
		this.sessionId = sessionId;
		this.created = created;
		this.givenAnswers = givenAnswers;
	}

	@Id
	@Column(name = "session_id", unique = true, nullable = false, length = 128)
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
	@JsonManagedReference
	public Set<GivenAnswer> getGivenAnswers() {
		return this.givenAnswers;
	}

	public void setGivenAnswers(Set<GivenAnswer> givenAnswers) {
		this.givenAnswers = givenAnswers;
	}

}
