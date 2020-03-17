package com.uncia.springboot.SpringBootThymeLeaf.controller;


import com.uncia.springboot.SpringBootThymeLeaf.model.Role;
import com.uncia.springboot.SpringBootThymeLeaf.model.User;
import com.uncia.springboot.SpringBootThymeLeaf.service.RoleService;
import com.uncia.springboot.SpringBootThymeLeaf.service.UserService;
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

    private RoleService roleService;


    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

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
    public String editPage(@PathVariable("id") int id, Model model) {
        User user = userService.getById(id);
        String login = user.getLogin();
        User user1 = userService.getByLoginWihtRoles(login);
        model.addAttribute("user", user1);
        model.addAttribute("troles", roleService.getAll());
        return "editForm";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        for (String idRole : user.getStrIdRoles()) {
            Role role = roleService.getById(Integer.parseInt(idRole));
            user.getRoles().add(role);
        }
        userService.edit(user);

        return "redirect:/adminHome";
    }

    @GetMapping(value = "/add")
    public String addPage(Model model) {
        model.addAttribute("troles", roleService.getAll());
        model.addAttribute("user", new User("", "", "", "", new String[]{""}));
        return "editForm";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user);
        for (String idRole : user.getStrIdRoles()) {
            Role role = roleService.getById(Integer.parseInt(idRole));
            user.getRoles().add(role);
        }
        userService.edit(user);
        return "redirect:/adminHome";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/adminHome";
    }
}
