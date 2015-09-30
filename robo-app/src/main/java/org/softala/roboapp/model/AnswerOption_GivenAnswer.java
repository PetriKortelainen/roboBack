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
	@Id
	public final int MockId;
	@Column(name = "id_AnswerOption")
	public final String AnswerOption;
	@Column(name = "id_GivenAnswer")
	public final int GivenAnswer;
	
	public AnswerOption_GivenAnswer(int MockId, String AnswerOption, int GivenAnswer){
		this.MockId = 1;
		this.AnswerOption = AnswerOption;
		this.GivenAnswer = GivenAnswer;
	}

	public AnswerOption_GivenAnswer(){
		this.MockId = 1;
		this.AnswerOption = "";
		this.GivenAnswer = 0;
	}
	
	public int getMockId(){
		return MockId;
	}
	
	public String getAnswerOption() {
		return AnswerOption;
	}

	
	public int getGivenAnswer() {
		return GivenAnswer;
	}
	
}