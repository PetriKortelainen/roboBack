package org.softala.roboapp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.helpModels.DialogNodeRestBean;
import org.softala.roboapp.model.helpModels.DialogRestBean;

/**
 *@author team3
 * Converts the dialog given by the front-end to matching hibernate beans.
 *
 */
public class DialogConverter {
	private Dialog dialog = new Dialog();
	private List<Question> questions = new ArrayList<Question>();
	
	public Map<Question, AnswerOption> nextQuestionMap = new HashMap<Question, AnswerOption>();
	
	/**
	 * Converts first question separately then the sub answers and questions using convertSubNodesToHibernate().
	 *  
	 * @param dialogRestBean
	 * @return
	 */
	public Dialog convertDialogToHibernate(DialogRestBean dialogRestBean) {
		dialog.setName(dialogRestBean.getDialogName());
		dialog.setCreated(dialogRestBean.getDialogCreated());
		
		Question firstQuestion = new Question(dialog, dialogRestBean.getQuestionText(), "");
		
		questions.add(firstQuestion);
		
		//Wololo wololo wololo
		Set<AnswerOption> answers = convertSubNodesToHibernate(dialogRestBean.getDialogNodes());
		
		//Set the firstQuestion as the previous question for the first sub answers.
		for(AnswerOption answerOption : answers) {
			answerOption.setQuestion(firstQuestion);
		}
		
		//Set the sub answers to the firstQuestion.
		questions.iterator().next().setAnswerOptions(answers);
		
		//Convert the list of questions to Seq.
		Set<Question> questionSet = new HashSet<Question>(questions);
		//Set all of the converted questions to the dialog.
		dialog.setQuestions(questionSet);
		
		return dialog;
	}
	
	/**
	 * Traverses dialog tree and converts the sub nodes to matching hibernate beans
	 * 
	 * @param nodes 	list of rest bean nodes
	 * @return			list of hibernate AnswerOptions
	 */
	private Set<AnswerOption> convertSubNodesToHibernate(List<DialogNodeRestBean> nodes) {	
		Set<AnswerOption> hibernateAnswers = new HashSet<AnswerOption>();
		
		//Loop through rest bean nodes given in the arguments.
		for(DialogNodeRestBean node : nodes) {
			//Convert only if the current node's answer text is not empty.
			if(!node.getAnswerText().isEmpty()) {
				AnswerOption hibernateAnswer = new AnswerOption();
				hibernateAnswer.setText(node.getAnswerText());
				
				if(!node.getQuestionText().isEmpty()) {
					Question hibernateQuestion = new Question();
					hibernateQuestion.setText(node.getQuestionText());
					
					Set<AnswerOption> subAnswers = convertSubNodesToHibernate(node.getNodes());

					//set the questions of subAnswers to the current question
					for(AnswerOption subAnswer: subAnswers) {
						//set the previous question for sub answers to the current question
						subAnswer.setQuestion(hibernateQuestion);
						//put the current answer and its next question to a map
						nextQuestionMap.put(subAnswer.getQuestion(), hibernateAnswer);
					}
					
					hibernateQuestion.setAnswerOptions(subAnswers);
					
					hibernateQuestion.setAnswerType("choice");
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
