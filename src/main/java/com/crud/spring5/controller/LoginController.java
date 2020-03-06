package com.crud.spring5.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

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
