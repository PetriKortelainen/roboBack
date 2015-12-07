-- Luontiskripti 26.10.2015

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS dialog;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS answer_option;
DROP TABLE IF EXISTS closing;
DROP TABLE IF EXISTS given_answer;
DROP TABLE IF EXISTS session;
DROP TABLE IF EXISTS order_contact;
SET foreign_key_checks = 1;

CREATE TABLE dialog(
  dialog_id INT NOT NULL AUTO_INCREMENT,
  name LONGTEXT NOT NULL,
  enabled TINYINT(1) NOT NULL,
  created DATETIME,
  PRIMARY KEY (dialog_id)
) ENGINE=InnoDB;

CREATE TABLE question(
  question_id INT NOT NULL AUTO_INCREMENT,
  dialog_id INT NOT NULL,
  text LONGTEXT NOT NULL,
  answer_type VARCHAR(16) NOT NULL,
  PRIMARY KEY (question_id)
) ENGINE=InnoDB;

CREATE TABLE answer_option(
  answer_option_id INT NOT NULL AUTO_INCREMENT,
  question_id INT NOT NULL,
  text LONGTEXT,
  order_index INT NOT NULL,
  next_question_id INT,
  closing_id INT,
  PRIMARY KEY (answer_option_id)
) ENGINE=InnoDB;

CREATE TABLE closing(
  closing_id INT NOT NULL AUTO_INCREMENT,
  text LONGTEXT NOT NULL,
  product_url LONGTEXT,
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

CREATE TABLE order_contact(
  order_id INT NOT NULL AUTO_INCREMENT,
  session_id VARCHAR(128) NOT NULL,
  email VARCHAR(254) NOT NULL,
  created DATETIME,
  PRIMARY KEY (order_id)
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

ALTER TABLE order_contact
ADD CONSTRAINT fk_order_contact_session_id
FOREIGN KEY (session_id) REFERENCES session (session_id)
ON UPDATE CASCADE
ON DELETE NO ACTION;
