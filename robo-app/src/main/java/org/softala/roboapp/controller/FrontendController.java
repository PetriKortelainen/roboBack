package org.softala.roboapp.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.GivenAnswerId;
import org.softala.roboapp.model.OrderContact;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.Session;
import org.softala.roboapp.model.helpModels.AnswerHandlerBean;
import org.softala.roboapp.repository.DialogRepository;
import org.softala.roboapp.repository.GivenAnswerRepository;
import org.softala.roboapp.repository.OrderContactRepository;
import org.softala.roboapp.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Java class for common communication with front end.
 * FEATURES: session generation, saving user responses to database 
 * and handling the dialogues for frontend
 */

/** 
 * Controller for customer actions in frontend.
 * 
 * @author Team 1 - Petri Kortelainen || Harri Stranden
 *
 */
@RestController
@RequestMapping("/Front")
// "Front" for now but may later be changed to "/" - when so remove this
// comment
public class FrontendController {

	@Autowired
	private GivenAnswerRepository GivAnswRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private DialogRepository dialogrepository;

	@Autowired
	private OrderContactRepository oCRepository;


	/**
	 * On each click the front end sends post here which is saved into database
	 * Generates new anonymous user session if one doesn't exist
	 * 
	 * @param AHB
	 *            Answer handler
	 * @return map containing session id
	 */
	@RequestMapping(value = "/postClick", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, String> saveClick(
			@RequestBody AnswerHandlerBean AHB) {

		/*
		 * AHB is a bean that contains information on a single click receive a
		 * single answer from front end and post it to server login coming data
		 * must reflect the model in question {"answer_option_id": "int",
		 * "session_id":"String", "textfieldAnswer":"String"}
		 * 
		 * Textfield is for latter use in case we ever want to use input instead
		 * of choice. Beans from frontend are to be handled with converter but
		 * for now AHB is RAW for now
		 */

		Session session = new Session();
		String testId = "";

		// Map for response
		HashMap<String, String> resMap = new HashMap<String, String>();

		try {
			// attempt to read given json on value session_id
			testId = AHB.getSession_id();
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("WARNING:", "DIRTY READ");
			return resMap;
		}

		if (testId != null && testId != "") {
			// TIME TO CHECK SESSION ID
			if (sessionRepository.exists(testId)) {
				session.setSessionId(testId);
			} else {
				// given session id is fake
				resMap.put("WARNING:", "FAKE SESSION ID GIVEN");
				return resMap;
			}
		} else {
			// NEW SESSION GENERATOR
			session = FrontendController.this.newSession();
			testId = session.getSessionId();
		}
		AHB.getTextfieldAnswer().trim();
		if (!AHB.getTextfieldAnswer().isEmpty()) {
			// ANSWER is an CLOSING...when textfield has content

			try {
				OrderContact oc = new OrderContact();
				Date date = new Date();
				// CONVERT TO CLOSING BEAN
				oc.setSession(session);
				oc.setCreated(date);
				oc.setEmail(AHB.getTextfieldAnswer());

				// ATTEMPT TO SAVE
				oCRepository.save(oc);

			} catch (Exception e) {
				e.printStackTrace();
				resMap.put("WARNING:", "Closing Error");

			}
		} else {
			// ANSWER is a CLICK
			GivenAnswer ga = new GivenAnswer();
			AnswerOption ao = new AnswerOption();
			GivenAnswerId gai = new GivenAnswerId();

			// GivenAnswerId content
			gai.setSessionId(testId);
			String aoID = AHB.getAnswer_option_id();
			int foo = 0;
			try {
				foo = Integer.parseInt(aoID);
			} catch (NumberFormatException e) {
				System.out.println("parse to int kusi, aoID:" + aoID);
				e.printStackTrace();
			}
			gai.setAnswerOptionId(foo);

			// AnswerOption content
			ao.setAnswerOptionId(foo);

			// GivenAnswer content
			ga.setId(gai);
			ga.setCreated(new Date());
			ga.setSession(session);
			ga.setAnswerOption(ao);
			GivAnswRepository.save(ga);
		}

		resMap.put("session_id", testId);
		return resMap;
	} // end of saveClick

	/**
	 * Give tree to frontend
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/getTree")
	public Iterable getTree() {

		// TODO handle multiple trees so that only 1 is given to frontend based
		// on number of activated threes

		ArrayList<Dialog> d = new ArrayList<Dialog>();
		ArrayList<Integer> a = null;

		int random = (int) (Math.random() * 100);
		/*
		 * code to get all trees at the same time: try { a =
		 * dialogrepository.findEnabled(); for (int i = 0; i < a.size(); i++) {
		 * d.add(dialogrepository.findOne(a.get(i))); } } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		// Code to pick randomly from multiple trees
		try {
			a = dialogrepository.findEnabled();
			random = (int) (Math.random() * a.size());
			d.add(dialogrepository.findOne(a.get(random)));

			d.get(0).setFirstQuestionId(this.findFirstQuestion(d.get(0)));

		} catch (Exception e) {
			e.printStackTrace();
		}
		if(d.isEmpty()){
			//TODO if no tree is fetched something needs to happen
		}

		return d;
	} //end of getTree
	
	/**
	 * Session generator. ID is made into hashmap from miliseconds uses
	 * hashString method below to do so
	 * 
	 * @return session (bean)
	 */
	public Session newSession() {
		// Session generator
		Session session = new Session();
		Date date = new Date();

		// generating an id from current time
		long cTM;
		String genID = "";
		int hash;

		do {
			try {
				// id generated by making hashmap out of millisecond timer value
				cTM = System.currentTimeMillis();
				hash = (int) cTM;
				genID = "" + hash;
				genID = FrontendController.this.hashString(genID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// if id already exists which is very unlikely another id is made
			// if need be 1 can add random gen number to the hash gen value to
			// make it even more unique but that isn't necessary
		} while (genID == null || sessionRepository.exists(genID));
		session.setSessionId(genID);
		session.setCreated(date);

		// Session saved for later use to record clicks
		sessionRepository.save(session);
		return session;
	} // end of newSession

	/**
	 * Generates hashed string to be used as user session ids
	 * 
	 * @param s
	 *            string to be hashed
	 * @return hashed string
	 * @throws NoSuchAlgorithmException
	 */
	public String hashString(String s) throws NoSuchAlgorithmException {
		byte[] hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			hash = md.digest(s.getBytes());

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				sb.append(0);
				sb.append(hex.charAt(hex.length() - 1));
			} else {
				sb.append(hex.substring(hex.length() - 2));
			}
		}
		return sb.toString();
	} // end of hashString

	/**
	 * Loops through questions and answer options to find the first question of
	 * a dialog. Returns the id of first question
	 * 
	 * If dialog has more then one(1) question that has not been linkked with
	 * nextQuestion value this method is unreliable. 
	 * 
	 * @param d
	 * @return int
	 */
	private int findFirstQuestion(Dialog d) {

		int firstQuestion = -1;

		ArrayList<Integer> nextQuestionArray = new ArrayList<Integer>();

		/*
		 * Loop through all the questions and their answer options and save the
		 * nextQuestionId's to the ArrayList
		 */
		for (Question q : d.getQuestions()) {

			for (AnswerOption ao : q.getAnswerOptions()) {
				nextQuestionArray.add(ao.getNextQuestionId());
			}

		}

		/*
		 * Loop through questions again and compare question id's with the
		 * nextQuestionArray to find the first question
		 */
		for (Question q : d.getQuestions()) {
			boolean exists = false;
			int id = q.getQuestionId();

			for (Integer nq : nextQuestionArray) {
				if (nq != null && nq == id) {
					exists = true; // Id found in the array => not the first
									// question
				}
			}

			// Id not found in the array, therefore is first question
			if (!exists) {
				firstQuestion = id;
			}
			
		}

		//	ALT-version to code above:	for (Question q : d.getQuestions()) {for(AnswerOption ao : q.getAnswerOptions()) {nextQuestionArray.add(ao.getNextQuestionId());}}for (Question q : d.getQuestions()) {if(!nextQuestionArray.contains(q.getQuestionId())){firstQuestion=q.getQuestionId();}}
		return firstQuestion;
	} // end of findFirstQuestion

}
