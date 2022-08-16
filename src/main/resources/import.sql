-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');
-- CREATE TABLE CATEGORIA
-- (nome VARCHAR(15),
-- idcategoria LONG primary key);
-- CREATE TABLE cliente
-- (vatnumber VARCHAR (11),
--  nome VARCHAR (100), 
--  email VARCHAR (30),
--  idade INT,
--  idcategoria LONG
-- id LONG PRIMARY KEY);
INSERT INTO CATEGORIA(nome) VALUES('Programador');
INSERT INTO CATEGORIA(nome) VALUES('Comerciante');
INSERT INTO CATEGORIA(nome) VALUES('Autonomo');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('ES012345678','Ana', 'ana@email.com', '19','1');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('PT111222333','Breno', 'breno@email.com', '50','1');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('ES000555999','Caio', 'caio@email.com', '39','1');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('PT111333555','Danilo', 'danilo@email.com', '18','2');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('DK999666444','Elaine', 'elaine@email.com', '28','2');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('IT444555888','Fabio', 'fabio@email.com', '61','2');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('FR222333777','Greta', 'greta@email.com', '32','3');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('IE777444555','Helio', 'helio@email.com', '22','3');
INSERT INTO CLIENTE(vatnumber,nome, email, idade, categoria) VALUES('IE777444222','Igor', 'igor@email.com', '15','3');
