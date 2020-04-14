package com.uncia.springboot.SpringBootThymeLeaf.controllers;

import com.uncia.springboot.SpringBootThymeLeaf.model.Role;
import com.uncia.springboot.SpringBootThymeLeaf.service.RestRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestRoleController {
    private RestRoleService roleService;

    @Autowired
    public void setRoleService(RestRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/roles")
    public List<Role> allRole() {
        return roleService.getAll();
    }

    @GetMapping("/roles/{roleId}")
    public Role getRole(@PathVariable int roleId) {
        Role role1 = roleService.getById(roleId);
        return role1;
    }

    @PostMapping("/role")
    public Role addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return role;
    }

    @PutMapping("/role")
    public Role updateRole(@RequestBody Role role) {
        roleService.editRole(role);
        return role;
    }

    @DeleteMapping(value = "/role")
    public String deleteRole(@RequestBody int id) {
        roleService.delete(id);
        return "Delete " + id + "role";
    }
}
