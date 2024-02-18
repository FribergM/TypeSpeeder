package se.ju23.typespeeder.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

import java.util.Map;

@Entity
public class Level{
    private static final int DEFAULT_LEVEL = 1;
    private static final int DEFAULT_EXP_REQ = 100;
    private static final Map<Integer, Integer> EXP_REQUIREMENTS = Map.of(
            1,150,
            2,200,
            3,300,
            4,0);

    @Id
    @Column(name = "playerId")
    private int id;
    private int level;
    private int exp;
    @Transient
    private int expReq;
    @OneToOne
    @MapsId
    @JoinColumn(name = "playerId")
    private Player player;

    public Level(){
        level = DEFAULT_LEVEL;
        expReq = DEFAULT_EXP_REQ;
    }

    public boolean gainExp(int expGain){
        exp += expGain;
        return updateLevel();
    }

    public void loseExp(int expLoss){
        exp = Math.max(0, (exp - expLoss));
    }

    private boolean updateLevel(){
        int nextLevel = level + 1;
        if(exp <= EXP_REQUIREMENTS.getOrDefault(nextLevel,Integer.MAX_VALUE)){
            level = nextLevel;
            exp = 0;
            expReq = EXP_REQUIREMENTS.getOrDefault(nextLevel,0);
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
