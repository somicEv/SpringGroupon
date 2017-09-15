package com.service.api;

import com.common.entity.Order;
import com.common.entity.OrderDetail;

import java.util.List;

public interface OrderService {

    Integer saveOrder(Order order);

    Integer saveOrderDetail(List<OrderDetail> orderDetailList);

}
