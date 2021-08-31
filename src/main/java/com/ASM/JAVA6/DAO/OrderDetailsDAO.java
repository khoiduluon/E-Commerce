package com.ASM.JAVA6.DAO;





import com.ASM.JAVA6.Model.Orderdetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<Orderdetails, Integer>{
    
}
