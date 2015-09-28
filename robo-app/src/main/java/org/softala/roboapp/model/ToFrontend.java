package org.softala.roboapp.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ToFrontend")
public class ToFrontend {
	// model that creates JSON
	
	@Id
	private final long id;
	
	@Column(name="Question")
	ArrayList<Question> QuestionList = new ArrayList();
	
	@Column(name="Answer")
	ArrayList<AnswerOption> AnswerList = new ArrayList();
	
	public ToFrontend() {
		super();
		this.id = 1;
		QuestionList = new ArrayList();
		AnswerList = new ArrayList();
	}	
	
	public AnswerOption getAnswer(int number){
		//TODO
		AnswerOption answer_option = new AnswerOption();
		return answer_option;
	}
	
	public void addAnswer(AnswerOption AnswOpt){
		this.AnswerList.add(AnswOpt);
		return;
	}

	public Question getQuestion(int number){
		//TODO
		Question q = new Question();
		
		return q;
	}
	public void addQuestion(Question q){
		this.QuestionList.add(q);
	}
	
	public ArrayList<Question> getQuestionList(){
		//return arraylist !!temporary solution!!
		return this.QuestionList;
	}
	public ArrayList<AnswerOption> getAnswerList(){
		//return arraylist !!temporary solution!!
		return this.AnswerList;
	}
}
