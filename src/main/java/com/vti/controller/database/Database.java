package com.vti.controller.database;

import com.vti.model.User;
import com.vti.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {

    @Bean
    CommandLineRunner initDatebase(IUserRepository repository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                if(repository.findAll().size() == 0){
                    User userAdmin = new User();
                    userAdmin.setId(1000);
                    userAdmin.setFirstName("Admin");
                    userAdmin.setLastName("Account");
                    userAdmin.setUsername("Admin");
                    userAdmin.setRole(User.Role.ROLE_ADMIN);
                    userAdmin.setEmail("admin@gmail.com");
                    userAdmin.setPassword("12345678");
                }
            }
        };
    }
}
