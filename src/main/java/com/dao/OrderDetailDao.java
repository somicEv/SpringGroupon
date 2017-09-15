package com.dao;

import com.common.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao {

    Integer saveOrderDetail(List<OrderDetail> orderDetails);
}
