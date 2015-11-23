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
import org.softala.roboapp.model.helpModels.DialogConverter;
import org.softala.roboapp.model.helpModels.DialogRestBean;
import org.softala.roboapp.model.helpModels.ManagementRestBean;
import org.softala.roboapp.repository.AnswerOptionRepository;
import org.softala.roboapp.repository.DialogRepository;
import org.softala.roboapp.repository.QuestionRepository;
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
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void postJson (@RequestBody String json) {
		GsonFactory gson = new GsonFactory();
		DialogRestBean drb = gson.convertJsonToObject(DialogRestBean.class, json);
		
		DialogConverter converter = new DialogConverter();
		
		Dialog dialog = converter.convertDialogToHibernate(drb);
		
		dialogRepository.save(dialog);
		

		
		//Iterator<Question> iter = questionRepository.save(dialog.getQuestions()).iterator();
		
		for(Question currentQuestion : dialog.getQuestions()) {
			System.out.println(currentQuestion.getText());
			
			for(AnswerOption ao: currentQuestion.getAnswerOptions()) {
				System.out.println("asdasd " + ao.getText());
			}
			
			int nextQuestionId = questionRepository.save(currentQuestion).getQuestionId();
			
			AnswerOption previousAnswerOption = converter.nextQuestionMap.get(currentQuestion);
			if(previousAnswerOption != null) {
				previousAnswerOption.setNextQuestionId(nextQuestionId);
				System.out.println(previousAnswerOption.getNextQuestionId());
			}
		}
		
		for(Question currentQuestion : dialog.getQuestions()) {
			answerOptionRepository.save(currentQuestion.getAnswerOptions());
		}
		
		/*while(iter.hasNext()) {
			Question q = iter.next();
			System.out.println(q.getQuestionId() + " " + q.getText());
		}*/
		
		Iterator<Question> it = dialog.getQuestions().iterator();
		
/*		while(it.hasNext()) {
			Question currentQuestion = it.next();
			int nextQuestionId = questionRepository.save(currentQuestion).getQuestionId();
			AnswerOption currentAnswerOption = converter.nextQuestionMap.get(currentQuestion);
			if(currentAnswerOption != null) {
				currentAnswerOption.setAnswerOptionId(nextQuestionId);
				answerOptionRepository.save(currentQuestion.getAnswerOptions());
			}
		}*/
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public Dialog editDialog(@PathVariable("id") Integer id) {
		return dialogRepository.findOne(id);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public void deleteDialog(@PathVariable("id") Integer id) {
		Dialog dialog = dialogRepository.findOne(id);
		dialogRepository.delete(dialog);
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
