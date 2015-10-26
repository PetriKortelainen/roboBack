package org.softala.roboapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import org.softala.roboapp.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/FrontFake")
public class FrontFakeController {
	/*A TEST controller for development purposes
	 * all content below should either be transfered or
	 * deleted in final version */
	
	
	/**
	 * 
	 * Had to remake this method in order to get relations to work, please check if needs to be remake
	 */
	@RequestMapping("/getTree")
	public void getTree(){
//		ToFrontend toFrontEnd = new ToFrontend();
//		Dialog dialog = new Dialog();
//		dialog.setDialogId(1);
//		dialog.setEnabled(true);
//		dialog.setName("Tree 1");
//		dialog.setCreated(new Date());
//		
//		AnswerOptionId a_id = new AnswerOptionId("A2", "Q1", 1);
//		QuestionId q_id=new QuestionId("Q2", 1);
//		
//		AnswerOption AnswerOption = new AnswerOption(a_id, "text", "Q2", false);
//		
//		Question question = new Question(q_id, "Oletko esimerkki", "checkbox");
//		
//		question.getAnswerOptions().add(AnswerOption);
//		dialog.getQuestions().add(question);
//		
//		toFrontEnd.getQuestionList().add(question);
//		toFrontEnd.getAnswerList().add(AnswerOption);
		
		return;//toFrontend
	}
	
	@RequestMapping(value= "/postAnswer", method = RequestMethod.POST)
	public ResponseEntity<String> postAnswer(@RequestBody Hello hello){
		//receive a single answer from front end and post it to server log
		//incoming data must reflect the model in question
		
		//To print content of hello bean
		String content = hello.getContent();
		
		return new ResponseEntity<String>(content, HttpStatus.OK);
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
	
	@RequestMapping("/asd")
	public void base(){
		//temp test method remove this!!
		System.out.println("frontfake row base method for datetime");
		
		//test data for funzies delete!!! before final combile
		//7.10 jatketaan syssymäl

		Date date = new Date();
		String oldstring = "2011-01-18 00:00:00.0";
		//GivenAnswerId answerid;
		//GivenAnswer answer = new GivenAnswer();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
			String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
			//answer.setCreated(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("DATETIME: "+date.toString());
		return; //bean?
	}

}
