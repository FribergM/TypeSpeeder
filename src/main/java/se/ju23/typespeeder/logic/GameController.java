package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.data.Player;
import se.ju23.typespeeder.data.PlayerRepository;
import se.ju23.typespeeder.io.IO;
import se.ju23.typespeeder.io.MenuService;

public class GameController{

    private Game game;
    private IO io;
    private MenuService menu;
    private PlayerRepository playerRepo;
    private Player currentPlayer;

    public GameController(Game game, IO io, MenuService menu,
                          PlayerRepository playerRepo){
        this.game = game;
        this.io = io;
        this.menu = menu;
        this.playerRepo = playerRepo;
    }

    public void run(){

        String playerChoice;

        do{
            menu.displayMenu();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> login();
                case "2" -> createAccount();
                case "3" -> changeLanguage();
                default -> io.output("Invalid menu option!");
            }

        }while(!playerChoice.equals("0"));

    }

    private void login(){

        io.output("Please enter username:");
        String username = io.input();
        io.output("Please enter password:");
        String password = io.input();

        currentPlayer = playerRepo.findByUsernameAndPassword(username,password);

        if(currentPlayer == null){
            io.output("Incorrect username/password!");
        }else{
            gameMenuSelection();
        }

    }

    private void createAccount(){

    }

    private void changeLanguage(){

    }

    private void gameMenuSelection(){

    }
}
