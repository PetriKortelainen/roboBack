package org.softala.roboapp.controller;

import java.util.ArrayList;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.helpModels.AnswerLevelPerAnswer;
import org.softala.roboapp.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

/**
 * 
 * @author Tuomas Törmä
 *
 *	Controller mappings for accessing the GivenAnswerRepository
 */
@RestController
@RequestMapping("/givenanswers")
public class GivenAnswerController {
	
	//logging
	private Logger log = Logger.getLogger(GivenAnswerController.class);
	
	@Autowired
	private GivenAnswerRepository givenAnswerRepository;
	
	/**
	 * Fetches all answers using the findAll method of Spring's CrudRepository
	 * @return all answers from the database
	 */
	@RequestMapping("/repository/all")
	public Iterable<GivenAnswer> allquestions(){
		log.debug("find all GivenAnswers...");
		return givenAnswerRepository.findAll();
	}
	
//	@RequestMapping("/repository/countSessions")
//	public int allSessionsCount(){
//		return givenAnswerRepository.countAllSessionID();
//	}
	
	@RequestMapping("/repository/getAnswerPerQuestion")
	@ResponseBody
	public ArrayList<AnswerLevelPerAnswer> getAnswerPerQuestion(){
		log.debug("find all getAnswerPerQuestion...");
		return givenAnswerRepository.getAnswerPerQuestion();
	}
	

}
