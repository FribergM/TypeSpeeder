package se.ju23.typespeeder.io;

import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuService{

    private List<String> menuOptions;
    private List<String> gameMenuOptions;

    public Menu(){
        initMenuOptions();
    }

    private void initMenuOptions(){
        menuOptions = new ArrayList<>();
        menuOptions.add("Main Menu!");
        menuOptions.add("1. Login.");
        menuOptions.add("2. Create Account.");
        menuOptions.add("3. Change Language/Byt Språk.");
        menuOptions.add("0. Exit.");

        gameMenuOptions = new ArrayList<>();
        gameMenuOptions.add("Game Menu!");
        gameMenuOptions.add("1. Play in English.");
        gameMenuOptions.add("2. Play in Swedish.");
        gameMenuOptions.add("3. Show results.");
        gameMenuOptions.add("4. Account Settings.");
        gameMenuOptions.add("0. Logout");
    }

    @Override
    public void displayMenu(){
        System.out.println();
        for(String s : getMenuOptions()){
            System.out.println(s);
        }
    }

    @Override
    public void displayGameMenu(){
        System.out.println();
        for(String s : getGameMenuOptions()){
            System.out.println(s);
        }
    }

    @Override
    public List<String> getMenuOptions(){
        return menuOptions;
    }

    @Override
    public List<String> getGameMenuOptions(){
        return gameMenuOptions;
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

/*
public String mainMenuEng(){
    return "Main Menu!\n"+
            "1. Login.\n"+
            "2. Create Account.\n"+
            "3. Change Language.\n"+
            "0. Exit.";
}
public String mainMenuSwe(){
    return "Huvudmenyn!\n"+
            "1. Logga in.\n"+
            "2. Skapa Konto.\n"+
            "3. Byt Språk.\n"+
            "0. Avsluta.";
}
public String gameMenuEng(){
    return "Game Menu!\n"+
            "1. Play in English.\n"+
            "2. Play in Swedish.\n"+
            "3. Show results.\n"+
            "4. Account Settings.\n"+
            "0. Logout.";
}
public String gameMenuSwe(){
    return "Spelmenyn!\n"+
            "1. Spela på Engelska.\n"+
            "2. Spela på Svenska.\n"+
            "3. Visa resultat.\n"+
            "4. Kontoinställningar.\n"+
            "0. Logga ut.";
}
*/
