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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Closing generated by hbm2java
 */
@Entity
@Table(name = "Closing")
public class Closing implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7713748499593318532L;
	private Integer closingId;
	private String text;
	private String productUrl;
	private String toEmail;
	private Set<AnswerOption> answerOptions = new HashSet<AnswerOption>(0);

	public Closing() {
	}

	public Closing(String text) {
		this.text = text;
	}

	public Closing(String text, String productUrl, String toEmail,
			Set<AnswerOption> answerOptions) {
		this.text = text;
		this.productUrl = productUrl;
		this.toEmail = toEmail;
		this.answerOptions = answerOptions;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "closing_id", unique = true, nullable = false)
	public Integer getClosingId() {
		return this.closingId;
	}

	public void setClosingId(Integer closingId) {
		this.closingId = closingId;
	}

	@Column(name = "text", nullable = false, length = 2000)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "product_url", length = 2083)
	public String getProductUrl() {
		return this.productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	@Column(name = "to_email", length = 254)
	public String getToEmail() {
		return this.toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "closing")
	@JsonBackReference
	public Set<AnswerOption> getAnswerOptions() {
		return this.answerOptions;
	}

	public void setAnswerOptions(Set<AnswerOption> answerOptions) {
		this.answerOptions = answerOptions;
	}

}
