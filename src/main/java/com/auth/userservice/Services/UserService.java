package com.auth.userservice.Services;

import com.auth.userservice.Config.BcryptPassCodeEncoder;
import com.auth.userservice.Exception.PasswordInValidException;
import com.auth.userservice.Exception.UserNotFoundException;
import com.auth.userservice.Models.Token;
import com.auth.userservice.Models.User;
import com.auth.userservice.Repository.TokenRepository;
import com.auth.userservice.Repository.UserRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {

    private BCryptPasswordEncoder bcryencoder;
    private UserRepo userRepo;
    private TokenRepository tokenRepo;

    private UserService(BCryptPasswordEncoder bcryptencoder, UserRepo userRepo, TokenRepository tokenRepo ){
    this.bcryencoder = bcryptencoder;
    this.userRepo = userRepo;
    this.tokenRepo = tokenRepo;
    }

    public User signUp(String name, String email, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedpasword(bcryencoder.encode(password));

        userRepo.save(user);
        return user;
    }

    public Token login(String email, String password){

        Optional<User> optionalUser = userRepo.findByEmail(email);
        if(optionalUser.isEmpty()){
            new UserNotFoundException();
        }
//        bcryencoder.encode(password)  optionalUser.get().getHashedpasword();

        if(!bcryencoder.matches(password, optionalUser.get().getHashedpasword())){
            new PasswordInValidException();
        }


        // bussiness logic for issue a token
        LocalDate currentDate = LocalDate.now();
        LocalDate expireDate = currentDate.plusDays(30);

        Date expireDateSetwithDate = Date.from(expireDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Token token = new Token();
        token.setExpireAt(expireDateSetwithDate);
        token.setUser(optionalUser.get());
        // combination of JWT
        token.setValue(RandomStringUtils.randomAlphanumeric(128));
        Token savedToken = tokenRepo.save(token);
        return savedToken;
    }



//    public User validatreToken(String token){
//
//    }
}
