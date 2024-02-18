package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.data.Text;

import java.util.ArrayList;
import java.util.List;

public class Challenge{

    private boolean isInEnglish;
    private int gameMode;
    private int difficulty;

    List<Text> texts;

    public void startChallenge(){
        texts = new ArrayList<>();
    }
    public String lettersToType(){
        return null;
    }

    public boolean isInEnglish(){
        return isInEnglish;
    }

    public void playInEnglish(boolean isInEnglish){
        this.isInEnglish = isInEnglish;
    }

    public int getGameMode(){
        return gameMode;
    }

    public void setGameMode(int gameMode){
        this.gameMode = gameMode;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }
}
