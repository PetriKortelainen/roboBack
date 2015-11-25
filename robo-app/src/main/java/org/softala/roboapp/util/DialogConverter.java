package org.softala.roboapp.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.softala.roboapp.model.AnswerOption;
import org.softala.roboapp.model.Dialog;
import org.softala.roboapp.model.Question;
import org.softala.roboapp.model.rest.RestDialogNode;
import org.softala.roboapp.model.rest.RestDialog;

/**
 *@author team3
 *
 * Converts the dialog given by the front-end to matching hibernate models.
 * 
 * Friendly advice for the next developers: Fixing the hibernate and database would propably 
 * make further development much easier and render this converter useless.
 */
public class DialogConverter {
	private Dialog dialog = new Dialog();
	private List<Question> questions = new ArrayList<Question>();
	
	/**
	 * Map for being able to put right question ids to the answer's nextQuestionId.
	 */
	public Map<Question, AnswerOption> nextQuestionMap = new HashMap<Question, AnswerOption>();
	
	/**
	 * Converts first question separately then the sub answers and questions using convertSubNodesToHibernate().
	 */
	public Dialog convertDialogToHibernate(RestDialog restDialog) {
		dialog.setName(restDialog.getDialogName());
		Date now = new Date(System.currentTimeMillis());
		dialog.setCreated(now);
		
		Question firstQuestion = new Question(dialog, restDialog.getQuestionText(), "");
		
		questions.add(firstQuestion);
		
		//questions and answers created in the front-end -> Wololo wololo wololo -> hibernate questions and answers
		Set<AnswerOption> answers = convertSubNodesToHibernate(restDialog.getDialogNodes());
		
		//Set the firstQuestion as the previous question for the first branch of answers.
		for(AnswerOption answerOption : answers) {
			answerOption.setQuestion(firstQuestion);
		}
		
		//Set the first branch of answers to the firstQuestion.
		questions.iterator().next().setAnswerOptions(answers);
		
		//Convert the list of questions to Seq<Question> (required by the Dialog class).
		Set<Question> questionSet = new HashSet<Question>(questions);
		//Set all of the converted questions to the dialog.
		dialog.setQuestions(questionSet);
		
		return dialog;
	}
	
	/**
	 * Traverses dialog tree and converts the sub nodes to matching hibernate models
	 * 
	 * @param nodes 	list of rest bean nodes
	 * @return			list of hibernate AnswerOptions
	 */
	private Set<AnswerOption> convertSubNodesToHibernate(List<RestDialogNode> nodes) {	
		Set<AnswerOption> hibernateAnswers = new HashSet<AnswerOption>();
		
		//Loop through nodes given in the parameters.
		for(RestDialogNode node : nodes) {
			//Start converting to hibernate only if the current node's answer text is not empty.
			if(!node.getAnswerText().isEmpty()) {
				AnswerOption hibernateAnswer = new AnswerOption();
				hibernateAnswer.setText(node.getAnswerText());
				
				if(!node.getQuestionText().isEmpty()) {
					Question hibernateQuestion = new Question();
					hibernateQuestion.setText(node.getQuestionText());
					
					//Continue traversing the tree and convert the inner nodes until all of the branches have been converted.
					Set<AnswerOption> subAnswers = convertSubNodesToHibernate(node.getNodes());

					//Assign the current question to the sub answers.
					for(AnswerOption subAnswer: subAnswers) {
						//set the previous question for sub answers to the current question
						subAnswer.setQuestion(hibernateQuestion);
						//put the current answer and its next question to a map
						nextQuestionMap.put(subAnswer.getQuestion(), hibernateAnswer);
					}
					
					hibernateQuestion.setAnswerOptions(subAnswers);
					
					hibernateQuestion.setAnswerType("choice");
					hibernateQuestion.setDialog(dialog);
					
					//Add the converted question with its answer options to a Set<Question>.
					questions.add(hibernateQuestion);
				}	
				hibernateAnswers.add(hibernateAnswer);
			}	
		}	
		return hibernateAnswers;		
	}
}
