package org.softala.roboapp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.rest.RestManagement;
import org.softala.roboapp.model.rest.RestDialog;
import org.softala.roboapp.repository.AnswerOptionRepository;
import org.softala.roboapp.repository.DialogRepository;
import org.softala.roboapp.repository.GivenAnswerRepository;
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
 * Controller for admin actions
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
	
	@Autowired
	private GivenAnswerRepository givenAnswerRepository;
	
	/**
	 * Saves single dialogs given by the front-end.
	 * 
	 * @param json
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public void postJson (@RequestBody String json) {
		GsonFactory gson = new GsonFactory();
		// Convert the json to rest versions of the dialog, question and answer models.
		RestDialog rd = gson.convertJsonToObject(RestDialog.class, json);
		
		DialogConverter converter = new DialogConverter();
		
		//Convert the dialog given by the front-end to hibernate dialog.
		Dialog dialog = converter.convertDialogToHibernate(rd);
		
		//save the dialog (doesn't save the questions and answers automatically due to interesting solutions in the hibernate models and database
		dialogRepository.save(dialog);
		
		//Save the questions, get the next question ids and set them to the correct answers.
		for(Question currentQuestion : dialog.getQuestions()) {
			int nextQuestionId = questionRepository.save(currentQuestion).getQuestionId();
			
			AnswerOption previousAnswerOption = converter.nextQuestionMap.get(currentQuestion);
			if(previousAnswerOption != null) {
				previousAnswerOption.setNextQuestionId(nextQuestionId);
			}
		}
		
		//Save the answers.
		for(Question currentQuestion : dialog.getQuestions()) {
			answerOptionRepository.save(currentQuestion.getAnswerOptions());
		}
	}
	
	/**
	 * TODO: dialog editing.
	 */
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public Dialog editDialog(@PathVariable("id") Integer id) {
		return dialogRepository.findOne(id);
	}
	
	/**
	 * Deletes dialog by the given dialog id.
	 */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public void deleteDialog(@PathVariable("id") Integer id) {
		Dialog dialog = dialogRepository.findOne(id);
		if(!dialog.isEnabled()) {
			Set<Question> questions = dialog.getQuestions();
			for(Question q : questions) {
				Set<AnswerOption> ansOptions = q.getAnswerOptions();
				
				for(AnswerOption ao : ansOptions) {
					givenAnswerRepository.delete(ao.getGivenAnswers());
				}
				
				answerOptionRepository.delete(ansOptions);
			}
			questionRepository.delete(questions);
			
			dialogRepository.delete(dialog);
		}
	}
	
	/**
	 * Used for enabling and disabling a dialog.
	 */
	@RequestMapping(value = "activate/{id}", method = RequestMethod.GET)
	public void activateDialog(@PathVariable("id") Integer id) {
		Dialog dialog = dialogRepository.findOne(id);
		boolean isEnabled = dialog.isEnabled();
		dialog.setEnabled(!isEnabled);
		dialogRepository.save(dialog);
	}
	
	/**
	 * Retrieves a list of hibernate dialogs 
	 * and returns rest beans with unnecessary fields removed.
	 */
	@RequestMapping(value = "get-dialogs", method = RequestMethod.GET)
	public List<RestManagement> getDialogs() {
		List<RestManagement> dialogs = new ArrayList<RestManagement>();
		Iterator<Dialog> it = dialogRepository.findAll().iterator();
		
		while(it.hasNext()) {
			Dialog dialog = it.next();
			RestManagement restManagement = new RestManagement();
			if (dialog.getDialogId() != null) {
				restManagement.setId(dialog.getDialogId());
			}
			
			if(dialog.getName() != null) {
				restManagement.setDialogName(dialog.getName());
			}
			
			if(dialog.isEnabled()) {
				restManagement.setEnabled(true);
			}
			
			dialogs.add(restManagement);
		}
		
		return dialogs;
	}
}
