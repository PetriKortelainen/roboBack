package org.softala.roboapp.controller;

import org.apache.log4j.Logger;
import org.softala.roboapp.model.Dialog;
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
		log.info("fetching all dialogs");
		return dialogrepository.findAll();
	}
	
	/**
	 * Fetches a dialog using the findOne method of Spring's CrudRepository
	 * @param id
	 * @return the dialog with the specified id
	 */
	@RequestMapping("/repository/{id}")
	public Dialog getDialogWithId(@PathVariable("id") Integer id){
		log.info("fetching all dialogs");
		return dialogrepository.findOne(id);
	}

}
