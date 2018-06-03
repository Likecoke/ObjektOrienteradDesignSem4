package se.kth.processSale.controller;
/** An exception is thrown to indicate that an external entity servicing the program wasn't available */
public class ServiceNotAvailableException extends Exception{
    /** Create the exception with the given error message
     * @param message Error message */
    public ServiceNotAvailableException(String message, Exception except){
        super(message, except);

    }
}
