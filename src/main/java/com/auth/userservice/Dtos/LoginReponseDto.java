package com.auth.userservice.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoginReponseDto {
    private String email;
    private String tokenValue;
    private Date ExpireAt;

}
