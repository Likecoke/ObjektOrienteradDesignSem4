package se.kth.processSale.integration;
/** An exception that is thrown to indicate that a failure occurred in the database.*/
public class DatabaseFailureException extends Exception {
    /** Create the exception with the given error message
     * @param message Error message */
    public DatabaseFailureException(String message){
        super(message);

    }

}

