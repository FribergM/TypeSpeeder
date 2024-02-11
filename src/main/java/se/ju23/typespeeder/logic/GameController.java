package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.data.Player;
import se.ju23.typespeeder.data.PlayerRepository;
import se.ju23.typespeeder.data.Result;
import se.ju23.typespeeder.io.IO;
import se.ju23.typespeeder.io.MenuService;

public class GameController{

    private Game game;
    private IO io;
    private MenuService menu;
    private PlayerRepository playerRepo;

    public GameController(Game game, IO io, MenuService menu,
                          PlayerRepository playerRepo){
        this.game = game;
        this.io = io;
        this.menu = menu;
        this.playerRepo = playerRepo;
    }
    public void run(){
        menu.displayMenu();
        Player p = new Player("Bob","Bob123","Bobbyboi");
//                new Player("Bob","Bob123","Bobbyboi");
//                playerRepo.findById(1L).get();
        p.addResult(new Result(70,80.2,5));
        System.out.println(p);

        playerRepo.save(p);
    }
}
