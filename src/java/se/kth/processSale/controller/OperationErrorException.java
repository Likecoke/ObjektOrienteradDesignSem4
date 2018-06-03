package se.kth.processSale.controller;

public class OperationErrorException extends Exception{

    public OperationErrorException(String message, Exception except){
        super(message, except);

    }


}
