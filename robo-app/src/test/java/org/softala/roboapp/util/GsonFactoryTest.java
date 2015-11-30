package org.softala.roboapp.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.softala.roboapp.model.rest.RestDialog;
import org.softala.roboapp.model.rest.RestDialogNode;

import junit.framework.TestCase;
/**
 * 
 * @author Mikko-Ville Salo
 *
 */

public class GsonFactoryTest extends TestCase{
	/*
	 * Test that Gsonfactory converts json to RestDialog class as expected
	 */
	@Test
	public void testGsonFactory(){
		GsonFactory gsonFactory = new GsonFactory();
		String jsonString = "{\"dialogName\":\"Dialog 1\",\"questionText\":\"Oletko kiinnostunut laitteesta?\",\"nodes\":[{\"answerText\":\"Kyllä\",\"answerOrderIndex\":0,\"questionText\":\"Oletko yrittäjä?\",\"nodes\":[]}]}";
		RestDialog dialog = gsonFactory.convertJsonToObject(RestDialog.class, jsonString);
		RestDialogNode n1 = new RestDialogNode();
		List<RestDialogNode> nodes1 = new ArrayList<RestDialogNode>();
		n1.setAnswerText("Kyllä");
		n1.setAnswerOrderIndex(0);
		n1.setNodes(nodes1);
		n1.setQuestionText("Oletko yrittäjä?");
		List<RestDialogNode> nodes = new ArrayList<RestDialogNode>();
		nodes.add(n1);
		RestDialog mock = new RestDialog();
		mock.setDialogNodes(nodes);
		mock.setDialogName("Dialog 1");
		mock.setQuestionText("Oletko kiinnostunut laitteesta?");
		
		String expected = mock.toString();
		String actual = dialog.toString();
		
		assertNotNull(dialog);
		assertEquals(expected, actual);
	}
}
