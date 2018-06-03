package se.kth.processSale.util;

import java.time.ZonedDateTime;
/** Used to generate the current date and time as a string
 */
public class CurrentTimeGenerator {
    /** Generate a formatted string with information about the current date and time
     * @return The formatted string with information about current time and date
     */
    public String generateCurrentTime(){
        ZonedDateTime currentTime =  ZonedDateTime.now();
        String formattedTime =   Integer.toString(currentTime.getYear()) + "-"+
                padExtraZeroIfNeeded(currentTime.getMonthValue()) +"-"+ padExtraZeroIfNeeded(currentTime.getDayOfMonth())+" "+
                padExtraZeroIfNeeded(currentTime.getHour()) + ":"+padExtraZeroIfNeeded(currentTime.getMinute())+
                ":"+ padExtraZeroIfNeeded(currentTime.getSecond());

        return formattedTime;

    }
    /**Used to pad numbers such as the curreent day so that it always is written using two digits
     * @param number the number that might need padding
     * @return The number as a string, padded if necessary
     */
    private String padExtraZeroIfNeeded(int number){
        if(number < 10){
            return "0"+number;
        }
        else{
            return Integer.toString(number);
        }


    }

}
