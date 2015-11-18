package org.softala.roboapp.repository;

import java.util.ArrayList;

import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.SqlResultSetMapping;

import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.Session;
import org.softala.roboapp.model.helpModels.AnswerLevelPerAnswer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * 
 * @author Tuomas Törmä, Petri Kortelainen
 * @Since 14.10.2015
 * 
 *  * The MIT License (MIT)
 *
 * Copyright (c) 2015 Haaga-Helia ammattikorkeakoulu Oy ab
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 */
public interface GivenAnswerRepository extends CrudRepository<GivenAnswer, Long>  {
	
//	@Query("select count(q.session_id) from GivenAnswer q")
//	public int countAllSessionID();
	
	@Query(value = "select q.text as question_text, ao.text as answer_option_text, count(ga.created) as answers from answer_option ao join given_answer ga on ga.answer_option_id = ao.answer_option_id join question q on ao.question_id = q.question_id group by ao.answer_option_id;", nativeQuery = true )
	public ArrayList<AnswerLevelPerAnswer> getAnswerPerQuestion();
	
	/**
	 * Saves users answer click
	 * @param date Timestamp of user click
	 * @param aoid answer option id
	 * @param sessionId user session id
	 */
	@Modifying
	@Query(value= "INSERT INTO given_answer (created, answer_option_id,session_id) values (?, ?, ?", nativeQuery = true)
	public void newClick(String date, String aoid, String sessionId);

}
