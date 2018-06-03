package se.kth.processSale.view;

import se.kth.processSale.util.CurrentTimeGenerator;

/** This class is responsible for displaying information about errors to the user */

public class DisplayError{
    private  CurrentTimeGenerator timeGenerator;

    /** Initialize the class giving it a CurrentTimeGenerator
     * @param timeGenerator Used to get the time and generate a formatted string  */

    public DisplayError(CurrentTimeGenerator timeGenerator){
        this.timeGenerator = timeGenerator;

    }

    /** Displays information about a given error to the user. The information is written to standard out.
     * @param errorInformation The error message that should be displayed  */
    public void showErrorMessage(String errorInformation){
        String  errorMsg= timeGenerator.generateCurrentTime() +
                ", Error occurred: \n" + errorInformation;
        System.out.println(errorMsg);
    }




}
