package se.ju23.typespeeder.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Result{

    @Id
    private Long id;

    int wpm;
    float accuracy;
    int streak;

    @ManyToOne
    Player player;

    public Result(int wpm, float accuracy, int streak){
        this.wpm = wpm;
        this.accuracy = accuracy;
        this.streak = streak;

    }
    public Result(){

    }

    public Long getId(){
        return id;
    }
}
