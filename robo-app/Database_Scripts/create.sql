-- Luontiskripti 14.10.2015

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS Dialog;
DROP TABLE IF EXISTS Question;
DROP TABLE IF EXISTS AnswerOption;
DROP TABLE IF EXISTS Closing;
DROP TABLE IF EXISTS GivenAnswer;
DROP TABLE IF EXISTS Session;
SET foreign_key_checks = 1;

CREATE TABLE dialog(
  dialog_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(300) NOT NULL,
  enabled BOOLEAN NOT NULL DEFAULT '0',
  created DATETIME,
  PRIMARY KEY (dialog_id)
) ENGINE=InnoDB;

CREATE TABLE question(
  question_id INT NOT NULL AUTO_INCREMENT,
  dialog_id INT NOT NULL,
  text VARCHAR(1000) NOT NULL,
  answer_type VARCHAR(16) NOT NULL,
  PRIMARY KEY (question_id)
) ENGINE=InnoDB;

CREATE TABLE answer_option(
  answer_option_id INT NOT NULL AUTO_INCREMENT,
  question_id INT NOT NULL,
  text VARCHAR(1000),
  order_index INT NOT NULL,
  next_question_id INT,
  closing_id INT,
  PRIMARY KEY (answer_option_id)
) ENGINE=InnoDB;

CREATE TABLE closing(
  closing_id INT NOT NULL AUTO_INCREMENT,
  text VARCHAR(2000) NOT NULL,
  product_url VARCHAR(2083),
  to_email VARCHAR(254),
  PRIMARY KEY (closing_id)
) ENGINE=InnoDB;

CREATE TABLE given_answer(
  session_id VARCHAR(128) NOT NULL,
  answer_option_id INT NOT NULL,
  created DATETIME,
  PRIMARY KEY (session_id, answer_option_id)
) ENGINE=InnoDB;

CREATE TABLE session(
  session_id VARCHAR(128) NOT NULL,
  created DATETIME,
  PRIMARY KEY (session_id)
) ENGINE=InnoDB;

ALTER TABLE question
ADD CONSTRAINT fk_question_dialog_id
FOREIGN KEY (dialog_id) REFERENCES dialog (dialog_id)
ON UPDATE CASCADE
ON DELETE NO ACTION;

ALTER TABLE answer_option
ADD CONSTRAINT fk_answer_option_question_id
FOREIGN KEY (question_id) REFERENCES question (question_id)
ON UPDATE CASCADE
ON DELETE NO ACTION,

ADD CONSTRAINT fk_answer_option_closing_id
FOREIGN KEY (closing_id) REFERENCES closing (closing_id)
ON UPDATE CASCADE
ON DELETE NO ACTION;

ALTER TABLE given_answer
ADD CONSTRAINT fk_given_answer_session_id
FOREIGN KEY (session_id) REFERENCES session (session_id)
ON UPDATE CASCADE
ON DELETE NO ACTION,

ADD CONSTRAINT fk_given_answer_answer_option_id
FOREIGN KEY (answer_option_id) REFERENCES answer_option (answer_option_id)
ON UPDATE CASCADE
ON DELETE NO ACTION;
