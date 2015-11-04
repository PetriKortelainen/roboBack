package org.softala.roboapp.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.softala.roboapp.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
public class QuestionControllerTest {

	@InjectMocks
	QuestionController controller;

	@Autowired
	WebApplicationContext context;

	private MockMvc mvc;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		;
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	/**
	 * Test method for {@link QuestionController#allquestions()}
	 */
	@Test
	public void testAllquestions() {
		try {
			this.mvc.perform(get("/questions/repository/all")).andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link QuestionController#getQuestionById(String)}
	 */
	@Test
	public void testGetQuestionById() {
		try {
			this.mvc.perform(get("/questions/repository/1")).andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
