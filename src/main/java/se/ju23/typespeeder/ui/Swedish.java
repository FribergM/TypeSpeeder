package se.ju23.typespeeder.ui;

import java.util.ArrayList;
import java.util.List;

public class Swedish implements Language{

    @Override
    public List<String> getMenuOptions(){
        List<String> menuOptions = new ArrayList<>();
        menuOptions.add("Huvudmenyn!");
        menuOptions.add("1. Logga in.");
        menuOptions.add("2. Skapa Konto");
        menuOptions.add("3. Byt Språk/Change Language.");
        menuOptions.add("0. Avsluta.");

        return menuOptions;
    }

    @Override
    public List<String> getGameMenuOptions(){
        List<String> gameMenuOptions = new ArrayList<>();
        gameMenuOptions.add("Spelmenyn!");
        gameMenuOptions.add("1. Spela på Engelska.");
        gameMenuOptions.add("2. Spela på Svenska.");
        gameMenuOptions.add("3. Visa resultat.");
        gameMenuOptions.add("4. Kontoinställningar.");
        gameMenuOptions.add("0. Logga ut.");

        return gameMenuOptions;
    }

    @Override
    public String getGameModeOptions(){
        return "Välj spelläge!\n" +
                "1. Skriv hela meningar.\n" +
                "2. Skriv ord.\n" +
                "3. Skriv bokstäver.\n" +
                "4. Skriv specialtecken.\n" +
                "0. Återvänd.";
    }

    @Override
    public String getDifficultyOptions(){
        return "Välj svårighetsgrad!\n" +
                "1. Lätt.\n" +
                "2. Medium.\n" +
                "3. Svårt.\n" +
                "0. Återvänd.";
    }

    @Override
    public String getAccountSettings(){
        return "Kontoinställningar!\n" +
                "1. Byt användarnamn.\n" +
                "2. Byt lösenord.\n" +
                "3. Byt alias.\n" +
                "0. Återvänd.";
    }

    @Override
    public String getLeaderboardOptions(){
        return "Prestanda centret!\n" +
                "1. Se globala topplistor.\n" +
                "2. Se dina personliga topplistor.\n" +
                "3. Se dina senaste resultat.\n" +
                "0. Återvänd.";
    }

    @Override
    public String getGlobalLBOptions(){
        return "Globala Topplistor!\n" +
                "1. WPM topplista.\n" +
                "2. Precisions topplista.\n" +
                "3. Flest-i-rad topplista.\n" +
                "4. Poäng topplista.\n" +
                "0. Återvänd.";
    }

    @Override
    public String getPersonalLBOptions(){
        return "Personliga Topplistor!\n" +
                "1. WPM-topplista.\n" +
                "2. Precisions-topplista.\n" +
                "3. Flest-i-rad-topplista.\n" +
                "4. Poäng-topplista.\n" +
                "0. Återvänd.";
    }

    @Override
    public String gameInstruction(){
        return "Spelet går ut på att skriva alla tecken som visas i \033[36mblått\033[0m!"+
                "\nI spelläge 1/2 så måste du även tillägga mellanslag mellan orden."+
                "\nI spelläge 3/4 så behöver du enbart skriva tecken utan mellanslag."+
                "\nGlöm inte stor bokstav när det behövs!\nLycka till!";
    }

    @Override
    public String recentResultsPrompt(){
        return "Senaste Resultat:";
    }

    @Override
    public String noResultsPrompt(){
        return "Du har inga resultat ännu.";
    }

    @Override
    public String personalWpmPrompt(){
        return "Personlig WPM-Topplista:";
    }

    @Override
    public String personalAccPrompt(){
        return "Personlig Precisions-Topplista:";
    }

    @Override
    public String personalStreakPrompt(){
        return "Personlig Flest-I-Rad-Topplista:";
    }

    @Override
    public String personalScorePrompt(){
        return "Personlig Score-Topplista";
    }

    @Override
    public String globalWpmPrompt(){
        return "Global WPM-Topplista:";
    }

    @Override
    public String globalAccPrompt(){
        return "Global Precisions-Topplista:";
    }

    @Override
    public String globalStreakPrompt(){
        return "Global Flest-I-Rad-Topplista:";
    }

    @Override
    public String globalScorePrompt(){
        return "Global Score-Topplista";
    }

    @Override
    public String countdownPrompt(){
        return "Spelet startar om: ";
    }

    @Override
    public String resultPrompt(){
        return "RESULTAT:";
    }

    @Override
    public String enterKeyPrompt(){
        return "[Blanksteg]";
    }

    @Override
    public String expGainPrompt(){
        return "Exp ökning: ";
    }

    @Override
    public String expLossPrompt(){
        return "Exp minskning: ";
    }

    @Override
    public String levelUpPrompt(){
        return "Du nådde nivå: ";
    }

    @Override
    public String cantLeaveEmptyPrompt(){
        return "Okej. Jag tvingar dig inte att spela...";
    }

    @Override
    public String logoutPrompt(){
        return "Loggar ut...";
    }

    @Override
    public String languageSelectedPrompt(){
        return "Svenska valt.";
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
