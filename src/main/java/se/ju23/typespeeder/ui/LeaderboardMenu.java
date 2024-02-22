package se.ju23.typespeeder.ui;

import se.ju23.typespeeder.data.entities.Player;
import se.ju23.typespeeder.services.LeaderboardService;


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
            menu.displayGlobalLBOptions();

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
            menu.displayPersonalLBOptions();

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
        io.print(menu.getLanguage().recentResultsPrompt());
        String print = currentPlayer.lastTenResults();
        if(print.isBlank()){
            io.println(menu.getLanguage().noResultsPrompt());
            return;
        }
        io.println(print);
        io.input(menu.getLanguage().enterKeyPrompt());
    }

    private void printPersonalWpm(){
        io.print(menu.getLanguage().personalWpmPrompt());
        String print = currentPlayer.resultsByWpm();
        if(print.isBlank()){
            io.println(menu.getLanguage().noResultsPrompt());
            return;
        }
        io.println(print);
        io.input(menu.getLanguage().enterKeyPrompt());
    }
    private void printPersonalAccuracy(){
        io.print(menu.getLanguage().personalAccPrompt());
        String print = currentPlayer.resultsByAccuracy();
        if(print.isBlank()){
            io.println(menu.getLanguage().noResultsPrompt());
            return;
        }
        io.println(print);
        io.input(menu.getLanguage().enterKeyPrompt());
    }
    private void printPersonalStreak(){
        io.print(menu.getLanguage().personalStreakPrompt());
        String print = currentPlayer.resultsByStreak();
        if(print.isBlank()){
            io.println(menu.getLanguage().noResultsPrompt());
            return;
        }
        io.println(print);
        io.input(menu.getLanguage().enterKeyPrompt());
    }
    private void printPersonalScore(){
        io.print(menu.getLanguage().personalScorePrompt());
        String print = currentPlayer.resultsByScore();
        if(print.isBlank()){
            io.println(menu.getLanguage().noResultsPrompt());
            return;
        }
        io.println(print);
        io.input(menu.getLanguage().enterKeyPrompt());
    }

    private void printGlobalWpm(){
        io.print(menu.getLanguage().globalWpmPrompt());
        io.println(lbService.wpm());
        io.input(menu.getLanguage().enterKeyPrompt());
    }
    private void printGlobalAccuracy(){
        io.print(menu.getLanguage().globalAccPrompt());
        io.println(lbService.accuracy());
        io.input(menu.getLanguage().enterKeyPrompt());
    }
    private void printGlobalStreak(){
        io.print(menu.getLanguage().globalStreakPrompt());
        io.println(lbService.streak());
        io.input(menu.getLanguage().enterKeyPrompt());
    }
    private void printGlobalScore(){
        io.print(menu.getLanguage().globalScorePrompt());
        io.println(lbService.score());
        io.input(menu.getLanguage().enterKeyPrompt());
    }

}
