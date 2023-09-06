package com.vti.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String email;
    private String phone;
    private String role;
}
