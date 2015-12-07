package org.softala.roboapp.controller;

import org.softala.roboapp.model.Question;
import org.softala.roboapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller mappings for accessing the QuestionRepository
 * @author Tuomas Törmä
 * @Since 14.10.2015
 * 
 */

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionrepository;
	
	/**
	 * Fetches all questions using the findAll method of Spring's CrudRepository
	 * @return
	 */
	@RequestMapping("/repository/all")
	public Iterable<Question> allquestions(){
		return questionrepository.findAll();
	}
	
	/**
	 * Fetches a question using the findOne method of Spring's CrudRepository
	 * @param id
	 * @return the question with the specified id
	 */
	@RequestMapping("/repository/{id}")
	public Question getQuestionById(@PathVariable("id") Integer id){
		Question question = questionrepository.findOne(id);
		return question;
	}

}
