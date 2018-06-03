package se.kth.processSale.view;

import se.kth.processSale.util.CurrentTimeGenerator;


public class DisplayError{
    private  CurrentTimeGenerator timeGenerator;


    public DisplayError(CurrentTimeGenerator timeGenerator){
        this.timeGenerator = timeGenerator;

    }

    public void showErrorMessage(String errorInformation){
        String  errorMsg= timeGenerator.generateCurrentTime() +
                ", Error occurred: \n" + errorInformation;
        System.out.println(errorMsg);
    }




}
