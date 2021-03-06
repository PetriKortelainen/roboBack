package org.softala.roboapp.model;
// default package
// Generated Oct 26, 2015 8:47:24 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Tuomas Törmä, Petri Kortelainen, Harri Stranden
 * 
 * Question generated by hbm2java
 * 
 * Entity mapped to the question table in the database
 */
@Entity
@Table(name = "Question")
public class Question implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7490821130241285211L;
	private Integer questionId;
	private Dialog dialog;
	private String text;
	private String answerType;
	private Set<AnswerOption> answerOptions = new HashSet<AnswerOption>();

	public Question() {
	}

	public Question(Dialog dialog, String text, String answerType) {
		this.dialog = dialog;
		this.text = text;
		this.answerType = answerType;
	}

	public Question(Dialog dialog, String text, String answerType,
			Set<AnswerOption> answerOptions) {
		this.dialog = dialog;
		this.text = text;
		this.answerType = answerType;
		this.answerOptions = answerOptions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "question_id", unique = true, nullable = false)
	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dialog_id", nullable = false)
	@JsonBackReference
	public Dialog getDialog() {
		return this.dialog;
	}

	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}

	@Column(name = "text", nullable = false, length = 1000)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "answer_type", nullable = false, length = 16)
	public String getAnswerType() {
		return this.answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	@JsonManagedReference
	public Set<AnswerOption> getAnswerOptions() {
		return this.answerOptions;
	}

	public void setAnswerOptions(Set<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}

}
