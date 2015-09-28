package org.softala.roboapp.controller;

import java.util.ArrayList;

import javax.persistence.Query;

import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.helpModels.AnswerLevelPerAnswer;
import org.softala.roboapp.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;

@RestController
@RequestMapping("/givenanswers")
public class GivenAnswerController {
	
	@Autowired
	private GivenAnswerRepository givenAnswerRepository;
	
	@RequestMapping("/repository/all")
	public Iterable<GivenAnswer> allquestions(){
		return givenAnswerRepository.findAll();
	}
	
//	@RequestMapping("/repository/countSessions")
//	public int allSessionsCount(){
//		return givenAnswerRepository.countAllSessionID();
//	}
	
	@RequestMapping("/repository/pekko")
	@ResponseBody
	public ArrayList<AnswerLevelPerAnswer> pekkosSQL(){
		return givenAnswerRepository.pekko();
	}
	

}
