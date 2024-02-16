package se.ju23.typespeeder.io;

import java.util.ArrayList;
import java.util.List;

public class English implements Language{

    @Override
    public List<String> getMenuOptions(){
        List<String> menuOptions = new ArrayList<>();
        menuOptions.add("Main Menu!");
        menuOptions.add("1. Login.");
        menuOptions.add("2. Create Account.");
        menuOptions.add("3. Change Language/Byt Språk.");
        menuOptions.add("0. Exit.");

        return menuOptions;
    }

    @Override
    public List<String> getGameMenuOptions(){
        List<String> gameMenuOptions = new ArrayList<>();
        gameMenuOptions.add("Game Menu!");
        gameMenuOptions.add("1. Play in English.");
        gameMenuOptions.add("2. Play in Swedish.");
        gameMenuOptions.add("3. Show results.");
        gameMenuOptions.add("4. Account Settings.");
        gameMenuOptions.add("0. Logout");

        return gameMenuOptions;
    }

    @Override
    public String languageSelectedPrompt(){
        return "English selected.";
    }

    @Override
    public String changeLanguagePrompt(){
        return "Do you wish to change to Swedish?\n"+
                "1. Yes\n"+
                "2. No";
    }

    @Override
    public String enterUsernamePrompt(){
        return "Enter username. \"0\" to return.";
    }

    @Override
    public String updateUsernamePrompt(){
        return "Enter a new username. \"0\" to return.\n" +
                "(4-15 characters. [A-Z],[0-9])";
    }

    @Override
    public String enterPasswordPrompt(){
        return "Enter password. \"0\" to return.";
    }

    @Override
    public String updatePasswordPrompt(){
        return "Enter a new password. \"0\" to return.\n" +
                "(4-20 characters. [A-Z],[0-9]&[Symbols].)";
    }

    @Override
    public String updateAliasPrompt(){
        return "Enter a new alias. \"0\" to return.\n" +
                "(1-15 characters. [A-Z],[0-9]&[Symbols].)";
    }

    @Override
    public String menuErrorPrompt(){
        return "Invalid menu option.";
    }

    @Override
    public String loginErrorPrompt(){
        return "Incorrect username/password!";
    }

    @Override
    public String uNameTakenPrompt(){
        return "Username is already taken.";
    }

    @Override
    public String invalidUsernamePrompt(){
        return "Invalid username.";
    }

    @Override
    public String invalidPasswordPrompt(){
        return "Invalid password.";
    }

    @Override
    public String invalidAliasPrompt(){
        return "Invalid alias";
    }
}
