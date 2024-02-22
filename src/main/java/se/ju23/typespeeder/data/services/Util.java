package se.ju23.typespeeder.data.services;

public class Util{
    public static String centerText(String s, int width) {
        int totalPadding = width - s.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        return String.format("%" + leftPadding + "s%s%" + rightPadding + "s", "", s, "");
    }
    public static String getFrameByLength(int length){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<length+5;i++){
            builder.append("-");
        }
        return builder.toString();
    }
}
