package se.ju23.typespeeder.io;

import java.util.List;

public interface MenuService{

    void displayMenu();
    List<String> getMenuOptions();

    List<String> getGameMenuOptions();
}
