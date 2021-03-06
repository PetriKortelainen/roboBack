package org.softala.roboapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.process.IteratorProcesser;
import org.softala.roboapp.repository.GivenAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController class that manages export CSV files.
 * 
 * @author Tuomas Törmä
 * @Since 14.10.2015
 * 
 */

@RestController
@RequestMapping("/export")
public class ExportCVSController {
	
	@Autowired
	private GivenAnswerRepository givenAnswersRepository;
	
	/**
	 * Test to return sample CSV export file
	 * 
	 * @param response HttpServletResponse
	 */
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
			String outputString = iter.next();
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
	
	/**
	 * Return back to user export CSV to user as file
	 * 
	 * @param response HttpServletResponse
	 */
	@RequestMapping("/given_answers")
	public void downloadGivenAnswersCVS(HttpServletResponse response){
			//Setting header informaton
			response.setContentType("text/csv");
			LocalDate today = LocalDate.now();
			String reportName = "CSV export Given Answers "+ today.toString()+".csv";
			response.setHeader("Content-disposition", "attachment;filename="+reportName);
		
			//Adding rows
			ArrayList<String> rows = new ArrayList<String>();
			rows.add("Session_id,Dialog_id,Question_text,Given_Anwser_text");
			rows.add("\n");
			
			//Get All given answers from db
			Iterable<GivenAnswer> answerIterator = givenAnswersRepository.findAll();
			
			IteratorProcesser<GivenAnswer> processor = new IteratorProcesser<GivenAnswer>();
			
			ArrayList<GivenAnswer> answerList = processor.processToArrayList(answerIterator);
			
			for (GivenAnswer givenAnswer : answerList) {
				rows.add(givenAnswer.getSession().getSessionId()+","+givenAnswer.getAnswerOption().getQuestion().getDialog().getDialogId()+","+ givenAnswer.getAnswerOption().getQuestion().getText() +","+ givenAnswer.getAnswerOption().getText());
				rows.add(System.lineSeparator());
			}
			
			//foreach line, get the data from arrayList and then
			//get responses output stream and print data to it
			Iterator<String> iter = rows.iterator();
			while (iter.hasNext()) {
				String outputString = iter.next();
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