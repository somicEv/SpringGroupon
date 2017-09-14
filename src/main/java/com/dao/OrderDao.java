package com.dao;

import com.common.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {

    Integer saveOrder(Order order);

}
