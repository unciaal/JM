package com.uncia.springboot.SpringBootThymeLeaf.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping(value = "/adminHome")
    public String allUser(Model model) {
        return "listUser";
    }
}
