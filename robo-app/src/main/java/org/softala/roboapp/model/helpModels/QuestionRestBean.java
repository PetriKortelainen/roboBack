package org.softala.roboapp.model.helpModels;

import java.io.Serializable;
import java.util.List;

/**
 * @author team3
 *
 */
public class QuestionRestBean implements Serializable{
	String questionText;
	String answerType;
	List<AnswerRestBean> answers;
	
	public QuestionRestBean(String questionText, String answerType,
			List<AnswerRestBean> answers) {
		super();
		this.questionText = questionText;
		this.answerType = answerType;
		this.answers = answers;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getAnswerType() {
		return answerType;
	}
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}
	public List<AnswerRestBean> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerRestBean> answers) {
		this.answers = answers;
	}
}
