package org.softala.roboapp.controller;

import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.repository.DialogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller mappings for accessing the DialogRepository
 * @author Tuomas Törmä
 * @Since 14.10.2015
 * 
 */

@RestController
@RequestMapping("/dialog")
public class DialogController {
	
	@Autowired
	private DialogRepository dialogrepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * Fetches all dialogs using the findAll method of Spring's CrudRepository
	 * @return all dialogs from the database
	 */
	@RequestMapping("/repository/all")
	public Iterable<Dialog> getAllDialogs(){
		return dialogrepository.findAll();
	}
	
	/**
	 * Fetches a dialog using the findOne method of Spring's CrudRepository
	 * @param id
	 * @return the dialog with the specified id
	 */
	@RequestMapping("/repository/{id}")
	public Dialog getDialogWithId(@PathVariable("id") Integer id){
		return dialogrepository.findOne(id);
	}
}
