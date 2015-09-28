package org.softala.roboapp.controller;

import org.softala.roboapp.model.Question;
import org.softala.roboapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionrepository;
	
	@RequestMapping("/repository/all")
	public Iterable<Question> allquestions(){
		Iterable<Question> questions = questionrepository.findAll();
		return questionrepository.findAll();
	}
	
	@RequestMapping("/repository/{id}")
	public Question getQuestionById(@PathVariable("id") String id){
		Question question = questionrepository.findByQuestionId(id);
		return question;
	}

}
