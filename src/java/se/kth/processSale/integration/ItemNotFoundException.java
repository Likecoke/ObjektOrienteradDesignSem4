package se.kth.processSale.integration;
/** An exception that is thrown to indicate that a searched for item couldn't be found in the <Code>ProductCatalogue</Code> */
public class ItemNotFoundException extends Exception {
    /** Create the exception with the given error message
     * @param message Error message */
    public ItemNotFoundException(String message){
        super(message);

    }

}
