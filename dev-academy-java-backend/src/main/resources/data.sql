DROP TABLE IF EXISTS colour;
DROP TABLE IF EXISTS people;
DROP TABLE IF EXISTS person_colours;

CREATE TABLE colour (
	id BIGINT NOT NULL PRIMARY KEY,
	name VARCHAR(10) NOT NULL
);

CREATE TABLE people (
	id BIGINT NOT NULL PRIMARY KEY,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	authorised BIT NOT NULL,
	enabled BIT NOT NULL
);

CREATE TABLE person_colours (
	person_id BIGINT NOT NULL,
	colour_id BIGINT NOT NULL,
	FOREIGN KEY (person_id) REFERENCES people(id),
	FOREIGN KEY (colour_id) REFERENCES colour(id)
);

CREATE SEQUENCE SQ_COLOUR_ID;

INSERT INTO colour 
 (id, name) 
VALUES
 (colour_seq.NEXTVAL, 'Red'),
 (colour_seq.NEXTVAL, 'Green'),
 (colour_seq.NEXTVAL, 'Blue');
 
INSERT INTO people 
 (id, first_name, last_name, authorised, enabled) 
VALUES 
 (person_seq.NEXTVAL, 'Bo', 'Bob', true, false),
 (person_seq.NEXTVAL, 'Brian', 'Allen', true, true),
 (person_seq.NEXTVAL, 'Courtney', 'Arnold', true, true),
 (person_seq.NEXTVAL, 'Gabriel', 'Francis', false, false),
 (person_seq.NEXTVAL, 'George', 'Edwards', true, false),
 (person_seq.NEXTVAL, 'Imogen', 'Kent', false, false),
 (person_seq.NEXTVAL, 'Joel', 'Daly', true, true),
 (person_seq.NEXTVAL, 'Lilly', 'Hale', false, false),
 (person_seq.NEXTVAL, 'Patrick', 'Kerr', true, true),
 (person_seq.NEXTVAL, 'Sharon', 'Halt', false, false),
 (person_seq.NEXTVAL, 'Willis', 'Tibbs', true, false);
 
INSERT INTO person_colours 
 (person_id, colour_id) 
VALUES 
 (1, 1),
 (2, 1),
 (2, 2),
 (2, 3),
 (3, 1),
 (4, 2),
 (5, 2),
 (5, 3),
 (6, 1),
 (6, 2),
 (7, 2),
 (8, 1),
 (8, 2),
 (8, 3),
 (9, 2),
 (10, 1),
 (10, 2),
 (10, 3),
 (11, 1),
 (11, 2),
 (11, 3);
 