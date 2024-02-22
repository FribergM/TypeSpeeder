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

    public void streak(){
        List<Leaderboard> streakLb = leaderboardRepo.findStreakLeaderboard();

        for(Leaderboard l : streakLb){
            System.out.println(l);
        }
    }
    public void wpm(){
        List<Leaderboard> wpmLb = leaderboardRepo.findWpmLeaderboard();

        for(Leaderboard l : wpmLb){
            System.out.println(l);
        }
    }
    public void score(){
        List<Leaderboard> scoreLb = leaderboardRepo.findScoreLeaderboard();

        for(Leaderboard l : scoreLb){
            System.out.println(l);
        }
    }
    public void accuracy(){
        List<AccuracyLeaderboard> accLb = accLeaderboardRepo.findAvgAccuracyLeaderboard();

        for(AccuracyLeaderboard l : accLb){
            System.out.println(l);
        }
    }
}
