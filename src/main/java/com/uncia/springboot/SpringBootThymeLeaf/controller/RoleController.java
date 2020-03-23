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
        model.addAttribute("roleList", roleService.getAll());
        model.addAttribute("addRole","");
        return "listRole";
    }

    @GetMapping(value = "/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") int id) {
        roleService.delete(id);
        return "redirect:/listRole";
    }

    @GetMapping(value = "/editRole/{id}")
    public String editPage(@PathVariable("id") int id, Model model) {
        Role role = roleService.getById(id);
        model.addAttribute("editRole",role);
        model.addAttribute("roleList", roleService.getAll());
        return "listRole";
    }



    @PostMapping(value = "/editRole")
    public String editRole(@ModelAttribute("role") Role role) {
        roleService.editRole(role);
        return "redirect:/listRole";
    }

    @PostMapping(value = "/newRole")
    public String addPage() {
        return "redirect:/listRole";
    }

    @GetMapping(value = "/addRole")
    public String addRole(Model model) {
        String roleName = "";
        model.addAttribute("addRole",roleName);
        model.addAttribute("roleList", roleService.getAll());
        return "listRole";
    }

    @PostMapping(value = "/addRole")
    public String addRole(@ModelAttribute("role") String roleName) {
        Role role = new Role(roleName);
        roleService.addRole(role);
        return "redirect:/listRole";
    }
}
