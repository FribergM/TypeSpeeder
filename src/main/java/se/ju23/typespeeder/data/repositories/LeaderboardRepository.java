package se.ju23.typespeeder.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.ju23.typespeeder.data.leaderboards.Leaderboard;

import java.util.List;

@Repository
public interface LeaderboardRepository extends JpaRepository<Leaderboard,Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM typespeeder.score_leaderboard")
    List<Leaderboard> findScoreLeaderboard();
    @Query(nativeQuery = true, value = "SELECT * FROM typespeeder.streak_leaderboard")
    List<Leaderboard> findStreakLeaderboard();
    @Query(nativeQuery = true, value = "SELECT * FROM typespeeder.wpm_leaderboard")
    List<Leaderboard> findWpmLeaderboard();
}