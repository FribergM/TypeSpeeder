package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.data.entities.Accuracy;
import se.ju23.typespeeder.data.entities.Result;
import se.ju23.typespeeder.data.entities.Text;
import se.ju23.typespeeder.ui.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Challenge{

    private boolean isInEnglish;
    private int gameMode;
    private int difficulty;
    private String challengeText;
    private List<Text> texts;

    public Challenge(boolean isInEnglish, int gameMode, int difficulty, List<Text> texts){
        this.isInEnglish = isInEnglish;
        this.gameMode = gameMode;
        this.difficulty = difficulty;
        this.texts = texts;
        initChallenge();
    }

    private void initChallenge(){
        List<String> validTexts = new ArrayList<>();
        if(gameMode == 1){
            for(Text t : texts){
                if((t.getDifficulty() == difficulty) && (t.getLanguage() == isInEnglish)){
                    validTexts.add(t.getText());
                }
            }
        }else{
            for(Text t : texts){
                if(t.getLanguage() == isInEnglish){
                    validTexts.add(t.getText());
                }
            }
        }
        challengeText = getRandomText(validTexts);
    }

    public Result startChallenge(IO io,String lettersToType){
        long startTime = System.currentTimeMillis();
        String playerAttempt = io.input();
        long endTime = System.currentTimeMillis();
        if(playerAttempt.isBlank()){
            return null;
        }
        return processResult(startTime,endTime,lettersToType,playerAttempt);
    }

    public String lettersToType(IO io){
        Set<Character> specialChars = Set.of('.',',','!','?','-','\'',' ','\n');
        io.println();
        if(gameMode == 1){
            return gameModeOneString(io);
        }else if(gameMode == 2){
            return gameModeTwoString(io,specialChars);
        }else if(gameMode == 3){
            return gameModeThreeString(io,specialChars);
        }else if(gameMode == 4){
            return gameModeFourString(io,specialChars);
        }
        throw new RuntimeException();
    }

    private String gameModeOneString(IO io){
        String challengeSentence = "";
        String[] sentences = challengeText.split("[.]");

        int challengeSentenceIndex = (int) (Math.random() * sentences.length);

        for(int i=0;i<sentences.length;i++){
            sentences[i] += ".";
            if(i== challengeSentenceIndex){
                io.printCyan(sentences[i]);
                challengeSentence = sentences[i];
            }else{
                io.printRed(sentences[i]);
            }
        }
        return challengeSentence.trim();
    }
    private String gameModeTwoString(IO io,Set<Character> specialChars){
        StringBuilder challengeBuilder = new StringBuilder();
        String[] words = challengeText.split(" +");
        double gameDiff = implementDifficulty(4);
        Random random = new Random();

        for(int i = 0; i < words.length; i++){
            if(random.nextDouble() < 1 / gameDiff){
                char lastChar = words[i].charAt(words[i].length()-1);
                if(specialChars.contains(lastChar)){
                    words[i] = words[i].substring(0, words[i].length()-1);
                    io.printCyan(words[i]);
                    io.printRed(lastChar+" ");
                }else{
                    io.printCyan(words[i]+" ");
                }
                words[i] += " ";
                if(words[i].charAt(0) == '\n'){
                    words[i] = words[i].substring(1);
                }
                challengeBuilder.append(words[i]);
            }else{
                io.printRed(words[i] + " ");
            }
        }
        return challengeBuilder.toString().trim();
    }
    private String gameModeThreeString(IO io,Set<Character> specialChars){
        StringBuilder challengeBuilder = new StringBuilder();
        char[] chars = challengeText.toCharArray();
        double gameDiff = implementDifficulty(0);
        Random random = new Random();

        for(int i = 0; i < chars.length; i++){
            String charStr = chars[i]+"";
            if(random.nextDouble() < 1 / gameDiff){
                if(specialChars.contains(chars[i])){
                    io.printRed(charStr);
                }else{
                    io.printCyan(charStr);
                    charStr +="";
                    challengeBuilder.append(charStr);
                }
            }else{
                charStr = chars[i]+"";
                io.printRed(charStr);
            }
        }
        return challengeBuilder.toString().trim();
    }
    private String gameModeFourString(IO io,Set<Character> specialChars){
        StringBuilder challengeBuilder = new StringBuilder();
        char[] chars = challengeText.toCharArray();
        double gameDiff = implementDifficulty(0);
        Random random = new Random();

        for (int i = 0; i < chars.length; i++){
            String charStr = chars[i]+"";
            if(random.nextDouble() < 1 / gameDiff){
                if(specialChars.contains(chars[i])){
                    io.printRed(charStr);
                }else{
                    chars[i] = getRandomSChar();
                    charStr = chars[i]+"";
                    io.printCyan(charStr);
                    challengeBuilder.append(charStr);
                }
            }else{
                io.printRed(charStr);
            }
        }
        return challengeBuilder.toString().trim();
    }

    private double implementDifficulty(double adjustment){
        switch(difficulty){
            case 1 -> {return 12-adjustment;}
            case 2 -> {return 9-adjustment;}
            case 3 -> {return 6-adjustment;}
        }
        return 6;
    }
    private String getRandomText(List<String> validTexts){
        int rand = (int) (Math.random()*validTexts.size());

        return validTexts.get(rand);
    }
    private char getRandomSChar(){
        char[] charArr ={'@','#','!','_','/','%','&','*','?'};
        int rand = (int) (Math.random()*charArr.length);

        return charArr[rand];
    }

    private Result processResult(long startTime, long endTime, String lettersToType, String playerAttempt){
        double timeInMinutes = (double) (endTime - startTime) / (60 * 1000);

        Accuracy accuracy = accuracyCalculator(lettersToType,playerAttempt);

        int wpm = wpmCalculator(numberOfWords(lettersToType),timeInMinutes, accuracy);

        return generateOverallScore(wpm, accuracy);
    }
    private Accuracy accuracyCalculator(String lettersToType, String playerAttempt){
        if(lettersToType.contains(" ")){
            String[] words = lettersToType.split(" +");
            String[] playerWords = playerAttempt.split(" +");

            int fewestWords = Math.min(words.length,playerWords.length);

            int accurateWords = 0;
            int highestStreak = 0;
            int currentStreak = 0;

            for(int i=0;i<fewestWords;i++){
                if(words[i].equals(playerWords[i])){
                    currentStreak++;
                    accurateWords++;
                }else{
                    currentStreak = 0;
                }
                highestStreak = Math.max(highestStreak,currentStreak);
            }

            double accuracy = (double) accurateWords / words.length;
            accuracy = Math.round(accuracy*100.0)/100.0;

            return new Accuracy(accuracy, highestStreak);
        }else {
            int fewestChars = Math.min(lettersToType.length(),playerAttempt.length());

            int accurateChars = 0;
            int highestStreak = 0;
            int currentStreak = 0;

            for(int i=0;i<fewestChars;i++){
                if(lettersToType.charAt(i) == playerAttempt.charAt(i)){
                    currentStreak++;
                    accurateChars++;
                }else{
                    currentStreak = 0;
                }
                highestStreak = Math.max(highestStreak, currentStreak);
            }

            double accuracy = (double) accurateChars/ lettersToType.length();

            accuracy = Math.round(accuracy*100.0)/100.0;

            return new Accuracy(accuracy,highestStreak);
        }
    }
    private int wpmCalculator(double numOfWords, double timeInMinutes, Accuracy accuracy){
        return (int) Math.ceil((numOfWords/ timeInMinutes) * accuracy.getPercentage());
    }
    private int numberOfWords(String lettersToType){
        if(lettersToType.contains(" ")){
            return lettersToType.split(" ").length;
        }else{
            return lettersToType.length()/4;
        }
    }

    private Result generateOverallScore(int wpm, Accuracy accuracy){
        double overallScore = wpm * (1 + accuracy.getPercentage()) + (accuracy.getStreak()/2.0);
        overallScore = Math.round(overallScore*100.0)/100.0;
        return new Result(wpm, accuracy.getPercentage(), accuracy.getStreak(),overallScore);
    }

    public int calculateExperience(Result result, int difficulty){
        int wpm = result.getWpm();
        double accuracy = result.getAccuracy();
        int difficultyPenalty = 50;
        switch(difficulty){
            case 1 -> difficultyPenalty = 10;
            case 2 -> difficultyPenalty = 25;
            case 3 -> difficultyPenalty = 40;
        }
        int exp = wpm - difficultyPenalty;

        if(accuracy == 1.0){
            exp += 40;
        }else if(accuracy > 0.9){
            exp += 30;
        }else if(accuracy > 0.8){
            exp += 10;
        }else if(accuracy > 0.7){
            exp += 5;
        }
        return exp;
    }
}
