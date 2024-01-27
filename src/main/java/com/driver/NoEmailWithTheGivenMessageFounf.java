package com.driver;

public class NoEmailWithTheGivenMessageFounf extends RuntimeException{
    public NoEmailWithTheGivenMessageFounf(String message){
        super("No email found with message " + message);
    }
}
