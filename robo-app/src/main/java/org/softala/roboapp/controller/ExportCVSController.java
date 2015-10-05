package org.softala.roboapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/export")
public class ExportCVSController {
	
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
			String outputString = (String) iter.next();
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
