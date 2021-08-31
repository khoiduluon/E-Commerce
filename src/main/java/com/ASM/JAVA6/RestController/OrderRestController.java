package com.ASM.JAVA6.RestController;

import com.ASM.JAVA6.Model.Orders;
import com.ASM.JAVA6.Service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public Orders create(@RequestBody JsonNode orderData){
        return orderService.create(orderData);
    }
}
