/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ifpe.triunfopixel.service;

import br.ifpe.triunfopixel.dao.BaseJPA;
import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.dao.DAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author lepf9
 */
public class GameService extends BaseJPA<Game> implements Serializable {

    public GameService() {
        super(Game.class);
    }
    
    public void insertGames() {
        List<Game> listGames = new ArrayList<>();
        
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
        gm1.setConsole("Game Boy Advance");
        gm1.setGenre("Run & Gun");
        gm1.setUrlImagem("https://media.retroachievements.org/Images/069381.png");
        
        gm2.setName("Mario & Luigi: Superstar Saga");
        gm2.setConsole("Game Boy Advance");
        gm2.setGenre("Turn-based RPG");
        gm2.setUrlImagem("https://media.retroachievements.org/Images/014492.png");
        
        gm3.setName("Legend of Zelda, The: A Link to the Past & Four Swords");
        gm3.setConsole("Game Boy Advance");
        gm3.setGenre("Action-Adventure");
        gm3.setUrlImagem("https://media.retroachievements.org/Images/022503.png");
        
        gm4.setName("Pokemon Emerald Version");
        gm4.setConsole("Game Boy Advance");
        gm4.setGenre("Turn-based RPG");
        gm4.setUrlImagem("https://media.retroachievements.org/Images/014406.png");
        
        gm5.setName("Metroid Fusion");
        gm5.setConsole("Game Boy Advance");
        gm5.setGenre("Metroidvania");
        gm5.setUrlImagem("https://media.retroachievements.org/Images/000649.png");
        
        gm6.setName("Crash Bandicoot");
        gm6.setConsole("PlayStation");
        gm6.setGenre("3D Platforming");
        gm6.setUrlImagem("https://media.retroachievements.org/Images/027330.png");
        
        gm7.setName("Metal Gear Solid");
        gm7.setConsole("PlayStation");
        gm7.setGenre("Action");
        gm7.setUrlImagem("https://media.retroachievements.org/Images/046645.png");
        
        gm8.setName("Resident Evil 3: Nemesis");
        gm8.setConsole("PlayStation");
        gm8.setGenre("Survival Horror");
        gm8.setUrlImagem("https://media.retroachievements.org/Images/047497.png");
        
        gm9.setName("Silent Hill");
        gm9.setConsole("PlayStation");
        gm9.setGenre("Survival Horror");
        gm9.setUrlImagem("https://media.retroachievements.org/Images/045302.png");
        
        gm10.setName("Tomb Raider");
        gm10.setConsole("PlayStation");
        gm10.setGenre("Action-Adventure");
        gm10.setUrlImagem("https://media.retroachievements.org/Images/026539.png");
        
            gm11.setName("Mega Man");
        gm11.setConsole("Atari 2600");
        gm11.setGenre("Platforming");
        gm11.setUrlImagem("https://media.retroachievements.org/Images/039297.png");
        
        gm12.setName("Pac-Man 4K");
        gm12.setConsole("Atari 2600");
        gm12.setGenre("Arcade");
        gm12.setUrlImagem("https://media.retroachievements.org/Images/019939.png");
        
        gm13.setName("Tetris26");
        gm13.setConsole("Atari 2600");
        gm13.setGenre("Puzzle");
        gm13.setUrlImagem("https://media.retroachievements.org/Images/020116.png");
        
        gm14.setName("Garfield");
        gm14.setConsole("Atari 2600");
        gm14.setGenre("Arcade");
        gm14.setUrlImagem("https://media.retroachievements.org/Images/047779.png");
        
        gm15.setName("Popeye");
        gm15.setConsole("Atari 2600");
        gm15.setGenre("Maze Chase");
        gm15.setUrlImagem("https://media.retroachievements.org/Images/058473.png");
        
        gm16.setName("Sonic the Hedgehog");
        gm16.setConsole("Master System");
        gm16.setGenre("Platforming");
        gm16.setUrlImagem("https://media.retroachievements.org/Images/010429.png");
        
        gm17.setName("Michael Jackson's Moonwalker");
        gm17.setConsole("Master System");
        gm17.setGenre("Action");
        gm17.setUrlImagem("https://media.retroachievements.org/Images/056029.png");
        
        gm18.setName("Ayrton Senna's Super Monaco GP II");
        gm18.setConsole("Master System");
        gm18.setGenre("Race");
        gm18.setUrlImagem("https://media.retroachievements.org/Images/010618.png");
        
        gm19.setName("Aladdin");
        gm19.setConsole("Master System");
        gm19.setGenre("2D Platforming");
        gm19.setUrlImagem("https://media.retroachievements.org/Images/056303.png");
        
        gm20.setName("Golden Axe");
        gm20.setConsole("Master System");
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
