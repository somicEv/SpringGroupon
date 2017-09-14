package com.dao;

import com.common.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CartDao {

    Integer saveDealCart(Cart cart);

    Integer updateDealCount(Cart cart);

    Integer deleteDealFromCart(Map<String,Object> params);

    List<Cart> selectDealCartList(Cart cart);

    Cart selectDealCart(Cart cart);

    List<Cart> selectDealCartByIdList(List<Long> idList);
}
