package org.softala.roboapp.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Hello;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.helpModels.DialogRestBean;
import org.softala.roboapp.model.helpModels.ManagementRestBean;
import org.softala.roboapp.repository.AnswerOptionRepository;
import org.softala.roboapp.repository.DialogRepository;
import org.softala.roboapp.repository.QuestionRepository;
import org.softala.roboapp.util.DialogConverter;
import org.softala.roboapp.util.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private AnswerOptionRepository answerOptionRepository;
	
	/**
	 * Saves single dialogs given by the front-end.
	 * 
	 * @param json
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void postJson (@RequestBody String json) {
		GsonFactory gson = new GsonFactory();
		// Convert the json to rest beans.
		DialogRestBean drb = gson.convertJsonToObject(DialogRestBean.class, json);
		
		DialogConverter converter = new DialogConverter();
		
		//Convert the rest beans to hibernate beans.
		Dialog dialog = converter.convertDialogToHibernate(drb);
		
		dialogRepository.save(dialog);
		//Save questions, get the next question ids and set them to the correct answers.
		for(Question currentQuestion : dialog.getQuestions()) {
			int nextQuestionId = questionRepository.save(currentQuestion).getQuestionId();
			
			AnswerOption previousAnswerOption = converter.nextQuestionMap.get(currentQuestion);
			if(previousAnswerOption != null) {
				previousAnswerOption.setNextQuestionId(nextQuestionId);
			}
		}
		
		//Save answers.
		for(Question currentQuestion : dialog.getQuestions()) {
			answerOptionRepository.save(currentQuestion.getAnswerOptions());
		}
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public Dialog editDialog(@PathVariable("id") Integer id) {
		return dialogRepository.findOne(id);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public void deleteDialog(@PathVariable("id") Integer id) {
		Dialog dialog = dialogRepository.findOne(id);
		if(!dialog.isEnabled()) {
			dialogRepository.delete(dialog);
		}
	}
	
	@RequestMapping(value = "activate/{id}", method = RequestMethod.GET)
	public void activateDialog(@PathVariable("id") Integer id) {
		Dialog dialog = dialogRepository.findOne(id);
		boolean isEnabled = dialog.isEnabled();
		dialog.setEnabled(!isEnabled);
		dialogRepository.save(dialog);
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
}
