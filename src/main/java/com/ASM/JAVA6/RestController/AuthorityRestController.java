package com.ASM.JAVA6.RestController;

import java.util.List;
import java.util.Optional;

import com.ASM.JAVA6.Model.Authorities;
import com.ASM.JAVA6.Service.AuthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {
    
    @Autowired
    AuthorityService  authorityService;

    @GetMapping()
    public List<Authorities> findAll(@RequestParam("admin") Optional<Boolean> admin){
        if(admin.orElse(false)){
            return authorityService.findAuthoritiesOfAdministrators();
        }
        return authorityService.findAll();
    }

    @PostMapping()
    public Authorities post(@RequestBody Authorities auth){
        return authorityService.create(auth);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        authorityService.delete(id);
    }
}
