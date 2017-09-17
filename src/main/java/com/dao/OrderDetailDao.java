package com.dao;

import com.common.entity.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDetailDao {

    Integer saveOrderDetail(List<OrderDetail> orderDetails);

    List<OrderDetail> selectOrderDetail(Long orderId);
}
