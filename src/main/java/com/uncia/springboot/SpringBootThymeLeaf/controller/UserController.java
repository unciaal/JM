package com.uncia.springboot.SpringBootThymeLeaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/userHome")
    public String homeUser() {
        return "homeUser";
    }

}
