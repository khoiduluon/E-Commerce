package com.ASM.JAVA6.ServiceImp;

import java.util.List;

import com.ASM.JAVA6.DAO.RolesDAO;
import com.ASM.JAVA6.Model.Roles;
import com.ASM.JAVA6.Service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService{

    @Autowired
    RolesDAO rolesDAO;

    @Override
    public List<Roles> findAll() {
        return rolesDAO.findAll();
    }
    
}
