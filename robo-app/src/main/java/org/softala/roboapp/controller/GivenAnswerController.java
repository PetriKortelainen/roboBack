package org.softala.roboapp.controller;

import java.util.ArrayList;

import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.helpModels.AnswerLevelPerAnswer;
import org.softala.roboapp.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author 	Tuomas Törmä
 * @since	2.12.2015
 *
 *	Controller mappings for accessing the GivenAnswerRepository
 */
@RestController
@RequestMapping("/givenanswers")
public class GivenAnswerController {
	
	@Autowired
	private GivenAnswerRepository givenAnswerRepository;
	
	/**
	 * Fetches all answers using the findAll method of Spring's CrudRepository
	 * @return all answers from the database
	 */
	@RequestMapping("/repository/all")
	public Iterable<GivenAnswer> allquestions(){
		return givenAnswerRepository.findAll();
	}
	
	/**
	 * Fetches data with custom query
	 * 
	 * @return
	 */
	@RequestMapping("/repository/allWithout")
	public ArrayList<GivenAnswer> all(){
		return givenAnswerRepository.getGivenAnswers();
	}
	
//	@RequestMapping("/repository/countSessions")
//	public int allSessionsCount(){
//		return givenAnswerRepository.countAllSessionID();
//	}
	
	@RequestMapping("/repository/getAnswerPerQuestion")
	@ResponseBody
	public ArrayList<AnswerLevelPerAnswer> getAnswerPerQuestion(){
		return givenAnswerRepository.getAnswerPerQuestion();
	}
	
	/**
	 * Fetches a dialog using the findOne method of Spring's CrudRepository
	 * @param id
	 * @return the dialog with the specified id
	 */
	@RequestMapping("/repository/getAnswerPerQuestionPerDialogID/{id}")
	public ArrayList<AnswerLevelPerAnswer> getAnswerPerQuestionPerDialogID(@PathVariable("id") Integer id){
		return givenAnswerRepository.getAnswerPerQuestionPerDialog(id);
	}
	
	
	/**
	 * Fetches a dialog using the findOne method of Spring's CrudRepository
	 * @param id
	 * @return the dialog with the specified id
	 */
	@RequestMapping("/repository/getGivenAnswerByDialogId/{id}")
	public ArrayList<GivenAnswer> getDialogWithId(@PathVariable("id") Integer id){
		return givenAnswerRepository.getGivenAnsswerByDialogId(id);
	}

}
