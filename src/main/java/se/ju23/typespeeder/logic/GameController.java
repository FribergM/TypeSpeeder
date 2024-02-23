package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.account.AccountManager;
import se.ju23.typespeeder.account.LoginStatus;
import se.ju23.typespeeder.data.entities.Player;
import se.ju23.typespeeder.data.repositories.PlayerRepository;
import se.ju23.typespeeder.data.entities.Result;
import se.ju23.typespeeder.data.entities.Text;
import se.ju23.typespeeder.data.repositories.TextRepository;
import se.ju23.typespeeder.services.LeaderboardService;
import se.ju23.typespeeder.services.Patch;
import se.ju23.typespeeder.services.Util;
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
        newsDisplay();

        mainMenuSelection();
    }
    private void newsDisplay(){
        Patch currentPatch = new Patch();
        io.print(currentPatch.getPatchVersion());
        io.print("Release Date:");
        io.println(currentPatch.getReleaseDateTime());
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
                case "3" -> leaderboardSelection();
                case "4" -> accountSettingSelection();
                case "0" -> io.println(menu.getLanguage().logoutPrompt());
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
            menu.displayAccountSettings();

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
            menu.displayLeaderboardOptions();

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
        provideInstruction();
        countdown();
        String lettersToType = challenge.lettersToType(io);
        io.println();
        //Comment this out when you don't want to cheat.
        //io.print(lettersToType+"\n");

        Result sessionResult = challenge.startChallenge(io, lettersToType);
        if(sessionResult == null){
            io.println(menu.getLanguage().cantLeaveEmptyPrompt());
            return;
        }
        int expChange = challenge.calculateExperience(sessionResult,difficulty);
        finishSession(sessionResult,expChange);

    }
    private void provideInstruction(){
        io.println(menu.getLanguage().gameInstruction());
        io.input(menu.getLanguage().enterKeyPrompt());
    }
    private void countdown(){
        try{
            for(int i=5;i>0;i--){
                io.print(menu.getLanguage().countdownPrompt()+i);
                Thread.sleep(1000);
            }

        }catch(InterruptedException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    private void printResults(Result sessionResult){
        io.print(menu.getLanguage().resultPrompt());
        int length = sessionResult.toString().length();

        io.print(Util.getFrameByLength(length-5));
        io.print(sessionResult.toString());
        io.println(Util.getFrameByLength(length-5));
    }

    private void printExpChange(int expChange){
        boolean levelUp;
        if(expChange >= 0){
            levelUp = currentPlayer.gainExp(expChange);
            io.print(menu.getLanguage().expGainPrompt()+ expChange);
            if(levelUp){
                io.print(menu.getLanguage().levelUpPrompt()+currentPlayer.getLevel());
            }
        }else{
            currentPlayer.loseExp(expChange);
            io.print(menu.getLanguage().expLossPrompt()+ expChange);
        }

        if(currentPlayer.getLevel() != 5){
            io.println("Exp: " + currentPlayer.getExp() + " / " + currentPlayer.getExpReq());
        }

    }

    private void finishSession(Result sessionResult,int expChange){
        printResults(sessionResult);
        printExpChange(expChange);

        sessionResult.setPlayer(currentPlayer);
        currentPlayer.addResult(sessionResult);
        playerRepo.save(currentPlayer);
    }
}
