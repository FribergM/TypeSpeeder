package se.ju23.typespeeder.io;

import java.util.List;

public interface IO{
    String input();
    void output(String s);
    void outputAll(List<String> list);
    void exit();
}
