insert into Author (age,name) VALUES (5, 'Marci');
insert into Author (age,name) VALUES (2, 'Levi');
insert into STORIES (title,content,posted,author_id) VALUES ('Marci meséje 1', 'Egyszer volt, hol nem volt.', NOW(), (select id FROM AUTHOR where name = 'Marci'));
insert into STORIES (title,content,posted,author_id) VALUES ('Marci meséje 2', 'Hol volt, hol nem volt, volt egyszer egy...', NOW(), (select id FROM AUTHOR where name = 'Marci'));
insert into STORIES (title,content,posted,author_id) VALUES ('Levi meséje 1', 'Itt a vége, fuss el véle!', NOW(), (select id FROM AUTHOR where name = 'Levi'));
insert into STORIES (title,content,posted,author_id) VALUES ('Levi meséje 2', 'Boldogan éltek, míg meg nem haltak.', NOW(), (select id FROM AUTHOR where name = 'Levi'));
insert into STORIES (title,content,posted,author_id) VALUES ('szia', 'A title-alapú keresés eredménye.', NOW(), (select id FROM AUTHOR where name = 'Levi'));