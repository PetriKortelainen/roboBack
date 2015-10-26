-- Insert test data 26.10.2015

INSERT INTO dialog(name, enabled, created) VALUES ('Testidialogi', 1, NOW());
SET @dialogId = LAST_INSERT_ID();

INSERT INTO question(dialog_id, text, answer_type) VALUES(@dialogID, 'Miten menee?', 'choice');

SET @Q1 = LAST_INSERT_ID();

INSERT INTO question(dialog_id, text, answer_type) VALUES(@dialogID, 'Onko hyvä fiilis?', 'choice');

SET @Q2 = LAST_INSERT_ID();

INSERT INTO question(dialog_id, text, answer_type) VALUES(@dialogID, 'Ostatko?', 'choice');

SET @Q3 = LAST_INSERT_ID();

INSERT INTO answer_option(question_id, text, order_index, next_question_id) VALUES (@Q1, 'Ihan hyvin', 1, @Q2),(@Q1, 'Huonosti', 2, @Q3);
