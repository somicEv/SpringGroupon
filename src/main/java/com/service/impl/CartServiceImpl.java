package com.service.impl;

import com.common.entity.Cart;
import com.dao.CartDao;
import com.service.api.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Override
    public Integer saveDealCart(Cart cart) {
        try {
            return cartDao.saveDealCart(cart);
        }catch (Exception e){
            log.error("插入数据库失败",e);
            return 0;
        }
    }

    @Override
    public Integer updateDealCart(Cart cart) {
        try{
            return cartDao.updateDealCount(cart);
        }catch (Exception e){
            log.error("更新数据库失败",e);
            return 0;
        }
    }

    @Override
    public Cart selectDealCart(Cart cart) {
        return cartDao.selectDealCart(cart);
    }

    @Override
    public List<Cart> selectDealCartList(Cart cart){
        return cartDao.selectDealCartList(cart);
    }

    @Override
    public List<Cart> selectDealCartByIdList(List<Long> idList) {
        Map<String, Object> params = new HashMap<>();
        params.put("idList",idList);
        return cartDao.selectDealCartByIdList(params);
    }

    @Override
    public Integer deleteDealFromCart(Map<String, Object> params) {
        return cartDao.deleteDealFromCart(params);
    }
}
