package org.softala.roboapp.repository;


import org.softala.roboapp.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Tuomas Törmä
 * @Since 14.10.2015
 * 
 * 
 * Implementation of Spring's CrudRepository for questions
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {

	@Query("select q from Question q where q.id = ?")
	public Question findByQuestionId(String id);

}
