package se.ju23.typespeeder.data.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import se.ju23.typespeeder.services.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String alias;
    @OneToOne(mappedBy = "player",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Level level;

    @OneToMany(mappedBy = "player",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Result> resultList;



    public Player(String username, String password, String alias){
        this.username = username;
        this.password = password;
        this.alias = alias;
        this.resultList = new ArrayList<>();
        this.level = new Level();
        this.level.setPlayer(this);
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

    public int getId(){
        return id;
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
    public String lastTenResults(){
        List<Result> results = new ArrayList<>();
        int lastIndex = resultList.size()-1;
        for(int i=0;i<Math.min(10,resultList.size());i++){
            results.add(resultList.get(lastIndex-i));
        }
        return generateSortedLeaderboardString(results, false);
    }
    public String resultsByWpm(){
        List<Result> results = new ArrayList<>(resultList);
        results.sort(Comparator.comparingInt(Result::getWpm).reversed());

        return generateSortedLeaderboardString(results, true);
    }
    public String resultsByAccuracy(){
        List<Result> results = new ArrayList<>(resultList);
        results.sort(Comparator.comparingDouble(Result::getAccuracy).reversed());

        return generateSortedLeaderboardString(results, true);
    }
    public String resultsByStreak(){
        List<Result> results = new ArrayList<>(resultList);
        results.sort(Comparator.comparingInt(Result::getStreak).reversed());

        return generateSortedLeaderboardString(results, true);
    }
    public String resultsByScore(){
        List<Result> results = new ArrayList<>(resultList);
        results.sort(Comparator.comparingDouble(Result::getScore).reversed());

        return generateSortedLeaderboardString(results, true);
    }
    private String generateSortedLeaderboardString(List<Result> results, boolean indexed){
        StringBuilder builder = new StringBuilder();

        if (!results.isEmpty()) {
            int length = results.get(0).toString().length();

            if(!indexed){
                length-=5;
            }

            builder.append("\n").append(Util.getFrameByLength(length));
            for(int i=0;i<Math.min(10,results.size());i++){
                if(indexed){
                    builder.append(String.format("\n| %3s",(i+1)+"."));
                    builder.append(results.get(i));
                }else{
                    builder.append("\n").append(results.get(i));
                }

            }

            builder.append("\n").append(Util.getFrameByLength(length));
        }

        return builder.toString().trim();
    }
}
