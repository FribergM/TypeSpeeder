package se.ju23.typespeeder.io;

import java.util.List;

public interface IO{
    String CYAN = "\033[36m";
    String RED = "\033[31m";
    String RESET = "\033[0m";
    String input();
    void println(String s);
    void print(String s);
    void printRed(String s);
    void printCyan(String s);
    void outputAll(List<String> list);
    void exit();
}
