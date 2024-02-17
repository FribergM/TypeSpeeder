package se.ju23.typespeeder.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.Map;

@Entity
public class Level{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int exp;
    @Transient
    private int expReq;

    private static final int DEFAULT_LEVEL = 1;
    private static final int DEFAULT_EXP_REQ = 100;
    private static final Map<Integer, Integer> EXP_REQUIREMENTS = Map.of(
            1,150,
            2,200,
            3,300,
            4,0);

    public Level(){
        id = DEFAULT_LEVEL;
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
        int nextLevel = id + 1;
        if(exp <= EXP_REQUIREMENTS.getOrDefault(nextLevel,Integer.MAX_VALUE)){
            id = nextLevel;
            exp = 0;
            expReq = EXP_REQUIREMENTS.getOrDefault(nextLevel,0);
            return true;
        }
        return false;
    }

    public int getLevel(){
        return id;
    }

    public int getExp(){
        return exp;
    }

    public int getExpReq(){
        return expReq;
    }
}
