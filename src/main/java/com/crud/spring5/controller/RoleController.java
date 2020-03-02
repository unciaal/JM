package com.crud.spring5.controller;

import com.crud.spring5.model.Role;
import com.crud.spring5.service.RoleService;
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
        model.addAttribute("roleList", roleService.getAll());
        return "listRole";
    }

    @PostMapping(value = "/deleteRole")
    public String deleteRole(@ModelAttribute("id") Integer id) {
        roleService.delete(id);
        return "redirect:/listRole";
    }
    @GetMapping(value = "/editRole/{id}$newRole")
    public String editPage(@PathVariable("id") int id, @PathVariable String newRole) {
        Role role = roleService.getById(id);
        role.setRole(newRole);
        roleService.editRole(role);
        return "redirect:/listRole";
    }
    @PostMapping(value = "/editRole")
    public String editRole(@ModelAttribute("role") Role role) {
        roleService.editRole(role);
        return "redirect:/listRole";
    }

    @PostMapping(value = "/newRole")
    public String addPage(Model model) {
        model.addAttribute("newRole", true);
        return "redirect:/listRole";
    }

    @PostMapping(value = "/addRole")
    public String addRole(@ModelAttribute("role") Role role) {
        roleService.addRole(role);
        return "redirect:/listRole";
    }

}
