package com.vti.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateForm {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String email;
    private String phone;
}
