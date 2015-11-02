package org.softala.roboapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
 */

@RestController
@RequestMapping("/export")
public class ExportCVSController {
	
	@Autowired
	private GivenAnswerRepository givenAnswersRepository;
	
	@RequestMapping(value="/downloadTestCVS")
	public void downloadTestCVS(HttpServletResponse response){
		//Setting header informaton
		response.setContentType("text/csv");
		String reportName = "CVS export";
		response.setHeader("Content-disposition", "attachment;filename="+reportName);
		
		//Adding rows
		ArrayList<String> rows = new ArrayList<String>();
		rows.add("Name,Result");
		rows.add("\n");
 
		//Filling with data, add 
		for (int i = 0; i < 10; i++) {
			rows.add("Test Time,Success");
			rows.add(System.lineSeparator());
		}
 
		//foreach line, get the data from arrayList and then
		//get responses output stream and print data to it
		Iterator<String> iter = rows.iterator();
		while (iter.hasNext()) {
			String outputString = (String) iter.next();
			try {
				response.getOutputStream().print(outputString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
 
		try {
			response.getOutputStream().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/given_answers")
	public void downloadGivenAnswersCVS(HttpServletResponse response){
			//Setting header informaton
			response.setContentType("text/csv");
			LocalDate today = LocalDate.now();
			String reportName = "CVS export Given Answers "+ today.toString();
			response.setHeader("Content-disposition", "attachment;filename="+reportName);
		
			//Adding rows
			ArrayList<String> rows = new ArrayList<String>();
			rows.add("Session_id,Dialog_id,Question_text,Given_Anwser_text");
			rows.add("\n");
			
			//Get All given answers from db
			Iterable<GivenAnswer> answerIterator = givenAnswersRepository.findAll();
			
			ArrayList<GivenAnswer> answerList = new ArrayList<>();
		
			for (GivenAnswer givenAnswer : answerIterator) {
				answerList.add(givenAnswer);
			}
			
			for (GivenAnswer givenAnswer : answerList) {
				rows.add(givenAnswer.getSession().getSessionId()+","+givenAnswer.getAnswerOption().getQuestion().getDialog().getDialogId()+","+ givenAnswer.getAnswerOption().getQuestion().getText() +","+ givenAnswer.getAnswerOption().getText());
				rows.add(System.lineSeparator());
			}
			
			//foreach line, get the data from arrayList and then
			//get responses output stream and print data to it
			Iterator<String> iter = rows.iterator();
			while (iter.hasNext()) {
				String outputString = (String) iter.next();
				try {
					response.getOutputStream().print(outputString);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	 
			try {
				response.getOutputStream().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

}
