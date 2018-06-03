package se.kth.processSale.controller;
/** Indicates that there was a problem when executing the operation.
 */
public class OperationErrorException extends Exception{
    /** Create the exception with the given error message
     * @param message Error message */
    public OperationErrorException(String message, Exception except){
        super(message, except);

    }


}
