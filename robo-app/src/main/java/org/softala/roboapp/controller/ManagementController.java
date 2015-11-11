package org.softala.roboapp.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.softala.roboapp.model.Hello;
import org.softala.roboapp.model.helpModels.DialogRestBean;
import org.softala.roboapp.repository.DialogRepository;
import org.softala.roboapp.util.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Team3
 * 
 *
 */
@RestController
@RequestMapping("/manage-api")
public class ManagementController {
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void postJson (@RequestBody String jsonString) {
		System.out.println(jsonString);
		
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public void getJson() {
		
	}
	
	@RequestMapping(value = "/testjson", method = RequestMethod.GET)
	public void testJson (/*@RequestBody String jsonString*/) {
		//System.out.println(jsonString);
		System.out.println("test");
//		
//		String json = "{\"dialogName\": \"Dialogi 1\",\"questiontext\": "
//				+ "\"Oletko kiinnostunut laitteesta?\",\"nodes\": []}";

	}
	
	@RequestMapping("/json")
	public Hello jsonTest(){
		return new Hello(1,"sup");
	}
	

	
	

}
