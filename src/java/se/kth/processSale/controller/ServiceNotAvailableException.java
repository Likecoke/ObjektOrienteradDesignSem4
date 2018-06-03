package se.kth.processSale.controller;

public class ServiceNotAvailableException extends Exception{

    public ServiceNotAvailableException(String message, Exception except){
        super(message, except);

    }
}
