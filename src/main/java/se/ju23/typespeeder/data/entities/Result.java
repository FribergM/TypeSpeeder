package se.ju23.typespeeder.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Result{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int wpm;
    private double accuracy;
    private int streak;
    private double score;

    @ManyToOne
    private Player player;

    public Result(int wpm, double accuracy, int streak, double score){
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.streak = streak;
        this.score = score;

    }
    public Result(){

    }

    public void setPlayer(Player player){
        this.player = player;
    }

    @Override
    public String toString(){
        double accuracyAsPercentage = accuracy*100;
        int accPercentInt = (int) accuracyAsPercentage;
        String accPercent = accPercentInt+"%";
        return String.format("| %-5s%-3d | %-10s%-4s | %-8s%-2d | %-7s%-5.1f |",
                "WPM: ",wpm,"ACCURACY: ",accPercent,"STREAK: ",streak,"SCORE: ",score);
    }

    public int getWpm(){
        return wpm;
    }
    public double getAccuracy(){
        return accuracy;
    }
    public int getStreak(){
        return streak;
    }
    public double getScore(){
        return score;
    }
}
