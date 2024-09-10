package com.auth.userservice.Exception;

public class UserNotFoundException extends RuntimeException {


    public UserNotFoundException() {
        System.out.println("User not found");
    }
}
