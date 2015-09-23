package org.softala.roboapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Kannan taulussa molemmat arvot pääavaimina, pitää vielä selvittää paras tapa määrittää ko. tilanne tässä
// siksi ei @Id annotaatiota

@Entity
@Table(name = "AnswerOption_GivenAnswer")
public class AnswerOption_GivenAnswer {
	@Column(name = "id_AnswerOption")
	public final String AnswerOption;
	@Column(name = "id_GivenAnswer")
	public final int GivenAnswer;
	
	public AnswerOption_GivenAnswer(String AnswerOption, int GivenAnswer){
		this.AnswerOption = AnswerOption;
		this.GivenAnswer = GivenAnswer;
	}

	
	public String getAnswerOption() {
		return AnswerOption;
	}

	
	public int getGivenAnswer() {
		return GivenAnswer;
	}
}
