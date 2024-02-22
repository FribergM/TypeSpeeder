package se.ju23.typespeeder.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.ju23.typespeeder.data.leaderboards.AccuracyLeaderboard;
import se.ju23.typespeeder.data.leaderboards.Leaderboard;
import se.ju23.typespeeder.data.repositories.AccLeaderboardRepository;
import se.ju23.typespeeder.data.repositories.LeaderboardRepository;

import java.util.List;

@Service
public class LeaderboardService{

    @Autowired
    LeaderboardRepository leaderboardRepo;
    @Autowired
    AccLeaderboardRepository accLeaderboardRepo;

    public String streak(){
        List<Leaderboard> streakLb = leaderboardRepo.findStreakLeaderboard();
        StringBuilder builder = new StringBuilder();
        int length = streakLb.get(0).streakToString().length();

        builder.append("\n").append(Util.getFrameByLength(length));
        for(int i=0;i< streakLb.size();i++){
            builder.append(String.format("\n| %-3s",(i+1)+"."));
            builder.append(streakLb.get(i).streakToString());
        }
        builder.append("\n").append(Util.getFrameByLength(length));

        return builder.toString().trim();
    }

    public String wpm(){
        List<Leaderboard> wpmLb = leaderboardRepo.findWpmLeaderboard();
        StringBuilder builder = new StringBuilder();

        int length = wpmLb.get(0).wpmToString().length();

        builder.append("\n").append(Util.getFrameByLength(length));
        for(int i=0;i<wpmLb.size();i++){
            builder.append(String.format("\n| %-3s",(i+1)+"."));
            builder.append(wpmLb.get(i).wpmToString());
        }
        builder.append("\n").append(Util.getFrameByLength(length));

        return builder.toString().trim();
    }

    public String score(){
        List<Leaderboard> scoreLb = leaderboardRepo.findScoreLeaderboard();
        StringBuilder builder = new StringBuilder();

        int length = scoreLb.get(0).scoreToString().length();

        builder.append("\n").append(Util.getFrameByLength(length));
        for(int i=0;i< scoreLb.size();i++){
            builder.append(String.format("\n| %-3s",(i+1)+"."));
            builder.append(scoreLb.get(i).scoreToString());
        }
        builder.append("\n").append(Util.getFrameByLength(length));

        return builder.toString().trim();
    }

    public String accuracy(){
        List<AccuracyLeaderboard> accLb = accLeaderboardRepo.findAvgAccuracyLeaderboard();
        StringBuilder builder = new StringBuilder();

        int length = accLb.get(0).accuracyToString().length();

        builder.append("\n").append(Util.getFrameByLength(length));
        for(int i=0;i< accLb.size();i++){
            builder.append(String.format("\n| %-3s",(i+1)+"."));
            builder.append(accLb.get(i).accuracyToString());
        }
        builder.append("\n").append(Util.getFrameByLength(length));

        return builder.toString().trim();
    }
}
