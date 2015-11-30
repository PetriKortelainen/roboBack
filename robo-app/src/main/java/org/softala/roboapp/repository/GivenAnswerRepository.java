package org.softala.roboapp.repository;

import java.util.ArrayList;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;

import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.helpModels.AnswerLevelPerAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Tuomas Törmä
 * @Since 14.10.2015
 * 
 * Implementation of Spring's CrudRepository for user answers
 */
public interface GivenAnswerRepository extends CrudRepository<GivenAnswer, Long>  {
	
//	@Query("select count(q.session_id) from GivenAnswer q")
//	public int countAllSessionID();
	
	@Query(value = "select q.text as question_text, ao.text as answer_option_text, count(ga.created) as answers from answer_option ao join given_answer ga on ga.answer_option_id = ao.answer_option_id join question q on ao.question_id = q.question_id group by ao.answer_option_id;", nativeQuery = true )
	public ArrayList<AnswerLevelPerAnswer> getAnswerPerQuestion();
	
	@Query(value="select g.session_id, g.answer_option_id, g.created from given_answer g order by g.session_id, g.created;", nativeQuery = true)
	public ArrayList<GivenAnswer> getGivenAnswers();
	
	@Query(value="select g.session_id, g.answer_option_id, g.created from given_answer g JOIN answer_option a ON g.answer_option_id = a.answer_option_id  JOIN question gu ON a.question_id = gu.question_id JOIN dialog d ON d.dialog_id = gu.dialog_id  WHERE d.dialog_id = ? order by g.session_id, g.created;", nativeQuery = true)
	public ArrayList<GivenAnswer> getGivenAnsswerByDialogId(Integer id);
	
	

}
