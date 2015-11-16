package org.softala.roboapp.controller;

import org.softala.roboapp.model.Question;
import org.softala.roboapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Tuomas Törmä
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
 * Controller mappings for accessing the QuestionRepository
 */

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionrepository;
	
	/**
	 * Fetches all questions using the findAll method of Spring's CrudRepository
	 * @return
	 */
	@RequestMapping("/repository/all")
	public Iterable<Question> allquestions(){
		Iterable<Question> questions = questionrepository.findAll();
		return questionrepository.findAll();
	}
	
	/**
	 * Fetches a question using the findOne method of Spring's CrudRepository
	 * @param id
	 * @return the question with the specified id
	 */
	@RequestMapping("/repository/{id}")
	public Question getQuestionById(@PathVariable("id") Integer id){
		Question question = questionrepository.findOne(id);
		return question;
	}

}
