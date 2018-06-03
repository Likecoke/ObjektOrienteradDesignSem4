package se.kth.processSale.util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/** Writes errors that have occurred during program execution to an external log, which can be checked by developers*/
public class ErrorLogger{
    private static final String DESTINATION_FILE = "processSale-log.txt";
    private PrintWriter logger;
    private CurrentTimeGenerator timeGenerator;
    /** Initialize the ErrorLogger passing it a CurrentTimeGenerator
     * @param timeGenerator Used to get the time and generate a formatted string
     * @throws IOException The file couldn't be opened */
    public ErrorLogger(CurrentTimeGenerator timeGenerator) throws IOException{
        logger = new PrintWriter(new FileWriter(DESTINATION_FILE, true), true);
        this.timeGenerator = timeGenerator;

    }

    /** The given exception is written to the file
     * @param exc The exception that should be written to the file */
    public void logException(Exception exc){
        String printout = "######Printout to log#########\n"+
                timeGenerator.generateCurrentTime()+"\n"+
                "Exception thrown:  "+

                exc.getMessage()+"\n";
        logger.println(printout);
        exc.printStackTrace(logger);
    }



}
