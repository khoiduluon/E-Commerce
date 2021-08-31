package com.ASM.JAVA6.RestController;

import java.util.List;
import java.util.Optional;

import com.ASM.JAVA6.Model.Accounts;
import com.ASM.JAVA6.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
    
    @Autowired
    AccountService accountService;

    @GetMapping()
    public List<Accounts> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
        if(admin.orElse(false)){
            return accountService.getAdministrator();
        }
        return accountService.findAll();
    }
}
