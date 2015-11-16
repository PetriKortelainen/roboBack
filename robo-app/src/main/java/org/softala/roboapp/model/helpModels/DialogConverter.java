package org.softala.roboapp.model.helpModels;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Question;

/**
 *
 *
 */
public class DialogConverter {
	private Dialog dialog = new Dialog();
	private Set<Question> questions = new HashSet<Question>();
	
	public Dialog convertDialogToHibernate(DialogRestBean dialogRestBean) {
		System.out.println("convertDialogToHibernate");
		dialog.setName(dialogRestBean.getDialogName());
		dialog.setCreated(dialogRestBean.getDialogCreated());
		
		Question firstQuestion = new Question(dialog, dialogRestBean.getQuestionText(), "");
		
		Set<AnswerOption> answers = convertSubNodesToHibernate(dialogRestBean.getDialogNodes());
		
		firstQuestion.setAnswerOptions(answers);
		
		for(Question q : questions) {
			Set<AnswerOption> ansOptions = q.getAnswerOptions();
			for(AnswerOption a : ansOptions) {
				System.out.println(a.getText());
			}
		}
		
		//dialog.setQuestions(questions);
		
		return dialog;
	}
	
	private Set<AnswerOption> convertSubNodesToHibernate(List<DialogNodeRestBean> nodes) {	
		Set<AnswerOption> hibernateAnswers = new HashSet<AnswerOption>();
		
		for(DialogNodeRestBean node : nodes) {
			if(!node.getAnswerText().isEmpty()) {
				AnswerOption hibernateAnswer = new AnswerOption();
				hibernateAnswer.setText(node.getAnswerText());
				
				if(!node.getQuestionText().isEmpty()) {
					Question hibernateQuestion = new Question();
					hibernateQuestion.setText(node.getQuestionText());
					
					Set<AnswerOption> subAnswers = convertSubNodesToHibernate(node.getNodes());
					hibernateQuestion.setAnswerOptions(subAnswers);
					
					hibernateAnswer.setQuestion(hibernateQuestion);
					
					hibernateQuestion.setAnswerType("");
					hibernateQuestion.setDialog(dialog);
					
					questions.add(hibernateQuestion);
				}	
				hibernateAnswers.add(hibernateAnswer);
			}	
		}	
		return hibernateAnswers;
		
	}
}
