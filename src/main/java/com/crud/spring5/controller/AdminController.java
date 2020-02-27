package com.crud.spring5.controller;

import com.crud.spring5.model.User;
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

@Controller
public class AdminController {
    private UserService userService;

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
    public String  editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("user",userService.getById(id));
        return "editForm";
    }

    @PostMapping(value = "/edit")
    public String  editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/adminHome";
    }

    @GetMapping(value = "/add")
    public String  addPage() {
        return "editForm";
    }

    @PostMapping(value = "/add")
    public String  addUser(@ModelAttribute("user") User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String pas = passwordEncoder.encode(user.getPassword());
        user.setPassword(pas);
        userService.add(user);
        return "redirect:/adminHome";
    }

    @GetMapping(value = "/delete/{id}")
    public String  deleteUser(@PathVariable ("id") int id) {
        userService.delete(id);
        return "redirect:/adminHome";
    }
}
