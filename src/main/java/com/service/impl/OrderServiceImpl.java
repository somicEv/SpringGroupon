package com.service.impl;

import com.common.entity.Order;
import com.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderService orderService;

    @Override
    public Integer insertOrderSelective(Order order) {
        return orderService.insertOrderSelective(order);
    }
}
