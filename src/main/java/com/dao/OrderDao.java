package com.dao;

import com.common.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    Integer saveOrder(Order order);

    List<Order> selectOrder(Order order);

    Integer deleteOrder(Long orderId);

    Integer updateOrder(Order order);
}
