package org.softala.roboapp.repository;

import org.softala.roboapp.model.AnswerOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author 	Tuomas Törmä
 * @since	2.12.2015
 * 
 *	Implementation of Spring's CrudRepository for AnswerOptions
 */
@Repository
public interface AnswerOptionRepository extends CrudRepository<AnswerOption, Long> {

}
