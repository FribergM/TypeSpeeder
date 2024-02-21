package se.ju23.typespeeder.logic;

import se.ju23.typespeeder.data.Accuracy;
import se.ju23.typespeeder.data.Result;
import se.ju23.typespeeder.data.Text;
import se.ju23.typespeeder.io.IO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        Set<Character> specialChar = Set.of('.',',','!','?','-','\'',' ','\n');
        io.output("");
        if(gameMode == 1){
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
        else if(gameMode == 2){
            StringBuilder challengeBuilder = new StringBuilder();
            String[] words = challengeText.split(" +");
            double gameDiff = implementDifficulty(4);
            Random random = new Random();

            for(int i = 0; i < words.length; i++){
                if(random.nextDouble() < 1 / gameDiff){
                    char lastChar = words[i].charAt(words[i].length()-1);
                    if(specialChar.contains(lastChar)){
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

        }else if(gameMode == 3){
            StringBuilder challengeBuilder = new StringBuilder();
            char[] chars = challengeText.toCharArray();
            double gameDiff = implementDifficulty(0);
            Random random = new Random();

            for(int i = 0; i < chars.length; i++){
                String charStr = chars[i]+"";
                if(random.nextDouble() < 1 / gameDiff){
                    if(specialChar.contains(chars[i])){
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
        }else if(gameMode == 4){
            StringBuilder challengeBuilder = new StringBuilder();
            char[] chars = challengeText.toCharArray();
            double gameDiff = implementDifficulty(0);
            Random random = new Random();

            for (int i = 0; i < chars.length; i++){
                String charStr = chars[i]+"";
                if(random.nextDouble() < 1 / gameDiff){
                    if(specialChar.contains(chars[i])){
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
        throw new RuntimeException();
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

        return new Result(wpm, accuracy.getPercentage(), accuracy.getStreak());
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
            System.out.println(lettersToType.split(" ").length);
            return lettersToType.split(" ").length;
        }else{
            System.out.println(lettersToType.length()/5);
            return lettersToType.length()/4;
        }
    }
}
