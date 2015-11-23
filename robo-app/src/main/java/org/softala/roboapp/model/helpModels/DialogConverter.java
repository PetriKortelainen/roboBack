package org.softala.roboapp.model.helpModels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Question;

/**
 *@author team3
 * Converts the dialog given by the front-end to matching hibernate beans.
 *
 */
public class DialogConverter {
	private Dialog dialog = new Dialog();
	private List<Question> questions = new ArrayList<Question>();
	
	public Map<Question, AnswerOption> nextQuestionMap = new HashMap<Question, AnswerOption>();
	
	public Dialog convertDialogToHibernate(DialogRestBean dialogRestBean) {
		System.out.println("convertDialogToHibernate");
		dialog.setName(dialogRestBean.getDialogName());
		dialog.setCreated(dialogRestBean.getDialogCreated());
		
		Question firstQuestion = new Question(dialog, dialogRestBean.getQuestionText(), "");
		
		questions.add(firstQuestion);
		
		Set<AnswerOption> answers = convertSubNodesToHibernate(dialogRestBean.getDialogNodes());
		
		for(AnswerOption answerOption : answers) {
			answerOption.setQuestion(firstQuestion);
		}
		
		questions.iterator().next().setAnswerOptions(answers);
		
		//print for debugging
		for(Question q : questions) {
			Set<AnswerOption> ansOptions = q.getAnswerOptions();
			for(AnswerOption a : ansOptions) {
				System.out.println("q" + q.getText() + "a" + a.getText());
			}
		}
		
		Set<Question> foo = new HashSet<Question>(questions);
		dialog.setQuestions(foo);
		
		return dialog;
	}
	
	/**
	 * Traverses tree and converts the sub nodes to matching hibernate beans
	 * @param nodes
	 * @return
	 */
	private Set<AnswerOption> convertSubNodesToHibernate(List<DialogNodeRestBean> nodes) {	
		Set<AnswerOption> hibernateAnswers = new HashSet<AnswerOption>();
		
		for(DialogNodeRestBean node : nodes) {
			if(!node.getAnswerText().isEmpty()) {
				AnswerOption hibernateAnswer = new AnswerOption();
				hibernateAnswer.setText(node.getAnswerText());
				System.out.println("hibernateAnswer: " + hibernateAnswer.getText());
				
				if(!node.getQuestionText().isEmpty()) {
					Question hibernateQuestion = new Question();
					hibernateQuestion.setText(node.getQuestionText());
					
					Set<AnswerOption> subAnswers = convertSubNodesToHibernate(node.getNodes());

					//set the questions of subAnswers to the current question
					for(AnswerOption subAnswer: subAnswers) {
						System.out.println("subAnswer:" + subAnswer.getText());
						subAnswer.setQuestion(hibernateQuestion);
						//put the current answer and its next questions to a map
						nextQuestionMap.put(subAnswer.getQuestion(), hibernateAnswer);
					}
					
					hibernateQuestion.setAnswerOptions(subAnswers);
					for(AnswerOption ao: hibernateQuestion.getAnswerOptions()) {
						System.out.println("hibernateQuestion answers: " + ao.getText());
					}
					
					//set the previous question for the current answer
					//hibernateAnswer.setQuestion(hibernateQuestion);
					
					hibernateQuestion.setAnswerType("");
					hibernateQuestion.setDialog(dialog);
					
					//add the converted question with its answer options to a Set<Question>
					questions.add(hibernateQuestion);
				}	
				hibernateAnswers.add(hibernateAnswer);
			}	
		}	
		return hibernateAnswers;
		
	}
}
