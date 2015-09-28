 insert into dialog (created, enabled, name) VALUES (NOW(), TRUE, "Testi puu");
 
 insert into question Values(1,"Q1","option","Esimerkki teksti");
 insert into question Values(1,"Q2","option","Esimerkki teksti 2");
 
 insert into answer_option Values ("A1", 1, "Q1", "Q2", 1, NULL, "Oletko esimerkikki?");
 insert into answer_option Values ("A2", 1, "Q1", "Q2", 1, NULL, "Oletko esimerkikki 2?");

 insert into session Values ("some_session", NOW(), "browser");
 
 insert into given_answer Values ("A2", 1, "Q1", "some_session", NOW());