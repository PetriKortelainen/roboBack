package org.softala.roboapp.model.rest;


/**
 * @author team3
 * Model for retrieving a list of dialogs without unnecessary fields to the management front-end.
 *
 */
public class RestManagement {
	private int id;
	private String dialogName;
	private boolean enabled;
	
	public RestManagement(int id, String dialogName, boolean enabled) {
		super();
		this.id = id;
		this.dialogName = dialogName;
		this.enabled = enabled;
	}

	public RestManagement() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDialogName() {
		return dialogName;
	}

	public void setDialogName(String dialogName) {
		this.dialogName = dialogName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "ManagementRestBean [id=" + id + ", dialogName=" + dialogName
				+ ", enabled=" + enabled + "]";
	}
}
