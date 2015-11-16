package org.softala.roboapp.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.GivenAnswerId;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.Session;
import org.softala.roboapp.model.helpModels.AnswerHandlerBean;
import org.softala.roboapp.model.helpModels.AnswerLevelPerAnswer;
import org.softala.roboapp.repository.DialogRepository;
import org.softala.roboapp.repository.GivenAnswerRepository;
import org.softala.roboapp.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author team 1 - Petri Kortelainen
 *
 */

/*
 * Controller to communicate with frontend on click and more...
 */

@RestController
@RequestMapping("/FrontTEST")
// "FrontTEST" for now but later well change it to "/" - when so remove this
// comment
public class FrontendController {

	@Autowired
	private GivenAnswerRepository GivAnswRepository;

	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private DialogRepository dialogrepository;
	
	public Session newSession() {
		// TODO Maybe not executed here WIP
		// session generator
		Session session = new Session();
		Date date = new Date();

		// generating an id from current time
		long cTM;
		String genID = "";
		int hash;

		do {
			try {
				// UUID on toinen vaihtoehto kokeillaan joskus
				cTM = System.currentTimeMillis();
				hash = (int) cTM;
				genID = "" + hash;
				genID = FrontendController.this.hashString(genID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (genID == null);
		session.setSessionId(genID);
		session.setCreated(date);

		// sessio tallenetaan muualla atm
		sessionRepository.save(session);
		return session;
	}

	@RequestMapping(value = "/postClick", method = RequestMethod.POST)
	public ResponseEntity<String> saveClick(@RequestBody AnswerHandlerBean AHB) {

		/*
		 * AHB is a bean that contains information on a single clickreceive a
		 * single answer from front end and post it to server logincoming data
		 * must reflect the model in question{"answer_option_id": "5",
		 * "session_id":
		 * "1503ef4c26416d9e65529ef3100d9fdb92b38e3d6d07a39e89a21489ff0bcc",
		 * "textfieldAnswer":"asd"}
		 * 
		 * Textfield is for latter useBeans from frontend are to be handled with
		 * converter but for now AHB ispure RAW
		 */

		Session session = new Session();
		String test = "";
		String id = "";
		try {
			test = AHB.getSession_id();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// testataan joskus tässä onko olemassa id annettuna
		if (test != null && test != "") {
			// TIME TO CHECK SESSION ID
			if (sessionRepository.exists(test)) {
				id = test;
				session.setSessionId(id);
			} else {
				// given session id is fake
				// TODO throw to new session or handle otherwise
			}
		} else {
			// NEW SESSION creater
			session = FrontendController.this.newSession();
			id = session.getSessionId();
		}

		GivenAnswer ga = new GivenAnswer();
		AnswerOption ao = new AnswerOption();
		GivenAnswerId gai = new GivenAnswerId();

		// GAI content
		gai.setSessionId(id);
		String aoID = AHB.getAnswer_option_id();
		int foo = 0;
		try {
			foo = Integer.parseInt(aoID);
		} catch (NumberFormatException e) {
			System.out.println("parse to int kusi, aoID:" + aoID);
			e.printStackTrace();
		}
		gai.setAnswerOptionId(foo);

		// Ao content
		ao.setAnswerOptionId(foo);

		// GA content
		ga.setId(gai);
		ga.setCreated(new Date());
		ga.setSession(session);
		ga.setAnswerOption(ao);

		GivAnswRepository.save(ga);

		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@RequestMapping("/getTree")
	public Iterable getTree() {
		//Extreamly ugly code, done in rush
		//method handles data from database and fixes it
		
		//futre may send 1 tree based on max number of activated
		
		ArrayList<Dialog> d = new ArrayList<Dialog>();
		ArrayList<Integer> a = null;
		try{
			a = dialogrepository.findEnabled();
			for(int i=0; i<a.size(); i++){
				d.add(dialogrepository.findOne(a.get(i)));
			}
			for(int i=0; i<a.size(); i++){
				Dialog x = d.get(i);
				Set<Question> questions = x.getQuestions();
				for(Question qn : questions){
					Set<AnswerOption> awos = qn.getAnswerOptions();
					for(AnswerOption ao : awos){
						Set<GivenAnswer> gaw = ao.getGivenAnswers();
						gaw.clear();			
					}
				}	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return d;
	}

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
	}

}
