package br.ifpe.triunfopixel.bean;

import br.ifpe.triunfopixel.model.Game;
import br.ifpe.triunfopixel.service.ConsoleService;
import br.ifpe.triunfopixel.service.GameService;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
@Getter
@Setter
public class GameBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private List<Game> listGames = new ArrayList<>();
    private Game selectedGame = new Game();
    private StreamedContent file;
    
    @Getter(AccessLevel.NONE)@Setter(AccessLevel.NONE)
    private final GameService gameService = new GameService();
    
    @PostConstruct
    public void init() {
        listGames = gameService.listAll();
    }
    
    public void prepareDownload() {
        try {
            URL url = new URL("https://server.emulatorgames.net/roms/sega-master-system/Aladdin%20(Europe).zip");
            InputStream inputStream = url.openStream();
            Path tempFile = Files.createTempFile("download", ".zip");
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
            file = DefaultStreamedContent.builder()
                .name( this.selectedGame.getName() + ".zip")
                .contentType("application/zip")
                .stream(() -> {
                    try {
                        return Files.newInputStream(tempFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .build();
            
        } catch (Exception e) {
        }
    }   
    
}
