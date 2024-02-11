package se.ju23.typespeeder.logic;

public class Menu{

    boolean isEnglish;

    public Menu(boolean isEnglish){
        this.isEnglish = isEnglish;
    }

    public void setEnglish(boolean isEnglish){
        this.isEnglish = isEnglish;
    }

    public String mainMenu(){
        return isEnglish ? mainMenuEng() : mainMenuSwe();
    }
    public String gameMenu(){
        return isEnglish ? gameMenuEng() : gameMenuSwe();
    }

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
}
