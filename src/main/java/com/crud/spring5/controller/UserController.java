package com.crud.spring5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/userHome")
    public String homeUser() {
        return "homeUser";
    }

}
