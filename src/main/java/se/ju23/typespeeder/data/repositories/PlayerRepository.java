package se.ju23.typespeeder.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ju23.typespeeder.data.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{
    Player findByUsernameAndPassword(String username, String password);
}
