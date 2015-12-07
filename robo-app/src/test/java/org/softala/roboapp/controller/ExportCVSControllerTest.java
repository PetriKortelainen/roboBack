package org.softala.roboapp.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.softala.roboapp.App;
import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.GivenAnswerId;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
public class ExportCVSControllerTest {
	
	@InjectMocks
	ExportCVSController controller;
	
	@Autowired
	WebApplicationContext context;
	
	private MockMvc mvc;
	private Dialog dialog;
	
	

	@Before
	public void setUp() throws Exception {
		dialog = new Dialog();
		dialog.setDialogId(1);
		dialog.setEnabled(true);
		dialog.setName("Testi puu");
		
		Question question = new Question();
		question.setAnswerType("textbox");
		question.setQuestionId(1);
		question.setText("Esimerkki kysymys");
		
		AnswerOption option = new AnswerOption();
		option.setText("Esimerkki vastaus");
		
		GivenAnswerId answerID = new GivenAnswerId();
		answerID.setAnswerOptionId(1);
		
		GivenAnswer answer = new GivenAnswer();
		answer.setId(answerID);
		answer.setAnswerOption(option);
		
		Session session = new Session();
		session.setSessionId(1+"");
		session.getGivenAnswers().add(answer);
	
		option.setQuestion(question);
		
		question.getAnswerOptions().add(option);
		
		dialog.getQuestions().add(question);
		
		MockitoAnnotations.initMocks(this);
	    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
		
	}

	@Test
	public void testDownloadGivenAnswersCVS() {
		try {
			MvcResult result = this.mvc.perform(get("/export/given_answers"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
			
			assertNotNull(result.getResponse());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
