package org.softala.roboapp.controller;

import org.softala.roboapp.model.Session;
import org.softala.roboapp.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller mappings for accessing the SessionRepository
 * @author Tuomas Törmä
 * 
 */

@RestController
@RequestMapping("/sessions")
public class SessionController {
	
	@Autowired
	private SessionRepository sessionRepository;
	
	/**
	 * Fetches all sessions using the findAll method of Spring's CrudRepository
	 * @return all sessions from the database
	 */
	@RequestMapping("/repository/all")
	public Iterable<Session> getAllSessions(){
		return sessionRepository.findAll();
	}
	
	/**
	 * Fetches a session using the findOne method of Spring's CrudRepository
	 * @param id
	 * @return the session with the specified id
	 */
	@RequestMapping("/repository/{id}")
	public Session getQuestionById(@PathVariable("id") String id){
		return sessionRepository.findOne(id);
	}
}