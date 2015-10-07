/**
 * 
 */
package org.softala.roboapp.controller;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.softala.roboapp.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
 

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


/**
 * Test for {@link DialogController} in order to check if the rest controller is active
 * @author a1300786
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
@Profile("test")
public class TestDialogRepository extends TestCase{
	
	@InjectMocks
	DialogController dialogController;
	
	@Autowired
	WebApplicationContext context;
	
	private MockMvc mvc;
	

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {;
		 MockitoAnnotations.initMocks(this);
	     this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	/**
	 * Test method for {@link org.softala.roboapp.controller.DialogController#getAllDialogs()}.
	 */
	@Test
	public void testGetAllDialogs() {
		try {
			this.mvc.perform(get("/dialog/repository/all"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link org.softala.roboapp.controller.DialogController#getDialogWithId(java.lang.Integer)}.
	 */
	@Test
	public void testGetDialogWithId() {
		try {
			this.mvc.perform(get("/dialog/repository/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
