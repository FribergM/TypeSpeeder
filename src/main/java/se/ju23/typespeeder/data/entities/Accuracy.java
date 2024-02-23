package se.ju23.typespeeder.data.entities;

public class Accuracy{
    private double percentage;
    private int streak;

    public Accuracy(double percentage, int streak){
        this.percentage = percentage;
        this.streak = streak;
    }

    public double getPercentage(){
        return percentage;
    }

    public int getStreak(){
        return streak;
    }
}
