DROP TABLE GAME
DROP TABLE USR
DROP TABLE CONSOLE

CREATE TABLE GAME (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, GENRE VARCHAR(255), HASH VARCHAR(255), NAME VARCHAR(255), URLIMAGEM VARCHAR(255), URLROOM VARCHAR(255), CONSOLE_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE USR (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, EMAIL VARCHAR(255) UNIQUE, ISADMIN SMALLINT DEFAULT 0, NAME VARCHAR(255), PASSWORD VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE CONSOLE (ID BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL, ANOLANCAMENTO BIGINT, FABRICANTE VARCHAR(255), NOME VARCHAR(255), URLIMAGEM VARCHAR(255), PRIMARY KEY (ID))
ALTER TABLE GAME ADD CONSTRAINT FK_GAME_CONSOLE_ID FOREIGN KEY (CONSOLE_ID) REFERENCES CONSOLE (ID)

INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME, URLIMAGEM) VALUES ('Nintendo', 2001, 'Game Boy Advance','https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Nintendo-Game-Boy-Advance-Purple-FL.jpg/640px-Nintendo-Game-Boy-Advance-Purple-FL.jpg')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME, URLIMAGEM) VALUES ('Nintendo', 1990, 'SNES', 'https://cdn.awsli.com.br/800x800/2487/2487672/produto/176672259/50ccee7b64.jpg')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME, URLIMAGEM) VALUES ('Atari', 1977, 'Atari 2600', 'https://ae01.alicdn.com/kf/Sec474edbd63c4fe29753f1403e60aed6Q/2022-novo-10306-atari-2600-console-sistema-de-computador-v-deo-cones-modelo-kit-constru-o.jpg')
INSERT INTO CONSOLE (FABRICANTE, ANOLANCAMENTO, NOME, URLIMAGEM) VALUES ('Sega', 1989, 'Master System', 'https://d3ugyf2ht6aenh.cloudfront.net/stores/002/082/206/products/img_26501-e9c6f3da1a921b82e016487472471083-640-0.jpg')


INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Metal Slug Advance', 1, 'Run and Gun', 'https://media.retroachievements.org/Images/069381.png', 'https://serve.emulatorgames.net/roms/gameboy-advance/Metal%20Slug%20Advance%20(U).zip', 'CRC32-09980880')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Mario and Luigi: Superstar Saga', 1, 'Turn-based RPG', 'https://media.retroachievements.org/Images/014492.png', 'https://serve.emulatorgames.net/roms/gameboy-advance/Mario%20And%20Luigi%20Superstar%20Saga%20(E)(Menace).zip', 'CRC32-E718D850')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Legend of Zelda, The: A Link to the Past and Four Swords', 1, 'Action-Adventure', 'https://media.retroachievements.org/Images/022503.png', 'https://serve.emulatorgames.net/roms/gameboy-advance/Legend%20of%20Zelda,%20The%20-%20A%20Link%20To%20The%20Past%20Four%20Swords%20(U)%20[!].zip', 'CRC32-fb1fe24a')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Pokemon Emerald Version', 1, 'Turn-based RPG', 'https://media.retroachievements.org/Images/014406.png', 'https://static.emulatorgames.net/roms/gameboy-advance/Pokemon%20-%20Emerald%20Version%20(U).zip', 'CRC32-1F1C08FB')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Metroid Fusion', 1, 'Metroidvania', 'https://media.retroachievements.org/Images/000649.png', 'https://static.emulatorgames.net/roms/gameboy-advance/Pokemon%20-%20Emerald%20Version%20(U).zip', 'CRC32-6C75479C')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Mortal Kombat', 2, 'Fighting', 'https://media.retroachievements.org/Images/002317.png', 'https://static.emulatorgames.net/roms/super-nintendo/Mortal%20Kombat%20(E).zip', 'CRC32-DEF42945')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Top Gear', 2, 'Arcade Racing', 'https://media.retroachievements.org/Images/069075.png', 'https://static.emulatorgames.net/roms/super-nintendo/Top%20Gear%20(USA).zip', 'CRC32-D34C49B7')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Super Bomberman 4', 2, 'Action Puzzle', 'https://media.retroachievements.org/Images/038288.png', 'https://static.emulatorgames.net/roms/super-nintendo/Super%20Bomberman%204%20(Japan).zip', 'CRC32-3BBAEB19')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Kirby Super Star', 2, '2D Platforming', 'https://media.retroachievements.org/Images/003681.png', 'https://serve.emulatorgames.net/roms/super-nintendo/Kirby%20Super%20Star%20(U)%20[!].zip', 'CRC32-89D0F7DC')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Chrono Trigger', 2, 'Role-Playing Game', 'https://media.retroachievements.org/Images/000222.png', 'https://serve.emulatorgames.net/roms/super-nintendo/Chrono%20Trigger%20(U)%20[!].zip', 'CRC32-2D206BF7')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Frogger', 3, 'Arcade', 'https://media.retroachievements.org/Images/051761.png', 'https://static.emulatorgames.net/roms/atari-2600/Frogger%20(1982)%20(Parker%20Bros).zip', 'CRC32-9158B4ED')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Pac-Man', 3, 'Arcade', 'https://media.retroachievements.org/Images/019130.png', 'https://static.emulatorgames.net/roms/atari-2600/Pac-Man%20(1981)%20(Atari)%20[h1].zip', 'CRC32-DDC9A881')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Pitfall!', 3, 'Platforming', 'https://media.retroachievements.org/Images/015256.png', 'https://server.emulatorgames.net/roms/atari-2600/Pitfall!%20(1982)%20(Activision)%20[!].zip', 'CRC32-42AD47BF')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Seaquest', 3, 'Shooter', 'https://media.retroachievements.org/Images/016791.png', 'https://serve.emulatorgames.net/roms/atari-2600/Seaquest%20(1983)%20(Activision)%20[!].zip', 'CRC32-8658E8D9')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Space Invaders', 3, 'Shoot ''em Up', 'https://media.retroachievements.org/Images/016791.png', 'https://serve.emulatorgames.net/roms/atari-2600/Space%20Invaders%20(1978)%20(Atari)%20(PAL)%20[!].zip', 'CRC32-A6E867B3')

INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Sonic the Hedgehog', 4, 'Platforming', 'https://media.retroachievements.org/Images/010429.png', 'https://static.emulatorgames.net/roms/sega-master-system/Sonic%20The%20Hedgehog.7z', 'CRC32-B519E833')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Michael Jackson''s Moonwalker', 4, 'Action', 'https://media.retroachievements.org/Images/056029.png', 'https://static.emulatorgames.net/roms/sega-master-system/Sonic%20The%20Hedgehog.7z', 'CRC32-56CC906B')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Ayrton Senna''s Super Monaco GP II', 4, 'Race', 'https://media.retroachievements.org/Images/010618.png', 'https://server.emulatorgames.net/roms/sega-master-system/Ayrton%20Senna''s%20Super%20Monaco%20GP%20II.7z', 'CRC32-E890331D')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Alien 3', 4, 'Action', 'https://media.retroachievements.org/Images/015903.png', 'https://serve.emulatorgames.net/roms/sega-master-system/Alien%203.7z', 'CRC32-B618B144')
INSERT INTO GAME (NAME, CONSOLE_ID, GENRE, URLIMAGEM, URLROOM, HASH) VALUES ('Golden Axe', 4, 'Beat ''em Up', 'https://media.retroachievements.org/Images/017272.png', 'https://serve.emulatorgames.net/roms/sega-master-system/Golden%20Axe%20(USA,%20Europe).zip', 'CRC32-C08132FB')

INSERT INTO USR (NAME, EMAIL, PASSWORD) VALUES ('jorge', 'jorge@email.com', '202cb962ac59075b964b07152d234b70')
INSERT INTO USR (NAME, EMAIL, PASSWORD, ISADMIN) VALUES ('paula', 'paula@email.com', '202cb962ac59075b964b07152d234b70', 1)
