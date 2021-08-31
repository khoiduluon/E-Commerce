package com.ASM.JAVA6.Service;

import java.util.List;

import com.ASM.JAVA6.Model.Accounts;

public interface AccountService {
    
    Accounts findById(String username);

    List<Accounts> getAdministrator();

    List<Accounts> findAll();
}
