package se.ju23.typespeeder.io;

import java.util.List;

public interface MenuService{

    void displayMenu();
    void displayGameMenu();
    List<String> getMenuOptions();
    List<String> getGameMenuOptions();
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
