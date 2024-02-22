package se.ju23.typespeeder.data.leaderboards;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;
import se.ju23.typespeeder.data.services.Util;

@Entity
@Immutable
public class AccuracyLeaderboard{
    @Id
    int id;
    String alias;
    double avgAccuracy;

    public String getAlias(){
        return alias;
    }

    public double getAvgAccuracy(){
        return avgAccuracy;
    }

    @Override
    public String toString(){
        double accuracyAsPercentage = avgAccuracy*100;
        int accPercentInt = (int) accuracyAsPercentage;
        String accPercent = accPercentInt+"%";
        return String.format("| %-16s | %-10s%-4s |",
                Util.centerText(alias,16),"AVG ACCURACY: ",accPercent);
    }
    public String accuracyToString(){
        double accuracyAsPercentage = avgAccuracy*100;
        int accPercentInt = (int) accuracyAsPercentage;
        String accPercent = accPercentInt+"%";
        return String.format("| %-16s | %-14s%-4s |",
                Util.centerText(alias,16),"AVG ACCURACY: ",accPercent);
    }
}
