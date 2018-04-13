package com.service.impl;

import com.common.entity.Order;
import com.common.entity.OrderDetail;
import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import com.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderDetailDao orderDetailDao;

    @Override
    public Integer saveOrder(Order order) {
        return orderDao.saveOrder(order);
    }

    @Override
    public Integer saveOrderDetail(List<OrderDetail> orderDetails){
        return orderDetailDao.saveOrderDetail(orderDetails);
    }

    @Override
    public List<Order> selectOrder(Order order) {
        return orderDao.selectOrder(order);
    }

    @Override
    public List<OrderDetail> selectOrderDetail(Long orderId) {
        return orderDetailDao.selectOrderDetail(orderId);
    }

    @Override
    public Integer updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }
}
