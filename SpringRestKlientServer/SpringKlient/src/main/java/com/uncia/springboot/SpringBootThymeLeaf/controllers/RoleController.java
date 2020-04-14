package com.uncia.springboot.SpringBootThymeLeaf.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {


    @GetMapping(value = "/listRole")
    public String allRole() {

        return "listRole";
    }

}
