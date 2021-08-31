package com.ASM.JAVA6.DAO;

import com.ASM.JAVA6.Model.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDAO extends JpaRepository<Roles, Integer>{
    
}
