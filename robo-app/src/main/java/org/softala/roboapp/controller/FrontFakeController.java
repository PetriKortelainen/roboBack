package org.softala.roboapp.controller;

import java.util.Hashtable;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Question;
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
	
	
	@RequestMapping("/getTree")
	public ToFrontend getTree(){
		//returns whole dialogue tree in JSON
		Question question1 = new Question("1","Oletko maanviljelijä?", true, "choice");
		Question question2 = new Question("2", "Mitä viljelet?", true, "choice");
		Question question3 = new Question("3", "Haluatko tarkkailla satoasi?", true, "choice");
		
		AnswerOption answer1_1 = new AnswerOption("1", "1", "Kyllä", "1", "2", true, false);
		AnswerOption answer1_2 = new AnswerOption("2", "1", "En", "2", "2", true, false);
		
		AnswerOption answer2_1 = new AnswerOption("3", "2", "Perunaa", "1", "3", true, false);
		AnswerOption answer2_2 = new AnswerOption("4", "2", "Porkkanaa", "2", "3", true, false);
		
		AnswerOption answer3_1 = new AnswerOption("5", "3", "Kyllä", "1", "1", true, false);
		AnswerOption answer3_2 = new AnswerOption("6", "3", "En", "2", "1", true, false);
		
		ToFrontend tfe = new ToFrontend();
		tfe.addQuestion(question1);
		tfe.addQuestion(question2);
		tfe.addQuestion(question3);
		tfe.addAnswer(answer1_1);	
		tfe.addAnswer(answer1_2);	
		tfe.addAnswer(answer2_1);	
		tfe.addAnswer(answer2_2);	
		tfe.addAnswer(answer3_1);	
		tfe.addAnswer(answer3_2);	
		
		return tfe;
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
