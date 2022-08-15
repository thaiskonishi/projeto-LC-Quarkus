-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');

INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('ES012345678','Ana', 'ana@email.com', '19');
INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('PT111222333','Breno', 'breno@email.com', '50');
INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('ES000555999','Caio', 'caio@email.com', '39');
INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('PT111333555','Danilo', 'danilo@email.com', '18');
INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('DK999666444','Elaine', 'elaine@email.com', '28');
INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('IT444555888','Fabio', 'fabio@email.com', '61');
INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('FR222333777','Greta', 'greta@email.com', '32');
INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('IE777444555','Helio', 'helio@email.com', '22');
INSERT INTO CLIENTE(vatnumber,nome, email, idade) VALUES('IE777444222','Igor', 'igor@email.com', '15');
INSERT INTO CATEGORIA(nome) VALUES('Programador');
INSERT INTO CATEGORIA(nome) VALUES('Comerciante');