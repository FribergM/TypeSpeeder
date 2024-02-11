package se.ju23.typespeeder.io;

import java.util.ArrayList;
import java.util.List;

public class MenuSwe implements MenuService{

    private List<String> menuOptions;
    private List<String> gameMenuOptions;

    public MenuSwe(){
        initMenuOptions();
    }

    private void initMenuOptions(){
        menuOptions = new ArrayList<>();
        menuOptions.add("Huvudmenyn!");
        menuOptions.add("1. Logga in.");
        menuOptions.add("2. Skapa Konto");
        menuOptions.add("3. Byt Språk.");
        menuOptions.add("0. Avsluta.");

        gameMenuOptions = new ArrayList<>();
        gameMenuOptions.add("Spelmenyn!");
        gameMenuOptions.add("1. Spela på Engelska.");
        gameMenuOptions.add("2. Spela på Svenska.");
        gameMenuOptions.add("3. Visa resultat.");
        gameMenuOptions.add("4. Kontoinställningar.");
        gameMenuOptions.add("0. Logga ut.");
    }

    @Override
    public void displayMenu(){
        System.out.println();
        for(String s : menuOptions){
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
