package org.softala.roboapp.repository;

import org.softala.roboapp.model.Session;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Tuomas Törmä
 * @Since 14.10.2015
 * 
 * 
 * Implementation of Spring's CrudRepository for user sessions
 */
public interface SessionRepository extends CrudRepository<Session, String> {

}
