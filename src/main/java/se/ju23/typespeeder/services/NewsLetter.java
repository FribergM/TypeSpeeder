package se.ju23.typespeeder.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NewsLetter{
    public String content;
    public LocalDateTime publishDateTime;

    public NewsLetter(){
        setContent();
        setPublishDateTime();
    }
    private void setContent(){
        content = "Greetings player! The game has finally reached version 1.0.0 and is officially released to Oskar.\n" +
                "I also recently made the Experience penalty for mistakes less punishing on Easy.";
    }

    private void setPublishDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        publishDateTime = LocalDateTime.of(2024,2,23,9,36,20);
        publishDateTime.format(formatter);
    }

    public String getContent(){
        return content;
    }

    public String getPublishDateTime(){
        return publishDateTime.toString().replace('T',' ');
    }
}
