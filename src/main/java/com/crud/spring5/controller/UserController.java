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

    @GetMapping(value = "/userHome")
    public String  addPage() {
        return "homeUser";
    }

}
