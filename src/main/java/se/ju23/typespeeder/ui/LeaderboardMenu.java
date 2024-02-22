package se.ju23.typespeeder.ui;

import se.ju23.typespeeder.data.entities.Player;
import se.ju23.typespeeder.data.services.LeaderboardService;


public class LeaderboardMenu{
    private Player currentPlayer;
    private IO io;
    private LeaderboardService lbService;
    private MenuService menu;

    public LeaderboardMenu(Player currentPlayer, IO io, MenuService menu,LeaderboardService lbService){
        this.currentPlayer = currentPlayer;
        this.io = io;
        this.lbService = lbService;
        this.menu = menu;
    }
    public void global(){
        String playerChoice;
        do{
            //TODO Lang prompt
//            menu.displayGlobalLBOptions();
            io.println("1. GlobalWpm");
            io.println("2. GlobalAcc");
            io.println("3. GlobalStreak");
            io.println("4. GlobalScore");

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> printGlobalWpm();
                case "2" -> printGlobalAccuracy();
                case "3" -> printGlobalStreak();
                case "4" -> printGlobalScore();
                case "0" -> {}
                default -> io.println(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }
    public void personal(){
        String playerChoice;
        do{
            //TODO Lang prompt
//            menu.displayPersonalLBOptions();
            io.println("1. PersonalWpm");
            io.println("2. PersonalAcc");
            io.println("3. PersonalStreak");
            io.println("4. PersonalScore");

            playerChoice = io.input();

            switch(playerChoice){
                case "1" -> printPersonalWpm();
                case "2" -> printPersonalAccuracy();
                case "3" -> printPersonalStreak();
                case "4" -> printPersonalScore();
                case "0" -> {}
                default -> io.println(menu.getLanguage().menuErrorPrompt());
            }
        }while(!playerChoice.equals("0"));
    }

    public void printRecentResults(){
//        io.print(menu.getLanguage().recentResultsPrompt());
        String print = currentPlayer.lastTenResults();
        if(print.isBlank()){
            //TODO No results prompt
            return;
        }
        io.println(print);
        //TODO Enter to return lang prompts
        io.input("[ENTER]");
    }

    private void printPersonalWpm(){
//        io.print(menu.getLanguage().personalWpmPrompt());
        String print = currentPlayer.resultsByWpm();
        if(print.isBlank()){
            //TODO No results prompt
            return;
        }
        io.println(print);
        io.input("[ENTER]");
    }
    private void printPersonalAccuracy(){
//        io.print(menu.getLanguage().personalAccPrompt());
        String print = currentPlayer.resultsByAccuracy();
        if(print.isBlank()){
            //TODO No results prompt
            return;
        }
        io.println(print);
        io.input("[ENTER]");
    }
    private void printPersonalStreak(){
//        io.print(menu.getLanguage().personalStreakPrompt());
        String print = currentPlayer.resultsByStreak();
        if(print.isBlank()){
            //TODO No results prompt
            return;
        }
        io.println(print);
        io.input("[ENTER]");
    }
    private void printPersonalScore(){
//        io.print(menu.getLanguage().personalScorePrompt());
        String print = currentPlayer.resultsByScore();
        if(print.isBlank()){
            //TODO No results prompt
            return;
        }
        io.println(print);
        io.input("[ENTER]");
    }

    private void printGlobalWpm(){
//        io.print(menu.getLanguage().globalWpmPrompt());
        io.println(lbService.wpm());
        io.input("[ENTER]");
    }
    private void printGlobalAccuracy(){
//        io.print(menu.getLanguage().globalAccPrompt());
        io.println(lbService.accuracy());
        io.input("[ENTER]");
    }
    private void printGlobalStreak(){
//        io.print(menu.getLanguage().globalStreakPrompt());
        io.println(lbService.streak());
        io.input("[ENTER]");
    }
    private void printGlobalScore(){
//        io.print(menu.getLanguage().globalScorePrompt());
        io.println(lbService.score());
        io.input("[ENTER]");
    }

}
