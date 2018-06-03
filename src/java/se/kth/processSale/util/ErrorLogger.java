package se.kth.processSale.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class ErrorLogger{
    private static final String DESTINATION_FILE = "processSale-log.txt";
    private PrintWriter logger;
    private CurrentTimeGenerator timeGenerator;
    public ErrorLogger(CurrentTimeGenerator timeGenerator) throws IOException{
        logger = new PrintWriter(new FileWriter(DESTINATION_FILE, true), true);
        this.timeGenerator = timeGenerator;

    }
    public void logException(Exception exc){
        String printout = "######Printout to log#########\n"+
                timeGenerator.generateCurrentTime()+"\n"+
                "Exception thrown:  "+

                exc.getMessage()+"\n";
        logger.println(printout);
        exc.printStackTrace(logger);
    }



}
