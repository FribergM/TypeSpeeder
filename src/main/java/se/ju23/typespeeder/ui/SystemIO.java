package se.ju23.typespeeder.ui;

import java.util.List;
import java.util.Scanner;

public class SystemIO implements IO{

    Scanner scanner;

    @Override
    public String input(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        System.out.print("> ");
        return scanner.nextLine();
    }

    @Override
    public String input(String s){
        println(s);
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        System.out.print("> ");
        return scanner.nextLine();
    }

    @Override
    public void println(){
        System.out.println();
    }

    @Override
    public void println(String s){
        System.out.println("\n"+s);
    }

    @Override
    public void print(String s){
        System.out.print(RESET+"\n"+s);
    }

    @Override
    public void printRed(String s){
        System.out.print(RED+s+ RESET);
    }

    @Override
    public void printCyan(String s){
        System.out.print(CYAN+s+ RESET);
    }

    @Override
    public void outputAll(List<String> list){
        System.out.println();
        for(String s : list){
            System.out.println(s);
        }
    }

    @Override
    public void exit(){
        System.exit(0);
    }
}
