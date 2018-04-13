package com.service.api;

import com.common.entity.Order;
import com.common.entity.OrderDetail;

import java.util.List;
import java.util.Map;

public interface OrderService {

    Integer saveOrder(Order order);

    List<Order> selectOrder(Order order);

    Integer saveOrderDetail(List<OrderDetail> orderDetailList);

    List<OrderDetail> selectOrderDetail(Long orderId);

    Integer updateOrder(Order order);
}
