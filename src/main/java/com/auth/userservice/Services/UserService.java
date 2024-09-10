package com.auth.userservice.Services;

import com.auth.userservice.Config.BcryptPassCodeEncoder;
import com.auth.userservice.Models.User;
import com.auth.userservice.Repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private BCryptPasswordEncoder bcryencoder;
    private UserRepo userRepo;

    private UserService(BCryptPasswordEncoder bcryptencoder, UserRepo userRepo){
    this.bcryencoder = bcryptencoder;
    this.userRepo = userRepo;
    }

    public User signUp(String name, String email, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedpasword(bcryencoder.encode(password));

        userRepo.save(user);
        return user;
    }

//    public User validatreToken(String token){
//
//    }
}
