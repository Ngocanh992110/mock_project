package com.vti.service;

import com.vti.dto.UserDto;
import com.vti.form.UserCreateForm;
import com.vti.form.UserUpdateForm;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.security.Principal;

public interface IUserService extends UserDetailsService {
    void register(UserCreateForm form);
    UserDto login(Principal principal);
    void update(UserUpdateForm form);

}
