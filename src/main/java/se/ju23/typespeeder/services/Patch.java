package se.ju23.typespeeder.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patch{
    public String patchVersion;
    public LocalDateTime releaseDateTime;

    public Patch(){
        setPatchValues();
    }
    private void setPatchValues(){
        patchVersion = "Version: 1.0.0";
        String releaseDate = "2024-02-23 09:36:20";
        formatReleaseDateTime(releaseDate);
    }

    private void formatReleaseDateTime(String releaseDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        releaseDateTime = LocalDateTime.parse(releaseDate,formatter);
    }

    public String getPatchVersion(){
        return patchVersion;
    }

    public String getReleaseDateTime(){
        return releaseDateTime.toString().replace('T',' ');
    }
}
