package se.ju23.typespeeder.data.leaderboards;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.Immutable;

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
        return "AccuracyLeaderboard{" +
                "alias='" + alias + '\'' +
                ", avgAccuracy=" + avgAccuracy +
                '}';
    }
}
