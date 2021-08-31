package com.ASM.JAVA6.RestController;

import java.util.List;

import com.ASM.JAVA6.Model.Roles;
import com.ASM.JAVA6.Service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
    
    @Autowired
    RoleService roleService;
    
    @GetMapping()
    public List<Roles> getAll(){
        return roleService.findAll();
    }
}
