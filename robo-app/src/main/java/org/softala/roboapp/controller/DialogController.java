package org.softala.roboapp.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.repository.DialogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Tuomas Törmä
 * @Since 14.10.2015
 * 
 * Controller mappings for accessing the DialogRepository
 */

@RestController
@RequestMapping("/dialog")
public class DialogController {
	
	//logging
	private Logger log = Logger.getLogger(DialogController.class);
	
	@Autowired
	private DialogRepository dialogrepository;
	
	/**
	 * Fetches all dialogs using the findAll method of Spring's CrudRepository
	 * @return all dialogs from the database
	 */
	@RequestMapping("/repository/all")
	public Iterable<Dialog> getAllDialogs(){
		log.debug("fetching all dialogs");
		return dialogrepository.findAll();
	}
	
	/**
	 * Fetches a dialog using the findOne method of Spring's CrudRepository
	 * @param id
	 * @return the dialog with the specified id
	 */
	@RequestMapping("/repository/{id}")
	public Dialog getDialogWithId(@PathVariable("id") Integer id){
		log.debug("fetching all dialogs");
		return dialogrepository.findOne(id);
	}

	@RequestMapping("/test")
	public void someTest(){
		Dialog dialog = new Dialog();
		dialog.setName("Some kind of tree");
		dialog.setCreated(new Date());
		dialog.setEnabled(true);

		Question question = new Question();
		question.setParent(null);
		question.setDialog(dialog);
		question.setText("Onko tämä kysymys");
		question.setAnswerType("choice");
		
		Question child = new Question();
		child.setText("Tämähän oli 2 kysymys");
		child.setParent(question);
		question.setDialog(dialog);
		child.setAnswerType("choice");
		question.getChildren().add(child);
		
		Question greandChild = new Question();
		greandChild.setText("Tämähän oli 3 kysymys");
		greandChild.setParent(child);
		question.setDialog(dialog);
		greandChild.setAnswerType("choice");
		child.getChildren().add(greandChild);
		
		dialog.getQuestions().add(question);
		
		dialogrepository.save(dialog);
	}
	
	
}
