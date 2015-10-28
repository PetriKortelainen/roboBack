-- Insert test data 26.10.2015

INSERT INTO dialog(name, enabled, created) VALUES ('Perusdialogi', 1, NOW());
SET @dialogId = LAST_INSERT_ID();

INSERT INTO question(dialog_id, text, answer_type) VALUES(@dialogID, 'Miten menee?', 'choice');

SET @Q1 = LAST_INSERT_ID();

INSERT INTO question(dialog_id, text, answer_type) VALUES(@dialogID, 'Onko hyvä fiilis?', 'choice');

SET @Q2 = LAST_INSERT_ID();

INSERT INTO question(dialog_id, text, answer_type) VALUES(@dialogID, 'Ostatko?', 'choice');

SET @Q3 = LAST_INSERT_ID();

INSERT INTO closing(text, product_url, to_email) VALUES('Hyvä, osta tästä härpäke', 'http://www.härpäke.fi', 'myynti@härpäke.fi');

SET @C1 = LAST_INSERT_ID();

INSERT INTO closing(text, product_url, to_email) VALUES('Harmi, osta tästä niin tulee parempi fiilis', 'http://www.härpäke.fi', 'myynti@härpäke.fi');

SET @C2 = LAST_INSERT_ID();

INSERT INTO answer_option(question_id, text, order_index, next_question_id) VALUES (@Q1, 'Ihan hyvin', 1, @Q2),(@Q1, 'Huonosti', 2, @Q3);
INSERT INTO answer_option(question_id, text, order_index, closing_id) VALUES (@Q2, 'Joo', 1, @C1),(@Q2, 'Ei', 2, @C2);
INSERT INTO answer_option(question_id, text, order_index) VALUES (@Q3, 'Kyllä', 1),(@Q3, 'En', 2);
