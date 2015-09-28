package org.softala.roboapp.repository;

import java.util.ArrayList;

import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.helpModels.AnswerLevelPerAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface GivenAnswerRepository extends CrudRepository<GivenAnswer, Long>  {
	
//	@Query("select count(q.session_id) from GivenAnswer q")
//	public int countAllSessionID();
	
	//EI TOIMI
	@Query(value = "select ut.user_type, ag.answers_given, (   select count(id) from session  where answers_given >= ag.answers_given and user_type = ut.user_type ) as count from session as ag join session as ut group by ut.user_type, ag.answers_given;", nativeQuery = true)
	public ArrayList<AnswerLevelPerAnswer> pekko();

}
