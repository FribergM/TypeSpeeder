package se.ju23.typespeeder.io;

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
    public void output(String s){
        System.out.println("\n"+s);
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
