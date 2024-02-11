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
        menuOptions.add("3. Change Language.");
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
    public List<String> getMenuOptions(){
        return menuOptions;
    }

    @Override
    public List<String> getGameMenuOptions(){
        return gameMenuOptions;
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
