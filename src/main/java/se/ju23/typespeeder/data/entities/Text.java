package se.ju23.typespeeder.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Text{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(columnDefinition = "TEXT")
    String text;
    int difficulty;
    @Column(columnDefinition = "BOOLEAN")
    boolean language;

    public String getText(){
        return text;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public boolean getLanguage(){
        return language;
    }
}
