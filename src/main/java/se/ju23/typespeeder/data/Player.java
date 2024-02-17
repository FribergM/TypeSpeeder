package se.ju23.typespeeder.data;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    private long id;
    private String username;
    private String password;
    private String alias;
    @OneToOne
    private Level level;

    @OneToMany(mappedBy = "player",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Result> resultList;

    public Player(String username, String password, String alias){
        this.username = username;
        this.password = password;
        this.alias = alias;
        this.resultList = new ArrayList<>();
        this.level = new Level();
    }
    public Player(){

    }
    public boolean gainExp(int expGain){
        return level.gainExp(expGain);
    }
    public void loseExp(int expLoss){
        level.loseExp(expLoss);
    }

    public void addResult(Result result){
        result.setPlayer(this);
        resultList.add(result);

    }

    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setAlias(String alias){
        this.alias = alias;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getAlias(){
        return alias;
    }
    public int getLevel(){
        return level.getLevel();
    }
    public int getExp(){
        return level.getExp();
    }
    public int getExpReq(){
        return level.getExpReq();
    }
    public List<Result> getResultList(){
        return resultList;
    }

    @Override
    public String toString(){
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", alias='" + alias + '\'' +
                ", resultList=" + resultList +
                '}';
    }
}
