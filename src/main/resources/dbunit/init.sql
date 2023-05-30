DROP TABLE GAME
DROP TABLE USR
DROP TABLE CONSOLE

CREATE TABLE GAME (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, GENRE VARCHAR(255), NAME VARCHAR(255), URLIMAGEM VARCHAR(255), URLROOM VARCHAR(255), CONSOLE_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE USR (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, EMAIL VARCHAR(255) UNIQUE, ISADMIN SMALLINT DEFAULT 0, NAME VARCHAR(255), PASSWORD VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE CONSOLE (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, FABRICANTE VARCHAR(255), ANOLANCAMENTO BIGINT, NOME VARCHAR(255), PRIMARY KEY (ID))
ALTER TABLE GAME ADD CONSTRAINT FK_GAME_CONSOLE_ID FOREIGN KEY (CONSOLE_ID) REFERENCES CONSOLE (ID)

INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME) VALUES ('Nintendo', 2001, 'Game Boy Advance')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME) VALUES ('Sony', 1994, 'PlayStation')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME) VALUES ('Atari', 1977, 'Atari 2600')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME) VALUES ('Sega', 1989, 'Master System')


INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Metal Slug Advance', 1, 'Run and Gun', 'https://media.retroachievements.org/Images/069381.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Mario and Luigi: Superstar Saga', 1, 'Turn-based RPG', 'https://media.retroachievements.org/Images/014492.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Legend of Zelda, The: A Link to the Past and Four Swords', 1, 'Action-Adventure', 'https://media.retroachievements.org/Images/022503.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Pokemon Emerald Version', 1, 'Turn-based RPG', 'https://media.retroachievements.org/Images/014406.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Metroid Fusion', 1, 'Metroidvania', 'https://media.retroachievements.org/Images/000649.png', '')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Crash Bandicoot', 2, '3D Platforming', 'https://media.retroachievements.org/Images/027330.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Metal Gear Solid', 2, 'Action', 'https://media.retroachievements.org/Images/046645.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Resident Evil 3: Nemesis', 2, 'Survival Horror', 'https://media.retroachievements.org/Images/047497.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Silent Hill', 2, 'Survival Horror', 'https://media.retroachievements.org/Images/045302.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Tomb Raider', 2, 'Action-Adventure', 'https://media.retroachievements.org/Images/026539.png', '')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Mega Man', 3, 'Platforming', 'https://media.retroachievements.org/Images/039297.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Pac-Man 4K', 3, 'Arcade', 'https://media.retroachievements.org/Images/019939.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Tetris26', 3, 'Puzzle', 'https://media.retroachievements.org/Images/020116.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Garfield', 3, 'Arcade', 'https://media.retroachievements.org/Images/047779.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Popeye', 3, 'Maze Chase', 'https://media.retroachievements.org/Images/058473.png', '')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Sonic the Hedgehog', 4, 'Platforming', 'https://media.retroachievements.org/Images/010429.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Michael Jackson''s Moonwalker', 4, 'Action', 'https://media.retroachievements.org/Images/056029.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Ayrton Senna''s Super Monaco GP II', 4, 'Race', 'https://media.retroachievements.org/Images/010618.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Aladdin', 4, '2D Platforming', 'https://media.retroachievements.org/Images/056303.png', '')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM) VALUES ('Golden Axe', 4, 'Beat ''em Up', 'https://media.retroachievements.org/Images/017272.png', '')

INSERT INTO USR (NAME, EMAIL, PASSWORD) VALUES ('jorge', 'jorge@email.com', '202cb962ac59075b964b07152d234b70')
INSERT INTO USR (NAME, EMAIL, PASSWORD, ISADMIN) VALUES ('paula', 'paula@email.com', '202cb962ac59075b964b07152d234b70', 1)
