package org.softala.roboapp.model.rest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author team3
 * 
 * Used for matching backend's dialog tree with the one in the frontend.
 */
public class RestDialog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8511316147350292867L;
	private String dialogName;
	private Date dialogCreated;
	private String questionText;
	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	private List<RestDialogNode> nodes;
	
	public RestDialog(String dialogName, Date dialogCreated,
			List<RestDialogNode> nodes) {
		super();
		this.dialogName = dialogName;
		this.dialogCreated = dialogCreated;
		this.nodes = nodes;
	}
	
	public String getDialogName() {
		return dialogName;
	}
	public void setDialogName(String dialogName) {
		this.dialogName = dialogName;
	}
	public Date getDialogCreated() {
		return dialogCreated;
	}
	public void setDialogCreated(Date dialogCreated) {
		this.dialogCreated = dialogCreated;
	}
	public List<RestDialogNode> getDialogNodes() {
		return nodes;
	}
	public void setDialogNodes(List<RestDialogNode> dialogFirstQuestion) {
		this.nodes = dialogFirstQuestion;
	}

	@Override
	public String toString() {
		return "DialogRestBean [dialogName=" + dialogName + ", dialogCreated="
				+ dialogCreated + ", questionText=" + questionText + ", nodes="
				+ nodes + "]";
	}
	
}
