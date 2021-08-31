package com.ASM.JAVA6.DAO;

import java.util.List;

import com.ASM.JAVA6.Model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersDAO extends JpaRepository<Orders, Integer>{


    @Query("SELECT o FROM Orders o WHERE o.account.username =?1")
    List<Orders> findByUsername(String username);
    
}
