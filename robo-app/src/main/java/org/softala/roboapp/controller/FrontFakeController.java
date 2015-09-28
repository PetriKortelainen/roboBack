package org.softala.roboapp.controller;

import java.util.Date;
import java.util.Hashtable;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.AnswerOptionId;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.QuestionId;
import org.softala.roboapp.model.ToFrontend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/FrontFake")
public class FrontFakeController {
	/*Imagination of controller, returns JSON to front software.
	 Data doesn't come from server! */
	
	/**
	 * 
	 * Had to remake this method in order to get relations to work, please check if needs to be remake
	 */
	@RequestMapping("/getTree")
	public ToFrontend getTree(){
		ToFrontend toFrontEnd = new ToFrontend();
		Dialog dialog = new Dialog();
		dialog.setDialogId(1);
		dialog.setEnabled(true);
		dialog.setName("Tree 1");
		dialog.setCreated(new Date());
		
		AnswerOptionId a_id = new AnswerOptionId("A2", "Q1", 1);
		QuestionId q_id=new QuestionId("Q2", 1);
		
		AnswerOption AnswerOption = new AnswerOption(a_id, "text", "Q2", false);
		
		Question question = new Question(q_id, "Oletko esimerkki", "checkbox");
		
		question.getAnswerOptions().add(AnswerOption);
		dialog.getQuestions().add(question);
		
		toFrontEnd.getQuestionList().add(question);
		toFrontEnd.getAnswerList().add(AnswerOption);
		
		return toFrontEnd;
	}
	
	@RequestMapping("/postAnswer")
	public void postAnswer(){
		//receive a single answer from front end and post it to server log
		return;
	}
	
	@RequestMapping("/getSingle")
	public void getSingle(){
		//returns a single sales dialogue report to front end as JSON
		return;
	}
	
	@RequestMapping("/getAll")
	public void getAll(){
		//returns summary of all sales dialogues to front end as JSON
		return;
	}

}
