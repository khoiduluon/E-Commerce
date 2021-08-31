package com.ASM.JAVA6.DAO;

import java.util.List;

import com.ASM.JAVA6.Model.Accounts;
import com.ASM.JAVA6.Model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesDAO extends JpaRepository<Authorities,Integer>{
    
    @Query("SELECT DISTINCT a FROM Authorities a WHERE a.username IN ?1")
    List<Authorities> authoritiesOf(List<Accounts> accounts);
}
