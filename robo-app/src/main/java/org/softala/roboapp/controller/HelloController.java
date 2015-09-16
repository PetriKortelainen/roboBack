package org.softala.roboapp.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.softala.roboapp.model.Hello;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/json")
	public Hello jsonHello(){
		return new Hello(1,"Heippa");
	}

}
