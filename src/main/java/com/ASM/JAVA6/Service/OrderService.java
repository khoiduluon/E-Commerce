package com.ASM.JAVA6.Service;

import java.util.List;

import com.ASM.JAVA6.Model.Orders;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {

    Orders create(JsonNode orderData);

    Orders findById(Integer id);

    List<Orders> findByUsername(String username);
    
}
