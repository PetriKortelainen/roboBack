package org.softala.roboapp.repository;


import org.softala.roboapp.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

	@Query("select q from Question q where q.id = ?")
	public Question findByQuestionId(String id);
	

	
}
