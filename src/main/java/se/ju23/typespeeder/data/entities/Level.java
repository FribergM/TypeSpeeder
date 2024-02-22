package se.ju23.typespeeder.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.util.Map;

@Entity
public class Level{
    private static final int DEFAULT_LEVEL = 1;
    private static final Map<Integer, Integer> EXP_REQUIREMENTS = Map.of(
            1,400,
            2,1000,
            3,2500,
            4,5000);

    @Id
    @Column(name = "playerId")
    private int id;
    private int level;
    private int exp;
    private int expReq;
    @OneToOne
    @MapsId
    @JoinColumn(name = "playerId")
    private Player player;

    public Level(){
        level = DEFAULT_LEVEL;
        expReq = EXP_REQUIREMENTS.getOrDefault(level,0);
    }

    public boolean gainExp(int expGain){
        exp += expGain;
        return updateLevel();
    }

    public void loseExp(int expLoss){
        exp = Math.max(0, (exp + expLoss));
    }

    private boolean updateLevel(){
        if(exp >= expReq){
            level++;
            exp -= expReq;
            expReq = EXP_REQUIREMENTS.getOrDefault(level,0);
            return true;
        }
        return false;
    }

    public int getLevel(){
        return level;
    }
    public int getExp(){
        return exp;
    }
    public int getExpReq(){
        return expReq;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
}
