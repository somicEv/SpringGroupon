package com.service.api;

import com.common.entity.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    Integer saveDealCart(Cart cart);

    Cart selectDealCart(Cart cart);

    Integer updateDealCart(Cart cart);

    List<Cart> selectDealCartList(Cart cart);
}
