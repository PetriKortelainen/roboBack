package org.softala.roboapp.model;
// default package
// Generated Oct 26, 2015 8:47:24 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author Tuomas Törmä, Petri Kortelainen, Harri Stranden
 * 
 * GivenAnswerId generated by hbm2java
 * 
 * ID object from the composite key in given_answer table
 * for use in the GivenAnswer object
 */
@Embeddable
public class GivenAnswerId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -916280044465975402L;
	private String sessionId;
	private int answerOptionId;

	public GivenAnswerId() {
	}

	public GivenAnswerId(String sessionId, int answerOptionId) {
		this.sessionId = sessionId;
		this.answerOptionId = answerOptionId;
	}

	@Column(name = "session_id", nullable = false, length = 128)
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "answer_option_id", nullable = false)
	public int getAnswerOptionId() {
		return this.answerOptionId;
	}

	public void setAnswerOptionId(int answerOptionId) {
		this.answerOptionId = answerOptionId;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GivenAnswerId))
			return false;
		GivenAnswerId castOther = (GivenAnswerId) other;

		return ((this.getSessionId() == castOther.getSessionId()) || (this
				.getSessionId() != null && castOther.getSessionId() != null && this
				.getSessionId().equals(castOther.getSessionId())))
				&& (this.getAnswerOptionId() == castOther.getAnswerOptionId());
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSessionId() == null ? 0 : this.getSessionId().hashCode());
		result = 37 * result + this.getAnswerOptionId();
		return result;
	}

}
