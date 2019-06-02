package se.kth.pos2.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A class that gets the current time and date.
 */
public class CurrentTimeAndDate {
    /**
     * getter method for the current time and date.
     * @return the time and date as a string.
     */
    public String getTimeAndDate(){
        return setTimeAndDate();
    }
    private String setTimeAndDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
