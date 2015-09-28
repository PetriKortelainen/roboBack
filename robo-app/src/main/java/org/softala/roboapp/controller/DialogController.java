package org.softala.roboapp.controller;

import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.repository.DialogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dialog")
public class DialogController {
	
	@Autowired
	private DialogRepository dialogrepository;
	
	@RequestMapping("/repository/all")
	public Iterable<Dialog> getAllDialogs(){
		return dialogrepository.findAll();
	}
	
	@RequestMapping("/repository/{id}")
	public Dialog getDialogWithId(@PathVariable("id") Integer id){
		return dialogrepository.findOne(id);
	}

}
