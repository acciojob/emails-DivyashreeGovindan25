package com.driver;

public class PasswordDoesntMatchWithOldPassword extends RuntimeException{
    public PasswordDoesntMatchWithOldPassword(String message){
        super(message);
    }
}
