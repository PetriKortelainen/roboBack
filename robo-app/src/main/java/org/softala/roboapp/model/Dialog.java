package org.softala.roboapp.model;
// default package
// Generated Oct 26, 2015 8:47:24 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Dialog generated by hbm2java
 */
@Entity
@Table(name = "Dialog")
public class Dialog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5749228737371876119L;
	private Integer dialogId;
	private String name;
	private boolean enabled;
	private Date created;
	private Set<Question> questions = new HashSet<Question>(0);

	public Dialog() {
	}

	public Dialog(String name, boolean enabled) {
		this.name = name;
		this.enabled = enabled;
	}

	public Dialog(String name, boolean enabled, Date created, Set<Question> questions) {
		this.name = name;
		this.enabled = enabled;
		this.created = created;
		this.questions = questions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "dialog_id", unique = true, nullable = false)
	public Integer getDialogId() {
		return this.dialogId;
	}

	public void setDialogId(Integer dialogId) {
		this.dialogId = dialogId;
	}

	@Column(name = "name", nullable = false, length = 300)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "enabled", nullable = false, columnDefinition = "TINYINT")
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dialog")
	@JsonManagedReference
	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}
