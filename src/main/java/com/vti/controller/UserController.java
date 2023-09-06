package com.vti.controller;

import com.vti.dto.UserDto;
import com.vti.form.UserCreateForm;
import com.vti.form.UserUpdateForm;
import com.vti.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private IUserService service;

    @PostMapping("/register")
    public void register(@RequestBody UserCreateForm form){
        service.register(form);
    }

    @GetMapping("/login")
    public UserDto login(Principal principal){
       return service.login(principal);
    }

    @PutMapping("/update")
    public void update(UserUpdateForm form){
        service.update(form);
    }


}
