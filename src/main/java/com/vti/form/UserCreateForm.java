package com.vti.form;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserCreateForm {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
}
