package com.auth.userservice.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponceDto {
    private String name;
    private String email;
    private ResponseStatus responseStatus;

}
