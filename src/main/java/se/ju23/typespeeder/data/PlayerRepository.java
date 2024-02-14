package se.ju23.typespeeder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
    Player findByUsernameAndPassword(String username, String password);
}
