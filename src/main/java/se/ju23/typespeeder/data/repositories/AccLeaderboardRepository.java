package se.ju23.typespeeder.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.ju23.typespeeder.data.leaderboards.AccuracyLeaderboard;

import java.util.List;

@Repository
public interface AccLeaderboardRepository extends JpaRepository<AccuracyLeaderboard, Integer>{
    @Query(nativeQuery = true, value = "SELECT * FROM typespeeder.avgaccuracy_leaderboard")
    List<AccuracyLeaderboard> findAvgAccuracyLeaderboard();
}
