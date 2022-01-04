package com.leoamorimr.security;

import com.leoamorimr.security.domain.Role;
import com.leoamorimr.security.domain.User;
import com.leoamorimr.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Leonardo", "leoamorimr", "123", new ArrayList<>()));
            userService.saveUser(new User(null, "Thayse", "thaygc", "123", new ArrayList<>()));

            userService.addRoleToUser("leoamorimr", "ROLE_ADMIN");
            userService.addRoleToUser("thaygc", "ROLE_MANAGER");
        };
    }
}
