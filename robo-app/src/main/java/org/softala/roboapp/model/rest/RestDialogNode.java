package org.softala.roboapp.model.rest;

import java.io.Serializable;
import java.util.List;

/**
 * @author team3
 * 
 * Model for the front-end's questions and answers.
 *
 */
public class RestDialogNode implements Serializable{
	
	private static final long serialVersionUID = -2574003604889633017L;
	private String answerText;
	private int answerOrderIndex;
	String questionText;
	String answerType;
	List<RestDialogNode> nodes;
	
	public RestDialogNode(String answerText, int answerOrderIndex,
			String questionText, String answerType,
			List<RestDialogNode> nodes) {
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
	public List<RestDialogNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<RestDialogNode> nodes) {
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
