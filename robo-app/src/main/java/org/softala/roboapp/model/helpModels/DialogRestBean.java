package org.softala.roboapp.model.helpModels;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author team3
 * Used for matching backend's dialog tree with the one in the frontend.
 */
public class DialogRestBean implements Serializable{
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

	private List<DialogNodeRestBean> nodes;
	
	public DialogRestBean(String dialogName, Date dialogCreated,
			List<DialogNodeRestBean> nodes) {
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
	public List<DialogNodeRestBean> getDialogNodes() {
		return nodes;
	}
	public void setDialogNodes(List<DialogNodeRestBean> dialogFirstQuestion) {
		this.nodes = dialogFirstQuestion;
	}

	@Override
	public String toString() {
		return "DialogRestBean [dialogName=" + dialogName + ", dialogCreated="
				+ dialogCreated + ", questionText=" + questionText + ", nodes="
				+ nodes + "]";
	}
	
}
