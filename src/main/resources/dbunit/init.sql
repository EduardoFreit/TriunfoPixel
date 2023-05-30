DROP TABLE GAME
DROP TABLE USR
DROP TABLE CONSOLE

CREATE TABLE GAME (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, GENRE VARCHAR(255), HASH VARCHAR(255), NAME VARCHAR(255), URLIMAGEM VARCHAR(255), URLROOM VARCHAR(255), CONSOLE_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE USR (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, EMAIL VARCHAR(255) UNIQUE, ISADMIN SMALLINT DEFAULT 0, NAME VARCHAR(255), PASSWORD VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE CONSOLE (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, FABRICANTE VARCHAR(255), ANOLANCAMENTO BIGINT, NOME VARCHAR(255), PRIMARY KEY (ID))
ALTER TABLE GAME ADD CONSTRAINT FK_GAME_CONSOLE_ID FOREIGN KEY (CONSOLE_ID) REFERENCES CONSOLE (ID)

INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME) VALUES ('Nintendo', 2001, 'Game Boy Advance')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME) VALUES ('Sony', 1994, 'PlayStation')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME) VALUES ('Atari', 1977, 'Atari 2600')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME) VALUES ('Sega', 1989, 'Master System')


INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Metal Slug Advance', 1, 'Run and Gun', 'https://media.retroachievements.org/Images/069381.png', '', 'CRC32-09980880')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Mario and Luigi: Superstar Saga', 1, 'Turn-based RPG', 'https://media.retroachievements.org/Images/014492.png', '', 'CRC32-E718D850')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Legend of Zelda, The: A Link to the Past and Four Swords', 1, 'Action-Adventure', 'https://media.retroachievements.org/Images/022503.png', '', 'CRC32-fb1fe24a')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Pokemon Emerald Version', 1, 'Turn-based RPG', 'https://media.retroachievements.org/Images/014406.png', '', 'CRC32-1F1C08FB')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Metroid Fusion', 1, 'Metroidvania', 'https://media.retroachievements.org/Images/000649.png', '', 'CRC32-6C75479C')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Crash Bandicoot', 2, '3D Platforming', 'https://media.retroachievements.org/Images/027330.png', '', 'RA-35386fd0891e594c9b6d8a4a5baa0027')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Tekken', 2, '3D Fighting', 'https://media.retroachievements.org/Images/046924.png', '', 'RA-138a1ee7a95f5733fc6039723a170381')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Resident Evil 3: Nemesis', 2, 'Survival Horror', 'https://media.retroachievements.org/Images/047497.png', '', 'RA-4f8ab98c545757c65978d595f42826e4')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Silent Hill', 2, 'Survival Horror', 'https://media.retroachievements.org/Images/045302.png', '', 'RA-469d5cf1428d3f6f2234aa5be058f3ec')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Tomb Raider', 2, 'Action-Adventure', 'https://media.retroachievements.org/Images/026539.png', '', 'CRC32-370728af')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Mega Man', 3, 'Platforming', 'https://media.retroachievements.org/Images/039297.png', '', 'CRC32-9158B4ED')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Pac-Man 4K', 3, 'Arcade', 'https://media.retroachievements.org/Images/019939.png', '', 'CRC32-DDC9A881')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Tetris26', 3, 'Puzzle', 'https://media.retroachievements.org/Images/020116.png', '', 'CRC32-EBE8D2A9')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Garfield', 3, 'Arcade', 'https://media.retroachievements.org/Images/047779.png', '', 'CRC32-F20CADCF')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Popeye', 3, 'Maze Chase', 'https://media.retroachievements.org/Images/058473.png', '', 'RA-c7f13ef38f61ee2367ada94fdcc6d206')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Sonic the Hedgehog', 4, 'Platforming', 'https://media.retroachievements.org/Images/010429.png', '', 'CRC32-B519E833')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Michael Jackson''s Moonwalker', 4, 'Action', 'https://media.retroachievements.org/Images/056029.png', '', 'CRC32-56CC906B')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Ayrton Senna''s Super Monaco GP II', 4, 'Race', 'https://media.retroachievements.org/Images/010618.png', '', 'CRC32-E890331D')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Aladdin', 4, '2D Platforming', 'https://media.retroachievements.org/Images/056303.png', '', 'RA-e3f60072028eb6f02c2b0558804aed83')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Golden Axe', 4, 'Beat ''em Up', 'https://media.retroachievements.org/Images/017272.png', '', 'CRC32-C08132FB')

INSERT INTO USR (NAME, EMAIL, PASSWORD) VALUES ('jorge', 'jorge@email.com', '202cb962ac59075b964b07152d234b70')
INSERT INTO USR (NAME, EMAIL, PASSWORD, ISADMIN) VALUES ('paula', 'paula@email.com', '202cb962ac59075b964b07152d234b70', 1)
