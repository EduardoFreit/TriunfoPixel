package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.dao.BaseJPA;
import br.ifpe.triunfopixel.model.Console;
import br.ifpe.triunfopixel.model.Game;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameService extends BaseJPA<Game> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public GameService() {
        super(Game.class);
    }
    
    
    public void insertGames() {
        List<Game> listGames = new ArrayList<>();
        
        Console gameBoyAdvance = new Console(null, "Game Boy Advance", "2001", "Nintendo");
        Console playstation = new Console(null, "PlayStation", "1994", "Sony");
        Console atari2600 = new Console(null, "Atari 2600", "1977", "Atari");
        Console masterSystem = new Console(null, "Master System", "1989", "Sega");
        
        
        Game gm1 = new Game();
        Game gm2 = new Game();
        Game gm3 = new Game();
        Game gm4 = new Game();
        Game gm5 = new Game();
        Game gm6 = new Game();
        Game gm7 = new Game();
        Game gm8 = new Game();
        Game gm9 = new Game();
        Game gm10 = new Game();
        Game gm11 = new Game();
        Game gm12 = new Game();
        Game gm13 = new Game();
        Game gm14 = new Game();
        Game gm15 = new Game();
        Game gm16 = new Game();
        Game gm17 = new Game();
        Game gm18 = new Game();
        Game gm19 = new Game();
        Game gm20 = new Game();
        
        gm1.setName("Metal Slug Advance");
        gm1.setConsole(gameBoyAdvance);
        gm1.setGenre("Run & Gun");
        gm1.setUrlImagem("https://media.retroachievements.org/Images/069381.png");
        
        gm2.setName("Mario & Luigi: Superstar Saga");
        gm2.setConsole(gameBoyAdvance);
        gm2.setGenre("Turn-based RPG");
        gm2.setUrlImagem("https://media.retroachievements.org/Images/014492.png");
        
        gm3.setName("Legend of Zelda, The: A Link to the Past & Four Swords");
        gm3.setConsole(gameBoyAdvance);
        gm3.setGenre("Action-Adventure");
        gm3.setUrlImagem("https://media.retroachievements.org/Images/022503.png");
        
        gm4.setName("Pokemon Emerald Version");
        gm4.setConsole(gameBoyAdvance);
        gm4.setGenre("Turn-based RPG");
        gm4.setUrlImagem("https://media.retroachievements.org/Images/014406.png");
        
        gm5.setName("Metroid Fusion");
        gm5.setConsole(gameBoyAdvance);
        gm5.setGenre("Metroidvania");
        gm5.setUrlImagem("https://media.retroachievements.org/Images/000649.png");
        
        gm6.setName("Crash Bandicoot");
        gm6.setConsole(playstation);
        gm6.setGenre("3D Platforming");
        gm6.setUrlImagem("https://media.retroachievements.org/Images/027330.png");
        
        gm7.setName("Metal Gear Solid");
        gm7.setConsole(playstation);
        gm7.setGenre("Action");
        gm7.setUrlImagem("https://media.retroachievements.org/Images/046645.png");
        
        gm8.setName("Resident Evil 3: Nemesis");
        gm8.setConsole(playstation);
        gm8.setGenre("Survival Horror");
        gm8.setUrlImagem("https://media.retroachievements.org/Images/047497.png");
        
        gm9.setName("Silent Hill");
        gm9.setConsole(playstation);
        gm9.setGenre("Survival Horror");
        gm9.setUrlImagem("https://media.retroachievements.org/Images/045302.png");
        
        gm10.setName("Tomb Raider");
        gm10.setConsole(playstation);
        gm10.setGenre("Action-Adventure");
        gm10.setUrlImagem("https://media.retroachievements.org/Images/026539.png");
        
            gm11.setName("Mega Man");
        gm11.setConsole(atari2600);
        gm11.setGenre("Platforming");
        gm11.setUrlImagem("https://media.retroachievements.org/Images/039297.png");
        
        gm12.setName("Pac-Man 4K");
        gm12.setConsole(atari2600);
        gm12.setGenre("Arcade");
        gm12.setUrlImagem("https://media.retroachievements.org/Images/019939.png");
        
        gm13.setName("Tetris26");
        gm13.setConsole(atari2600);
        gm13.setGenre("Puzzle");
        gm13.setUrlImagem("https://media.retroachievements.org/Images/020116.png");
        
        gm14.setName("Garfield");
        gm14.setConsole(atari2600);
        gm14.setGenre("Arcade");
        gm14.setUrlImagem("https://media.retroachievements.org/Images/047779.png");
        
        gm15.setName("Popeye");
        gm15.setConsole(atari2600);
        gm15.setGenre("Maze Chase");
        gm15.setUrlImagem("https://media.retroachievements.org/Images/058473.png");
        
        gm16.setName("Sonic the Hedgehog");
        gm16.setConsole(masterSystem);
        gm16.setGenre("Platforming");
        gm16.setUrlImagem("https://media.retroachievements.org/Images/010429.png");
        
        gm17.setName("Michael Jackson's Moonwalker");
        gm17.setConsole(masterSystem);
        gm17.setGenre("Action");
        gm17.setUrlImagem("https://media.retroachievements.org/Images/056029.png");
        
        gm18.setName("Ayrton Senna's Super Monaco GP II");
        gm18.setConsole(masterSystem);
        gm18.setGenre("Race");
        gm18.setUrlImagem("https://media.retroachievements.org/Images/010618.png");
        
        gm19.setName("Aladdin");
        gm19.setConsole(masterSystem);
        gm19.setGenre("2D Platforming");
        gm19.setUrlImagem("https://media.retroachievements.org/Images/056303.png");
        
        gm20.setName("Golden Axe");
        gm20.setConsole(masterSystem);
        gm20.setGenre("Beat 'em Up");
        gm20.setUrlImagem("https://media.retroachievements.org/Images/017272.png");
        
        listGames.add(gm1);
        listGames.add(gm2);
        listGames.add(gm3);
        listGames.add(gm4);
        listGames.add(gm5);
        listGames.add(gm6);
        listGames.add(gm7);
        listGames.add(gm8);
        listGames.add(gm9);
        listGames.add(gm10);
        listGames.add(gm11);
        listGames.add(gm12);
        listGames.add(gm13);
        listGames.add(gm14);
        listGames.add(gm15);
        listGames.add(gm16);
        listGames.add(gm17);
        listGames.add(gm18);
        listGames.add(gm19);
        listGames.add(gm20);
        
        if(this.listAll().isEmpty()) {
            this.insertAll(listGames);
        }
        
    }
    
}
