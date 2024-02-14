package se.ju23.typespeeder.io;

import java.util.List;

public interface MenuService{

    void displayMenu();
    void displayGameMenu();
    List<String> getMenuOptions();
    List<String> getGameMenuOptions();
}
