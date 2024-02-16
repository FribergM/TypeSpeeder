package se.ju23.typespeeder.io;

import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class SystemIO implements IO{

    Scanner input;

    public SystemIO(){
        input = new Scanner(System.in);
    }

    @Override
    public String input(){
        System.out.print("> ");
        return input.nextLine();
    }

    @Override
    public void output(String s){
        System.out.println("\n"+s);
    }

    @Override
    public void exit(){
        System.exit(0);
    }
}
