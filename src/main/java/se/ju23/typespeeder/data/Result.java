package se.ju23.typespeeder.data;

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

    @ManyToOne
    private Player player;

    public Result(int wpm, double accuracy, int streak){
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.streak = streak;

    }
    public Result(){

    }

    public void setPlayer(Player player){
        this.player = player;
    }

    @Override
    public String toString(){
        return "Result{" +
                "id=" + id +
                ", wpm=" + wpm +
                ", accuracy=" + accuracy +
                ", streak=" + streak +
                '}';
    }
}
