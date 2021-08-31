package com.ASM.JAVA6.ServiceImp;

import java.util.List;

import com.ASM.JAVA6.DAO.AccountDAO;
import com.ASM.JAVA6.Model.Accounts;
import com.ASM.JAVA6.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService{

    @Autowired
    AccountDAO accountDAO;

    @Override
    public Accounts findById(String username) {
        return accountDAO.findById(username).get();
    }

    @Override
    public List<Accounts> getAdministrator() {
        
        return accountDAO.getAdministrator();
    }

    @Override
    public List<Accounts> findAll() {
      
        return accountDAO.findAll();
    }
    
}
