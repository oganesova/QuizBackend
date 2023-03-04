package com.quizz.quizPortal.controller;

import com.quizz.quizPortal.entity.Role;
import com.quizz.quizPortal.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/save")
    public Role saveRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }
}
