package se.ju23.typespeeder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextRepository extends JpaRepository<Text,Integer>{
    List<Text> findAllByLanguageAndDifficulty(boolean language, int difficulty);
}
