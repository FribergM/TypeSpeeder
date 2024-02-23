package se.ju23.typespeeder.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patch{
    public String patchVersion;
    public LocalDateTime releaseDateTime;

    public Patch(){
        setPatchVersion();
        setReleaseDateTime();
    }
    private void setPatchVersion(){
        patchVersion = "Version: 1.0.0";
    }
    private void setReleaseDateTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        releaseDateTime = LocalDateTime.of(2024,2,23,9,36,20);
        releaseDateTime.format(formatter);
    }

    public String getPatchVersion(){
        return patchVersion;
    }

    public String getReleaseDateTime(){
        return releaseDateTime.toString().replace('T',' ');
    }
}
