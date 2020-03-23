package com.uncia.springboot.SpringBootThymeLeaf.controller;


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
    public String allRole(Model model) {
        Role editRole = new Role("");
        model.addAttribute("roleList", roleService.getAll());
        model.addAttribute("addRole","");
        model.addAttribute("editRole",editRole);
        return "listRole";
    }

    @GetMapping(value = "/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        roleService.delete(id);
        return "redirect:/listRole";
    }


    @PostMapping(value = "/editRole")
    public String editRole(@ModelAttribute("name-modal") String editRole, @ModelAttribute("id-modal")  String id) {
        Role role = roleService.getById(Integer.parseInt(id));
        role.setRole(editRole);
        roleService.editRole(role);
        return "redirect:/listRole";
    }


    @PostMapping(value = "/addRole")
    public String addRole(@ModelAttribute("role") String roleName) {
        Role role = new Role(roleName);
        roleService.addRole(role);
        return "redirect:/listRole";
    }
}
