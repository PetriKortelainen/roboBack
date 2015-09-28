package org.softala.roboapp.model;
// default package
// Generated Sep 28, 2015 12:35:36 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * AnswerOption generated by hbm2java
 */
@Entity
@Table(name = "AnswerOption")
public class AnswerOption implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2591599791139173144L;
	
	private AnswerOptionId id;
	private Question question;
	private String text;
	private Integer orderIndex;
	private String nextQuestionId;
	private Boolean setsUserType;
	private Set<GivenAnswer> givenAnswers = new HashSet<GivenAnswer>();

	public AnswerOption() {
	}

	public AnswerOption(AnswerOptionId id, Question question, String text) {
		this.id = id;
		this.question = question;
		this.text = text;
	}
	

	public AnswerOption(AnswerOptionId id, String text, String nextQuestionId, Boolean setsUserType) {
		super();
		this.id = id;
		this.text = text;
		this.nextQuestionId = nextQuestionId;
		this.setsUserType = setsUserType;
	}

	public AnswerOption(AnswerOptionId id, Question question, String text,
			Integer orderIndex, String nextQuestionId, Boolean setsUserType,
			Set<GivenAnswer> givenAnswers) {
		this.id = id;
		this.question = question;
		this.text = text;
		this.orderIndex = orderIndex;
		this.nextQuestionId = nextQuestionId;
		this.setsUserType = setsUserType;
		this.givenAnswers = givenAnswers;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "answerOptionId", column = @Column(name = "answer_option_id", nullable = false, length = 50)),
			@AttributeOverride(name = "questionId", column = @Column(name = "question_id", nullable = false, length = 10)),
			@AttributeOverride(name = "dialogId", column = @Column(name = "dialog_id", nullable = false)) })
	public AnswerOptionId getId() {
		return this.id;
	}

	public void setId(AnswerOptionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "dialog_id", referencedColumnName = "dialog_id", nullable = false, insertable = false, updatable = false) })
	@JsonBackReference
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Column(name = "text", nullable = false, length = 1000)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "order_index")
	public Integer getOrderIndex() {
		return this.orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	@Column(name = "next_question_id", length = 10)
	public String getNextQuestionId() {
		return this.nextQuestionId;
	}

	public void setNextQuestionId(String nextQuestionId) {
		this.nextQuestionId = nextQuestionId;
	}

	@Column(name = "sets_user_type")
	public Boolean getSetsUserType() {
		return this.setsUserType;
	}

	public void setSetsUserType(Boolean setsUserType) {
		this.setsUserType = setsUserType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "answerOption")
	@JsonManagedReference
	public Set<GivenAnswer> getGivenAnswers() {
		return this.givenAnswers;
	}

	public void setGivenAnswers(Set<GivenAnswer> givenAnswers) {
		this.givenAnswers = givenAnswers;
	}

}