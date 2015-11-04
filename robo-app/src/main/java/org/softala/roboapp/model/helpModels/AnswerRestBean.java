package org.softala.roboapp.model.helpModels;

import java.io.Serializable;

/**
 * @author team3
 *
 */
public class AnswerRestBean implements Serializable{
	private String answerText;
	private int answerOrderIndex;
	private QuestionRestBean question;
	
	public AnswerRestBean(String answerText, int answerOrderIndex,
			QuestionRestBean question) {
		super();
		this.answerText = answerText;
		this.answerOrderIndex = answerOrderIndex;
		this.question = question;
	}
	
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public int getAnswerOrderIndex() {
		return answerOrderIndex;
	}
	public void setAnswerOrderIndex(int answerOrderIndex) {
		this.answerOrderIndex = answerOrderIndex;
	}
	public QuestionRestBean getQuestion() {
		return question;
	}
	public void setQuestion(QuestionRestBean question) {
		this.question = question;
	}

}
