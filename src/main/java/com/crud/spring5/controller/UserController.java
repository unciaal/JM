package com.crud.spring5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.crud.spring5.model.User;
import com.crud.spring5.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
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
        return "redirect:/";
    }

    @GetMapping(value = "/add")
    public String  addPage() {
        return "editForm";
    }

    @PostMapping(value = "/add")
    public String  addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String  deleteUser(@PathVariable ("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

}
