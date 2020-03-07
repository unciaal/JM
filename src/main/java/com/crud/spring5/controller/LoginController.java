package com.crud.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showMyLoginPage() {
        return "plain-login";
    }

    @GetMapping(value = "/")
    public String allUser() {
        return "index";
    }

    @GetMapping(value = "/home")
    public String home() {
        return "/generalPages";
    }

}
