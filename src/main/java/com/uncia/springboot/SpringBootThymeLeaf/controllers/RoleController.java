package com.uncia.springboot.SpringBootThymeLeaf.controllers;


import com.uncia.springboot.SpringBootThymeLeaf.model.Role;
import com.uncia.springboot.SpringBootThymeLeaf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoleController {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/listRole")
    public String allRole() {

        return "listRole";
    }




    @PostMapping(value = "/editRole")
    public String editRole(@ModelAttribute("name-modal") String editRole, @ModelAttribute("id-modal")  String id) {
/*        Role role = roleService.getById(Integer.parseInt(id));
        role.setRole(editRole);
        roleService.editRole(role);*/
        return "redirect:/listRole";
    }


    @PostMapping(value = "/addRole")
    public String addRole(@ModelAttribute("role") String roleName) {
        Role role = new Role(roleName);
        roleService.addRole(role);
        return "redirect:/listRole";
    }
}
