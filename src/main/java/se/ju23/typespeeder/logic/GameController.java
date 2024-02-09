package se.ju23.typespeeder.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import se.ju23.typespeeder.data.PlayerRepository;
import se.ju23.typespeeder.data.ResultRepository;
import se.ju23.typespeeder.io.IO;

@Controller
public class GameController{

    private Game game;
    private IO io;
    @Autowired
    private PlayerRepository playerRepo;
    @Autowired
    private ResultRepository resultRepo;

    public GameController(Game game, IO io){
        this.game = game;
        this.io = io;
    }
}
