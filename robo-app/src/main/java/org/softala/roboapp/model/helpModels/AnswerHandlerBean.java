package org.softala.roboapp.model.helpModels;

import java.io.Serializable;
import java.util.List;

/**
 * @author team1 - Petri Kortelainen
 *
 */

/* 
 * Bean for receaving singular answers from frontend to back
 * Used to save each answer after a click 
 */

public class AnswerHandlerBean implements Serializable{
	String answer_option_id; //id of selected answer
	String session_id;	//session id generated by DB
	String textfieldAnswer; //in case we need to collect an answer from text field to backend
	
	public String getAnswer_option_id() {
		return answer_option_id;
	}
	public void setAnswer_option_id(String answer_option_id) {
		this.answer_option_id = answer_option_id;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}
	public String getTextfieldAnswer() {
		return textfieldAnswer;
	}
	public void setTextfieldAnswer(String textfieldAnswer) {
		this.textfieldAnswer = textfieldAnswer;
	}
	public AnswerHandlerBean(String answer_option_id, String session_id,
			String textfieldAnswer) {
		this.answer_option_id = answer_option_id;
		this.session_id = session_id;
		this.textfieldAnswer = textfieldAnswer;
	}
	public AnswerHandlerBean() {
		this.answer_option_id = "";
		this.session_id = "";
		this.textfieldAnswer = "";
	}
}