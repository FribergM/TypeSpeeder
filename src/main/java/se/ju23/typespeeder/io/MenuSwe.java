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
        menuOptions.add("3. Byt Språk/Change Language.");
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
        return "Vill du byta till Engelska?\n"+
                "1. Ja\n"+
                "2. Nej";
    }

    @Override
    public String enterUsernamePrompt(){
        return "Ange användernamn. \"0\" för att återvända.";
    }

    @Override
    public String updateUsernamePrompt(){
        return "Ange nytt användernamn. \"0\" för att återvända.\n" +
                "(4-15 tecken. [A-Z]&[0-9])";
    }

    @Override
    public String enterPasswordPrompt(){
        return "Ange lösenord. \"0\" för att återvända.";
    }

    @Override
    public String updatePasswordPrompt(){
        return "Ange nytt lösenord. \"0\" för att återvända.\n" +
                "(4-20 tecken. [A-Z],[0-9]&[Symboler])";
    }

    @Override
    public String updateAliasPrompt(){
        return "Ange nytt alias. \"0\" för att återvända.\n" +
                "(1-15 tecken. [A-Z],[0-9]&[Symboler])";
    }

    @Override
    public String menuErrorPrompt(){
        return "Felaktigt menyalternativ.";
    }

    @Override
    public String loginErrorPrompt(){
        return "Inkorrekt användarnamn/lösenord!";
    }

    @Override
    public String uNameTakenPrompt(){
        return "Användarnamnet är redan upptaget.";
    }

    @Override
    public String invalidUsernamePrompt(){
        return "Felaktigt användarnamn.";
    }

    @Override
    public String invalidPasswordPrompt(){
        return "Felaktigt lösenord.";
    }

    @Override
    public String invalidAliasPrompt(){
        return "Felaktigt alias";
    }
}
