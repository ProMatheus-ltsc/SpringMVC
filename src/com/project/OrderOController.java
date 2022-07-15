package com.project;

import org.springmvc.RequestMapping;
import org.springmvc.RestController;

@RestController
public class OrderOController {
    @RequestMapping("/getOrder")
    public OrderEntity getOrder(){
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(80);
        entity.setTotal(10000);
        return entity;
    }
}
