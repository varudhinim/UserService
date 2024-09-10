package com.auth.userservice.Controllers;

import com.auth.userservice.Dtos.*;
import com.auth.userservice.Models.Token;
import com.auth.userservice.Models.User;
import com.auth.userservice.Services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")// localhost:8080/users
public class UserController {
    private UserService userService;

    private UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/signUp")
    public SignUpResponceDto signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        String name = signUpRequestDto.getName();
        String email = signUpRequestDto.getEmail();
        String password = signUpRequestDto.getPassword();
        SignUpResponceDto signUpResponceDto = new SignUpResponceDto();
        try{
            User user = userService.signUp(name, email, password);
            signUpResponceDto.setName(user.getName());
            signUpResponceDto.setEmail(user.getEmail());
            signUpResponceDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            signUpResponceDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signUpResponceDto;
    }

    @PostMapping("/login")
    public LoginReponseDto Login(@RequestBody LoginRequestDto loginRequestDto ){

        Token token = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        LoginReponseDto loginResponceDto = new LoginReponseDto();
        loginResponceDto.setEmail(token.getUser().getEmail());
        loginResponceDto.setExpireAt(token.getExpireAt());
        loginResponceDto.setTokenValue(token.getValue());

        return loginResponceDto;
    }
//    @PostMapping("/validate")
//    public UserDto validate(String token ){
//
//        return user;
//    }
}
