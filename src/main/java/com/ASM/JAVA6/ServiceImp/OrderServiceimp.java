package com.ASM.JAVA6.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import com.ASM.JAVA6.DAO.OrderDetailsDAO;
import com.ASM.JAVA6.DAO.OrdersDAO;
import com.ASM.JAVA6.Model.Orderdetails;
import com.ASM.JAVA6.Model.Orders;
import com.ASM.JAVA6.Service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class OrderServiceimp implements OrderService{

    @Autowired
    OrdersDAO orderDAO;

    @Autowired
    OrderDetailsDAO orderDetailsDAO;

    @Override
    public Orders create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        
        Orders order = mapper.convertValue(orderData, Orders.class);
        orderDAO.save(order);

        TypeReference<List<Orderdetails>> type = new TypeReference<List<Orderdetails>>(){};
        List<Orderdetails> details = mapper.convertValue(orderData.get("orderDetails"), type)
        .stream().peek(d -> d.setOrder_id(order)).collect(Collectors.toList());
        orderDetailsDAO.saveAll(details);
        return order;
    }

    @Override
    public Orders findById(Integer id) {
        return orderDAO.findById(id).get();
    }

    @Override
    public List<Orders> findByUsername(String username) {
        return orderDAO.findByUsername(username);
    }
    
}
