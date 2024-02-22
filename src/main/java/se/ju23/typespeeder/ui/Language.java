package se.ju23.typespeeder.ui;

import java.util.List;

public interface Language{
    List<String> getMenuOptions();
    List<String> getGameMenuOptions();
    String getGameModeOptions();
    String getDifficultyOptions();
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
