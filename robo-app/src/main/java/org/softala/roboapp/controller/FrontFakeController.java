package org.softala.roboapp.controller;

import java.util.Hashtable;

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
	public void getTree(){
		//returns whole dialogue tree in JSON
		return;
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
