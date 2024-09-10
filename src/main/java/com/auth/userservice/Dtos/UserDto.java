package com.auth.userservice.Dtos;

import com.auth.userservice.Models.Role;

import java.util.List;

public class UserDto {
    private String name;
    private String email;
    private List<Role> roles;
}
