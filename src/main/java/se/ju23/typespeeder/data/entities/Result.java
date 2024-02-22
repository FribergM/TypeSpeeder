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
        return "WPM: " + wpm +
                "\nACCURACY: " + accuracy*100+"%"+
                "\nSTREAK: " + streak+
                "\nSCORE: "+ score;
    }

    public int getWpm(){
        return wpm;
    }

    public double getAccuracy(){
        return accuracy;
    }
}
