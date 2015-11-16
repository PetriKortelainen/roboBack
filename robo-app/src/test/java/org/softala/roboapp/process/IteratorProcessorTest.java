package org.softala.roboapp.process;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;
import org.softala.roboapp.model.GivenAnswer;
import org.softala.roboapp.model.GivenAnswerId;

/**
 * 
 * @author a1300786
 *
 */
public class IteratorProcessorTest extends TestCase {

	/**
	 * Test that the Iterator processor actually changes the Iterable to ArrayList and for the
	 * same type. 
	 */
	@Test
	public void testIteratorProcess() {
		IteratorProcesser<GivenAnswer> processor = new IteratorProcesser<GivenAnswer>();
		ArrayList<GivenAnswer> answers = new ArrayList<>();
		
		GivenAnswer answer = new GivenAnswer();
		GivenAnswerId answerId = new GivenAnswerId();
		answerId.setAnswerOptionId(1);
		answerId.setSessionId("1");
		answer.setId(answerId);
		answers.add(answer);
		
		Iterable<GivenAnswer> iterable = answers;
		
		ArrayList<GivenAnswer> returned = processor.processToArrayList(iterable);
		
		assertNotNull(returned);
		for (GivenAnswer givenAnswer : returned) {
			assertEquals(answer, givenAnswer);
		}
	}

}