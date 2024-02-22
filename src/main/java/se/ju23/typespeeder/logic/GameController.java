package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.account.AccountManager;
import se.ju23.typespeeder.account.LoginStatus;
import se.ju23.typespeeder.data.entities.Player;
import se.ju23.typespeeder.data.repositories.PlayerRepository;
import se.ju23.typespeeder.data.entities.Result;
import se.ju23.typespeeder.data.entities.Text;
import se.ju23.typespeeder.data.repositories.TextRepository;
import se.ju23.typespeeder.data.services.LeaderboardService;
import se.ju23.typespeeder.ui.IO;
import se.ju23.typespeeder.ui.LeaderboardMenu;
import se.ju23.typespeeder.ui.MenuService;

import java.util.List;

public class GameController{

    private IO io;
    private MenuService menu;
    private PlayerRepository playerRepo;
    private TextRepository textRepo;
    private AccountManager accountManager;
    private LeaderboardService lbService;
    private Player currentPlayer;

    public GameController(IO io,
                          MenuService menu,
                          PlayerRepository playerRepo,
                          TextRepository textRepo,
                          AccountManager accountManager,
                          LeaderboardService lbService){
        this.io = io;
        this.menu = menu;
        this.playerRepo = playerRepo;
        this.textRepo = textRepo;
        this.accountManager = accountManager;
        this.lbService = lbService;
    }

    public void run(){
        mainMenuSelection();
    }

    private void mainMenuSelection(){
        String playerChoice;

        do{
            menu.displayMenu();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> {
                    LoginStatus loginStatus = accountManager.login();
                    if(loginStatus.getLoginStatus()){
                        currentPlayer = loginStatus.getCurrentPlayer();
                        gameMenuSelection();
                    }
                }
                case "2" -> {
                    LoginStatus loginStatus = accountManager.createAccount();
                    if(loginStatus.getLoginStatus()){
                        currentPlayer = loginStatus.getCurrentPlayer();
                        gameMenuSelection();
                    }
                }
                case "3" -> menu.changeLanguage();
                case "0" -> io.exit();
                default -> io.println(menu.getLanguage().menuErrorPrompt());
            }

        }while(!playerChoice.equals("0"));
    }

    private void gameMenuSelection(){
        String playerChoice;

        do{
            menu.displayGameMenu();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> gameModeSelection(true);
                case "2" -> gameModeSelection(false);
                //TODO Fix this & Add lang prompts
                case "3" -> leaderboardSelection();
//                case "4" -> accountSettingSelection();
                case "0" -> io.println("Logging out...");
                default -> io.println(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }

    private void gameModeSelection(Boolean language){
        String playerChoice;

        do{
            menu.displayGameModes();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> {
                    difficultySelection(language,1);
                    return;
                }
                case "2" -> {
                    difficultySelection(language,2);
                    return;
                }
                case "3" -> {
                    difficultySelection(language,3);
                    return;
                }
                case "4" -> {
                    difficultySelection(language,4);
                    return;
                }
                case "0" -> {}
                default -> io.println(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }
    private void difficultySelection(Boolean language, int gameMode){
        String playerChoice;

        do{
            menu.displayDifficulties();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> {
                    play(language,gameMode,1);
                    return;
                }
                case "2" -> {
                    play(language,gameMode,2);
                    return;
                }
                case "3" -> {
                    play(language,gameMode,3);
                    return;
                }
                case "0" -> {}
                default -> io.println(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }

    public void accountSettingSelection(){
        String playerChoice;
        do{
            //TODO Lang prompt
//            menu.displayAccountSettings();

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> accountManager.changeUsername(currentPlayer);
                case "2" -> accountManager.changePassword(currentPlayer);
                case "3" -> accountManager.changeAlias(currentPlayer);
                case "0" -> {}
                default -> io.println(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }

    public void leaderboardSelection(){
        LeaderboardMenu leaderboardMenu = new LeaderboardMenu(currentPlayer,io,menu,lbService);
        String playerChoice;
        do{
            //TODO Lang prompt
//            menu.displayLeaderboardOptions();
            io.println("1. GlobalLB");
            io.println("2. PersonalLB");
            io.println("3. RecentGames");

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> leaderboardMenu.global();
                case "2" -> leaderboardMenu.personal();
                case "3" -> leaderboardMenu.printRecentResults();
                case "0" -> {}
                default -> io.println(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }

    private void play(Boolean yesNo, int gameMode, int difficulty){
        List<Text> texts = textRepo.findAll();
        Challenge challenge = new Challenge(yesNo,gameMode,difficulty,texts);
        //TODO remove this comment
//        countdown();
        String lettersToType = challenge.lettersToType(io);
        //Comment this out when you don't want to cheat.
        System.out.println("\n"+lettersToType);
        Result sessionResult = challenge.startChallenge(io, lettersToType);
        if(sessionResult == null){
            //TODO PROMPTS cant leave empty.
            io.println("Can't leave empty.");
            return;
        }
        int expChange = challenge.calculateExperience(sessionResult);
        printResults(sessionResult);
        printExpChange(expChange);
        finishSession(sessionResult);

    }
    private void countdown(){
        try{
            for(int i=5;i>0;i--){
                //TODO Countdown lang prompts
                io.print("Challenge starting in: "+i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    private void printResults(Result sessionResult){
        //TODO Result lang prompt
        io.print("RESULTAT:\n---------");
        io.println(sessionResult.toString());
    }

    private void printExpChange(int expChange){
        boolean levelUp;
        //TODO lang prompts
        if(expChange >= 0){
            levelUp = currentPlayer.gainExp(expChange);
            io.print("Exp Gain: "+ expChange);
            if(levelUp){
                io.print("You leveled up to : "+currentPlayer.getLevel());
            }
        }else{
            currentPlayer.loseExp(expChange);
            io.print("Exp Loss: "+ expChange);
        }

        if(currentPlayer.getLevel() != 5){
            io.println("Exp: " + currentPlayer.getExp() + " / " + currentPlayer.getExpReq());
        }

    }

    private void finishSession(Result sessionResult){
        sessionResult.setPlayer(currentPlayer);
        currentPlayer.addResult(sessionResult);
        playerRepo.save(currentPlayer);
    }
}
