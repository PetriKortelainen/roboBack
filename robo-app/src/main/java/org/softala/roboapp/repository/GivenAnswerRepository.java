package org.softala.roboapp.repository;

import java.util.ArrayList;

import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.helpModels.AnswerLevelPerAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Tuomas Törmä, Pekko Tuomisto
 * @Since 14.10.2015
 * 
 * Implementation of Spring's CrudRepository for user answers
 */
public interface GivenAnswerRepository extends CrudRepository<GivenAnswer, Long>  {
	
//	@Query("select count(q.session_id) from GivenAnswer q")
//	public int countAllSessionID();
	
	/**
	 * Custom query to db. Return more spesific data
	 * @return	ArrayList AnswerLevelPerAnswer
	 */
	@Query(value = "select q.text as question_text, ao.text as answer_option_text, count(ga.created) as answers from answer_option ao join given_answer ga on ga.answer_option_id = ao.answer_option_id join question q on ao.question_id = q.question_id group by ao.answer_option_id;", nativeQuery = true )
	public ArrayList<AnswerLevelPerAnswer> getAnswerPerQuestion();
	
	/**
	 * Custom query that returns answers per levedl per Dialog with id is dialog id
	 * 
	 * @param id	Integer, Dialog id
	 * @return	ArrayList AnswerLevelPerAnswer
	 */
	@Query(value="select q.text as question_text, ao.text as answer_option_text, count(ga.created) as answers from answer_option ao join given_answer ga on ga.answer_option_id = ao.answer_option_id  join question q on ao.question_id = q.question_id join dialog dia on dia.dialog_id = q.dialog_id WHERE dia.dialog_id = ? group by ao.answer_option_id;", nativeQuery = true)
	public ArrayList<AnswerLevelPerAnswer> getAnswerPerQuestionPerDialog(Integer id);
	
	/**
	 * Custom query that returns given answers with specific data
	 * 
	 * @return	ArrayList GivenAnswer
	 */
	@Query(value="select g.session_id, g.answer_option_id, g.created from given_answer g order by g.session_id, g.created;", nativeQuery = true)
	public ArrayList<GivenAnswer> getGivenAnswers();
	
	/**
	 * Custom query that returns given answer specific data from certain Dialog
	 * 
	 * @param id	Integer, Dialog id
	 * @return	ArrayList GivenAnswer
	 */
	@Query(value="select g.session_id, g.answer_option_id, g.created from given_answer g JOIN answer_option a ON g.answer_option_id = a.answer_option_id  JOIN question gu ON a.question_id = gu.question_id JOIN dialog d ON d.dialog_id = gu.dialog_id  WHERE d.dialog_id = ? order by g.session_id, g.created;", nativeQuery = true)
	public ArrayList<GivenAnswer> getGivenAnsswerByDialogId(Integer id);
	
	

}
