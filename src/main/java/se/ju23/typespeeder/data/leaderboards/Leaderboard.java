package se.ju23.typespeeder.data.leaderboards;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;
import se.ju23.typespeeder.services.Util;

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
        double accuracyAsPercentage = accuracy*100;
        int accPercentInt = (int) accuracyAsPercentage;
        String accPercent = accPercentInt+"%";
        return String.format("| %-16s | %-5s%-3d | %-10s%-4s | %-8s%-2d | %-7s%-5.1f |",
                Util.centerText(alias,16),"WPM: ",wpm,"ACCURACY: ",accPercent,"STREAK: ",streak,"SCORE: ",score);
    }
    public String wpmToString(){
        return String.format("| %-16s | %-5s%-3d |",
                Util.centerText(alias,16),"WPM: ",wpm);
    }

    public String streakToString(){
        return String.format("| %-16s | %-5s%-3d |",
                Util.centerText(alias,16),"STREAK: ",streak);
    }
    public String scoreToString(){
        double accuracyAsPercentage = accuracy*100;
        int accPercentInt = (int) accuracyAsPercentage;
        String accPercent = accPercentInt+"%";
        return String.format("| %-16s | %-7s%-5.1f | %-5s%-3d | %-10s%-4s | %-8s%-2d |",
                Util.centerText(alias,16),"SCORE: ",score,"WPM: ",wpm,"ACCURACY: ",accPercent,"STREAK: ",streak);
    }
}
