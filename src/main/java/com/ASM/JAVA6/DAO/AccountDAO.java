package com.ASM.JAVA6.DAO;




import java.util.List;

import com.ASM.JAVA6.Model.Accounts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<Accounts, String>{
    
    @Query("SELECT DISTINCT ar.username FROM Authorities ar WHERE ar.roleid.roleId IN ('DIRE','STAF')")
    List<Accounts> getAdministrator();
}
