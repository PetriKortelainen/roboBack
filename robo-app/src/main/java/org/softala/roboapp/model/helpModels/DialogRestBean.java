package org.softala.roboapp.model.helpModels;

import java.io.Serializable;
import java.util.Date;


/**
 * @author team3 (Aleksi Tilli)
 * Used for matching backend's dialog tree with the one in the frontend.
 */
public class DialogRestBean implements Serializable{
	private String dialogName;
	private Date dialogCreated;
	private QuestionRestBean dialogFirstQuestion;
	
	public DialogRestBean(String dialogName, Date dialogCreated,
			QuestionRestBean dialogFirstQuestion) {
		super();
		this.dialogName = dialogName;
		this.dialogCreated = dialogCreated;
		this.dialogFirstQuestion = dialogFirstQuestion;
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
	public QuestionRestBean getDialogFirstQuestion() {
		return dialogFirstQuestion;
	}
	public void setDialogFirstQuestion(QuestionRestBean dialogFirstQuestion) {
		this.dialogFirstQuestion = dialogFirstQuestion;
	}
	
}
