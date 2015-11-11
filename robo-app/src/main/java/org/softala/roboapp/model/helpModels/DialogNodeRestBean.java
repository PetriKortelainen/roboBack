package org.softala.roboapp.model.helpModels;

import java.io.Serializable;
import java.util.List;

public class DialogNodeRestBean implements Serializable{
	private String answerText;
	private int answerOrderIndex;
	String questionText;
	String answerType;
	List<DialogNodeRestBean> nodes;
	
	public DialogNodeRestBean(String answerText, int answerOrderIndex,
			String questionText, String answerType,
			List<DialogNodeRestBean> nodes) {
		super();
		this.answerText = answerText;
		this.answerOrderIndex = answerOrderIndex;
		this.questionText = questionText;
		this.answerType = answerType;
		this.nodes = nodes;
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
	public List<DialogNodeRestBean> getNodes() {
		return nodes;
	}
	public void setNodes(List<DialogNodeRestBean> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "DialogNodeRestBean [answerText=" + answerText
				+ ", answerOrderIndex=" + answerOrderIndex + ", questionText="
				+ questionText + ", answerType=" + answerType + ", nodes="
				+ nodes + "]";
	}
}
