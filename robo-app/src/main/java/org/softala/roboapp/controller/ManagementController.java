package org.softala.roboapp.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Hello;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.helpModels.DialogConverter;
import org.softala.roboapp.model.helpModels.DialogRestBean;
import org.softala.roboapp.model.helpModels.ManagementRestBean;
import org.softala.roboapp.repository.DialogRepository;
import org.softala.roboapp.repository.QuestionRepository;
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
	@Autowired
	private DialogRepository dialogRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void postJson (@RequestBody String json) {
		GsonFactory gson = new GsonFactory();
		DialogRestBean drb = gson.convertJsonToObject(DialogRestBean.class, json);
		
		DialogConverter converter = new DialogConverter();
		
		Dialog dialog = converter.convertDialogToHibernate(drb);
		
		System.out.println(dialog);
	}
	
	@RequestMapping(value = "get-dialogs", method = RequestMethod.GET)
	public List<ManagementRestBean> getDialogs() {
		List<ManagementRestBean> dialogs = new ArrayList<ManagementRestBean>();
		Iterator<Dialog> it = dialogRepository.findAll().iterator();
		
		while(it.hasNext()) {
			Dialog dialog = it.next();
			ManagementRestBean mrb = new ManagementRestBean();
			if (dialog.getDialogId() != null) {
				mrb.setId(dialog.getDialogId());
			}
			
			if(dialog.getName() != null) {
				mrb.setDialogName(dialog.getName());
			}
			
			if(dialog.isEnabled()) {
				mrb.setEnabled(true);
			}
			
			dialogs.add(mrb);
		}
		
		return dialogs;
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public void getJson() {
		
	}
}
