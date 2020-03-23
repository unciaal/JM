package com.uncia.springboot.SpringBootThymeLeaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showMyLoginPage() {
        return "loginPage";
    }

    @GetMapping(value = "/")
    public String allUser(Model model) {
        model.addAttribute("theDate", new java.util.Date() );
        return "index";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "/generalPages";
    }

}
