package se.ju23.typespeeder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ju23.typespeeder.logic.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Text,Integer>{
}
