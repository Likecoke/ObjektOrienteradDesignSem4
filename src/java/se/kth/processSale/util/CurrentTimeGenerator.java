package se.kth.processSale.util;

import java.time.ZonedDateTime;

public class CurrentTimeGenerator {

    public String generateCurrentTime(){
        ZonedDateTime currentTime =  ZonedDateTime.now();
        String formattedTime =   Integer.toString(currentTime.getYear()) + "-"+
                padExtraZeroIfNeeded(currentTime.getMonthValue()) +"-"+ padExtraZeroIfNeeded(currentTime.getDayOfMonth())+" "+
                padExtraZeroIfNeeded(currentTime.getHour()) + ":"+padExtraZeroIfNeeded(currentTime.getMinute())+
                ":"+ padExtraZeroIfNeeded(currentTime.getSecond());

        return formattedTime;

    }
    private String padExtraZeroIfNeeded(int number){
        if(number < 10){
            return "0"+number;
        }
        else{
            return Integer.toString(number);
        }


    }

}
