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
 * AnswerOption generated by hbm2java
 */
@Entity
@Table(name = "AnswerOption")
public class AnswerOption implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7549264608017777744L;
	private Integer answerOptionId;
	private Question question;
	private Closing closing;
	private String text;
	private int orderIndex;
	private Integer nextQuestionId;
	private Set<GivenAnswer> givenAnswers = new HashSet<GivenAnswer>(0);

	public AnswerOption() {
	}

	public AnswerOption(Question question, int orderIndex) {
		this.question = question;
		this.orderIndex = orderIndex;
	}

	public AnswerOption(Question question, Closing closing, String text,
			int orderIndex, Integer nextQuestionId, Set<GivenAnswer> givenAnswers) {
		this.question = question;
		this.closing = closing;
		this.text = text;
		this.orderIndex = orderIndex;
		this.nextQuestionId = nextQuestionId;
		this.givenAnswers = givenAnswers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "answer_option_id", unique = true, nullable = false)
	public Integer getAnswerOptionId() {
		return this.answerOptionId;
	}

	public void setAnswerOptionId(Integer answerOptionId) {
		this.answerOptionId = answerOptionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false)
	@JsonBackReference
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "closing_id")
	@JsonBackReference
	public Closing getClosing() {
		return this.closing;
	}

	public void setClosing(Closing closing) {
		this.closing = closing;
	}

	@Column(name = "text", length = 1000)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "order_index", nullable = false)
	public int getOrderIndex() {
		return this.orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	@Column(name = "next_question_id")
	public Integer getNextQuestionId() {
		return this.nextQuestionId;
	}

	public void setNextQuestionId(Integer nextQuestionId) {
		this.nextQuestionId = nextQuestionId;
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
