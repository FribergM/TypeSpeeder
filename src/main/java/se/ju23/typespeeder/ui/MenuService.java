package se.ju23.typespeeder.ui;

import java.util.List;

public interface MenuService{

    void displayMenu();
    void displayGameMenu();
    void displayGameModes();
    void displayDifficulties();
    void displayAccountSettings();
    void displayLeaderboardOptions();
    void displayGlobalLBOptions();
    void displayPersonalLBOptions();
    List<String> getMenuOptions();
    List<String> getGameMenuOptions();
    void chooseLanguage();
    void changeLanguage();
    Language getLanguage();
}
