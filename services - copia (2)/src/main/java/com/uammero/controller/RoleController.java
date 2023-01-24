package com.uammero.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.uammero.entity.RoleEntity;
import com.uammero.service.RoleService;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    public RoleEntity createNewRole(@RequestBody RoleEntity role) {
        return roleService.createNewRole(role);
    }
}
