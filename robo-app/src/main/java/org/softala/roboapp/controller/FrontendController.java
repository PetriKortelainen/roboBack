package org.softala.roboapp.controller;



import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.GivenAnswerId;
import org.softala.roboapp.model.Session;
import org.softala.roboapp.model.helpModels.AnswerHandlerBean;
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
//"FrontTEST" for now but later well change it to "/" - when so remove this comment

public class FrontendController {
	
	
	@Autowired
	private GivenAnswerRepository GivAnswRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	

	
	public Session newSession(){
		//	TODO Maybe not executed here WIP
		Session session = new Session();
		Date date = new Date();
		
		//genrating an id from current time
		long cTM;
		String genID = "";
		int hash;
		
		do{
			try {
				//UUID on toinen vaihtoehto kokeillaan joskus
				cTM = System.currentTimeMillis();
				hash = (int)cTM;
				genID = ""+hash;
				genID = FrontendController.this.hashString(genID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(genID == null);
		session.setSessionId(genID);
		session.setCreated(date);
		
		//sessio tallenetaan muualla atm
		sessionRepository.save(session);
		
		return session;
	}
	@RequestMapping(value="/postClick",method = RequestMethod.POST)
	public ResponseEntity<String> saveClick(@RequestBody AnswerHandlerBean AHB){
		
		/*AHB is a bean that contains information on a single click
		*receive a single answer from front end and post it to server log
		*incoming data must reflect the model in question {3 attributes 3 values}
		*beans from frontend are to be handled with converter but for now AHB is
		*pure RAW*/
		
		//HOI ei oo trycatchei jos answer id ei oo olemas kaatuu!
		//HOI atm ei tarkista session id todellisuutta kaatuu jos yrität aintaa sen
		
		Session session = new Session();
		String test = "";
		String id = "";
		try{
			test = AHB.getSession_id();
		}catch(Exception e){e.printStackTrace();}
		
		if(test != null && test != ""){
			id = test;
		}else{
		 session = FrontendController.this.newSession();
		 id = session.getSessionId();
		}
		
		
		
		GivenAnswer ga = new GivenAnswer();
		AnswerOption ao = new AnswerOption();
		GivenAnswerId gai = new GivenAnswerId();
		
		//GAI content
		gai.setSessionId(id);
		String aoID = AHB.getAnswer_option_id();
		int foo = 0;
		try{
		foo = Integer.parseInt(aoID);
		}catch(NumberFormatException e){
			System.out.println("parse to int kusi, aoID:"+aoID);
			e.printStackTrace();
		}
		
		gai.setAnswerOptionId(foo);
		
		//Ao content
		ao.setAnswerOptionId(foo);
		
		//GA content
		ga.setId(gai);
		ga.setCreated(new Date());
		ga.setSession(session);
		ga.setAnswerOption(ao);
		
		System.out.println("CLICK SAVE:");
		GivAnswRepository.save(ga);
		
		//WARNING fix this into something better
		//GivAnswRepository.newClick(""+ga.getCreated(), ""+ao.getAnswerOptionId(), id);
		
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	@RequestMapping("/getTree")
	public void getTree(){
		//	TODO Maybe not executed here WIP
		System.out.println("TODO method used in FrontendController");
		return;
	}
    public String hashString(String s) throws NoSuchAlgorithmException {
		byte[] hash = null;
		try {
		   MessageDigest md = MessageDigest.getInstance("SHA-256");
		   hash = md.digest(s.getBytes());
		
		} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
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
