package org.softala.roboapp.controller;

import org.softala.roboapp.model.Session;
import org.softala.roboapp.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class SessionController {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@RequestMapping("/repository/all")
	public Iterable<Session> getAllSessions(){
		return sessionRepository.findAll();
	}
	
	@RequestMapping("/repository/{id}")
	public Session getQuestionById(@PathVariable("id") String id){
		return sessionRepository.findOne(id);
	}
}