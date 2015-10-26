/**
 * 
 */
package org.softala.roboapp.controller;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Ignore;
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
 * @author Tuomas Törmä
 * @since 14.10.2015
 * 
 * 
 * The MIT License (MIT)
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
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
public class TestDialogRepositoryTest extends TestCase{
	
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
