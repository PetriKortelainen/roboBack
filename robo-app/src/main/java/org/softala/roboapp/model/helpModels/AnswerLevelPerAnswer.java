package org.softala.roboapp.model.helpModels;

public class AnswerLevelPerAnswer {
	
	private String answer_level;
	private int amount;
	public AnswerLevelPerAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnswerLevelPerAnswer(String answer_level, int amount) {
		super();
		this.answer_level = answer_level;
		this.amount = amount;
	}
	public String getAnswer_level() {
		return answer_level;
	}
	public void setAnswer_level(String answer_level) {
		this.answer_level = answer_level;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
