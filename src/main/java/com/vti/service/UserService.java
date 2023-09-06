package com.vti.service;

import com.vti.dto.UserDto;
import com.vti.form.UserCreateForm;
import com.vti.form.UserUpdateForm;
import com.vti.model.User;
import com.vti.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.security.Principal;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder encoder;


    @Override
    public void register(UserCreateForm form) {
        User user = mapper.map(form, User.class);
        String encodedPassword = encoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        repository.save(user);
    }

    @Override
    public UserDto login(Principal principal) {
        User user = repository.findByUsername(principal.getName());
        return mapper.map(user, UserDto.class);
    }

    @Override
    public void update(UserUpdateForm form) {
        User user = mapper.map(form, User.class);
        String encodedPassword = encoder.encode(form.getPassword());
        user.setPassword(encodedPassword);
        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole().toString())
        );

    }
}
