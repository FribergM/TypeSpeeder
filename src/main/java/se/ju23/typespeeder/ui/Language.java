package se.ju23.typespeeder.ui;

import java.util.List;

public interface Language{
    List<String> getMenuOptions();
    List<String> getGameMenuOptions();
    String getGameModeOptions();
    String getDifficultyOptions();
    String getAccountSettings();
    String getLeaderboardOptions();
    String getGlobalLBOptions();
    String getPersonalLBOptions();
    String gameInstruction();
    String recentResultsPrompt();
    String noResultsPrompt();
    String personalWpmPrompt();
    String personalAccPrompt();
    String personalStreakPrompt();
    String personalScorePrompt();
    String globalWpmPrompt();
    String globalAccPrompt();
    String globalStreakPrompt();
    String globalScorePrompt();
    String countdownPrompt();
    String resultPrompt();
    String enterKeyPrompt();
    String expGainPrompt();
    String expLossPrompt();
    String levelUpPrompt();
    String cantLeaveEmptyPrompt();
    String logoutPrompt();
    String languageSelectedPrompt();
    String changeLanguagePrompt();
    String enterUsernamePrompt();
    String updateUsernamePrompt();
    String enterPasswordPrompt();
    String updatePasswordPrompt();
    String updateAliasPrompt();
    String menuErrorPrompt();
    String loginErrorPrompt();
    String uNameTakenPrompt();
    String invalidUsernamePrompt();
    String invalidPasswordPrompt();
    String invalidAliasPrompt();
}
