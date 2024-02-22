package se.ju23.typespeeder.data.leaderboards;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Leaderboard{
    @Id
    int id;
    @Column(name = "alias")
    String alias;
    @Column(name = "wpm")
    int wpm;
    @Column(name = "accuracy")
    double accuracy;
    @Column(name = "streak")
    int streak;
    @Column(name = "score")
    double score;


    public String getAlias(){
        return alias;
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

    @Override
    public String toString(){
        return "Leaderboard{" +
                "alias='" + alias + '\'' +
                ", wpm=" + wpm +
                ", accuracy=" + accuracy +
                ", streak=" + streak +
                ", score=" + score +
                '}';
    }
}
