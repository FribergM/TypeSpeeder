package se.ju23.typespeeder.ui;

import java.util.List;

public interface MenuService{

    void displayMenu();
    void displayGameMenu();
    void displayGameModes();
    void displayDifficulties();
    List<String> getMenuOptions();
    List<String> getGameMenuOptions();
    void chooseLanguage();
    void changeLanguage();
    Language getLanguage();
}
