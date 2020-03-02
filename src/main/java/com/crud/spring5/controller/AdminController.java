package com.crud.spring5.controller;

import com.crud.spring5.model.Role;
import com.crud.spring5.model.User;
import com.crud.spring5.service.RoleService;
import com.crud.spring5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AdminController {
    private UserService userService;

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/adminHome")
    public String allUser(Model model) {
        model.addAttribute("userList", userService.allUsers());

        return "listUser";
    }


    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        User user = userService.getById(id);
        Set<Role> role = user.getRoles();

        model.addAttribute("user",user);
        model.addAttribute("role", role);
        model.addAttribute("roles", roleService.getAll());
        return "editForm";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user,@ModelAttribute("role") Role role) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String pas = passwordEncoder.encode(user.getPassword());
        user.setPassword(pas);
        userService.edit(user);
        role.getUsers().add(user);
        roleService.editRole(role);
       //user.getRoles().add(role);






        return "redirect:/adminHome";
    }

    @GetMapping(value = "/add")
    public String addPage(Model model) {
        model.addAttribute("roles", roleService.getAll());
        return "editForm";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String pas = passwordEncoder.encode(user.getPassword());
        user.setPassword(pas);
        userService.add(user);
        return "redirect:/adminHome";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/adminHome";
    }
}
