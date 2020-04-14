package com.uncia.springboot.SpringBootThymeLeaf.config;


import com.uncia.springboot.SpringBootThymeLeaf.model.Role;
import com.uncia.springboot.SpringBootThymeLeaf.model.User;
import com.uncia.springboot.SpringBootThymeLeaf.service.RoleService;
import com.uncia.springboot.SpringBootThymeLeaf.service.UserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {


    private final UserService userService;
    private final RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        Role roleAdmin = new Role();
        Role roleUser = new Role();
        roleAdmin.setRole("ROLE_ADMIN");
        roleUser.setRole("ROLE_USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        User userAdmin = new User
                ("Konstantin", "a", "a", "a_mail@am.com", new String[]{"ROLE_ADMIN"});
        userAdmin.setPassword(passwordEncoder.encode(userAdmin.getPassword()));
        userService.add(userAdmin);
        userAdmin.getRoles().add(roleAdmin);
        userService.edit(userAdmin);

        User userUser = new User
                ("Stepan", "s", "s", "s_mail@am.com", new String[]{"ROLE_USER"});
        userUser.setPassword(passwordEncoder.encode(userUser.getPassword()));
        userService.add(userUser);
        userUser.getRoles().add(roleUser);
        userService.edit(userUser);
    }
}
