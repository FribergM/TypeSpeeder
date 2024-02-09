package se.ju23.typespeeder.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;
    String password;
    String alias;

    @OneToMany
    List<Result> resultList;

    public Player(String username, String password, String alias){
        this.username = username;
        this.password = password;
        this.alias = alias;
        this.resultList = new ArrayList<>();
    }
    public Player(){

    }
}
