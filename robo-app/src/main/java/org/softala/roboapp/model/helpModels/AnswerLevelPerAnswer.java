package org.softala.roboapp.model.helpModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerLevelPerAnswer {
	
	
	private String Question_text;
	private String Answer_text;
	private String retunNumber;
	
	@JsonProperty("question_text")
	public String getQuestion_text() {
		return Question_text;
	}
	
	public void setQuestion_text(String question_text) {
		Question_text = question_text;
	}
	
	@JsonProperty("answer_option_text")
	public String getAnswer_text() {
		return Answer_text;
	}
	
	public void setAnswer_text(String answer_text) {
		Answer_text = answer_text;
	}
	
	@JsonProperty("answers")
	public String getRetunNumber() {
		return retunNumber;
	}
	@Override
	public String toString() {
		return "AnswerLevelPerAnswer [Question_text=" + Question_text
				+ ", Answer_text=" + Answer_text + ", retunNumber="
				+ retunNumber + "]";
	}

	public void setRetunNumber(String retunNumber) {
		this.retunNumber = retunNumber;
	}
	public AnswerLevelPerAnswer(String question_text, String answer_text,
			String retunNumber) {
		super();
		Question_text = question_text;
		Answer_text = answer_text;
		this.retunNumber = retunNumber;
	}
	public AnswerLevelPerAnswer() {
		super();
	}
	
	
	
	
}
