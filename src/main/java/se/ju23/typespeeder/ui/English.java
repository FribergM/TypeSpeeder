package se.ju23.typespeeder.ui;

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
    public String getGameModeOptions(){
        return "Choose a game-mode!\n" +
                "1. Write full sentence.\n" +
                "2. Write words.\n" +
                "3. Write letters.\n" +
                "4. Write special characters.\n" +
                "0. Go back.";
    }

    @Override
    public String getDifficultyOptions(){
        return "Choose difficulty!\n" +
                "1. Easy.\n" +
                "2. Medium.\n" +
                "3. Hard.\n" +
                "0. Go back";
    }

    @Override
    public String getAccountSettings(){
        return "Account Settings!\n" +
                "1. Change username.\n" +
                "2. Change password.\n" +
                "3. Change alias.\n" +
                "0. Go back";
    }

    @Override
    public String getLeaderboardOptions(){
        return "Performance Center!\n" +
                "1. View global leaderboards.\n" +
                "2. View your personal leaderboards.\n" +
                "3. View your recent results.\n" +
                "0. Go back";
    }

    @Override
    public String getGlobalLBOptions(){
        return "Global Leaderboards!\n" +
                "1. WPM leaderboard.\n" +
                "2. Average-accuracy leaderboard.\n" +
                "3. Streak leaderboard.\n" +
                "4. Score leaderboard.\n" +
                "0. Go back";
    }

    @Override
    public String getPersonalLBOptions(){
        return "Personal Leaderboards!\n" +
                "1. WPM leaderboard.\n" +
                "2. Accuracy leaderboard.\n" +
                "3. Streak leaderboard.\n" +
                "4. Score leaderboard.\n" +
                "0. Go back";
    }

    @Override
    public String gameInstruction(){
        return "The game is about entering the characters that show up in \033[36mblue\033[0m!"+
                "\nIn game mode 1/2, you also need to add spaces between each word." +
                "\nIn game mode 3/4, you just write the characters without any spaces."+
                "\nDon't forget capital letters when needed!\nGood luck!";
    }

    @Override
    public String recentResultsPrompt(){
        return "Recent results:";
    }

    @Override
    public String noResultsPrompt(){
        return "You have no recorded results.";
    }

    @Override
    public String personalWpmPrompt(){
        return "Personal WPM Leaderboard:";
    }

    @Override
    public String personalAccPrompt(){
        return "Personal Accuracy Leaderboard:";
    }

    @Override
    public String personalStreakPrompt(){
        return "Personal Streak Leaderboard:";
    }

    @Override
    public String personalScorePrompt(){
        return "Personal Score Leaderboard:";
    }

    @Override
    public String globalWpmPrompt(){
        return "Global WPM Leaderboard";
    }

    @Override
    public String globalAccPrompt(){
        return "Global Avg.Accuracy Leaderboard:";
    }

    @Override
    public String globalStreakPrompt(){
        return "Global Streak Leaderboard:";
    }

    @Override
    public String globalScorePrompt(){
        return "Global Score Leaderboard:";
    }

    @Override
    public String countdownPrompt(){
        return "Game is starting in: ";
    }

    @Override
    public String resultPrompt(){
        return "RESULT:";
    }

    @Override
    public String enterKeyPrompt(){
        return "[Enter]";
    }

    @Override
    public String expGainPrompt(){
        return "Exp Gain: ";
    }

    @Override
    public String expLossPrompt(){
        return "Exp Loss: ";
    }

    @Override
    public String levelUpPrompt(){
        return "You leveled up to : ";
    }

    @Override
    public String cantLeaveEmptyPrompt(){
        return "Fine. I'm not forcing you to play...";
    }

    @Override
    public String logoutPrompt(){
        return "Logging out...";
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
