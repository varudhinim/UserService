package com.auth.userservice.Exception;

public class PasswordInValidException extends RuntimeException{

    public PasswordInValidException(){
        System.out.println("Password In Invalid Exception");
    }
}
